package com.wallet.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallet.dto.UserDTO;
import com.wallet.entity.User;
import com.wallet.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * A camada do controller que é nosso endpoint da nossa API chama os services
 */

// Isso são Annotations
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc // Usando usamos MockMvc
@ActiveProfiles("test")
public class UserControllerTest {

  private static final String EMAIL = "email@test.com";
  private static final String NAME = "name teste";
  private static final String PASSWORD = "123456";
  private static final String URL = "/user";

  @MockBean
  UserService service;

  @Autowired
  MockMvc mvc;

  @Test
  public void testSave() throws Exception {
    BDDMockito.given(service.save(Mockito.any(User.class))).willReturn(getMockUser()); // Mockando os dados

    mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload()).contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
  }

  public User getMockUser() {
    User user = new User();

    user.setEmail(EMAIL);
    user.setName(NAME);
    user.setPassword(PASSWORD);

    return user;
  }

  public String getJsonPayload() throws JsonProcessingException {
    UserDTO dto = new UserDTO();

    dto.setEmail(EMAIL);
    dto.setName(NAME);
    dto.setPassword(PASSWORD);

    // Isso é um mapper fazer conversão do Objeto DTO para String em formato JSON
    ObjectMapper mapper = new ObjectMapper();

    return mapper.writeValueAsString(dto);
  }
}