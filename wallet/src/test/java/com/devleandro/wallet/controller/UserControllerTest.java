package com.devleandro.wallet.controller;

import com.devleandro.wallet.dto.UserDto;
import com.devleandro.wallet.entity.User;
import com.devleandro.wallet.service.interfaces.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * UserControllerTest
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

  private static final String EMAIL = "email@test.com";
  private static final String NAME = "Ueser Test";
  private static final String PASSWORD = "123456";
  private static final String URL = "/user";

  @MockBean
  UserService userService;

  @Autowired
  MockMvc mvc;

  @Test
  public void testSave() throws Exception {
    BDDMockito.given(userService.save(Mockito.any(User.class))).willReturn(getMockUser());

    mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload()).contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isCreated());
  }

  public User getMockUser() {
    User user = new User();

    user.setEmail(EMAIL);
    user.setName(NAME);
    user.setPassword(PASSWORD);

    return user;
  }

  public String getJsonPayload() throws JsonProcessingException {
    UserDto dto = new UserDto();

    dto.setEmail(EMAIL);
    dto.setName(NAME);
    dto.setPassword(PASSWORD);

    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(dto);
  }
}