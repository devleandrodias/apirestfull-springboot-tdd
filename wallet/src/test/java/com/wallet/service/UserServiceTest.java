package com.wallet.service;

import com.wallet.entity.User;
import com.wallet.repository.UserRepository;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Aqui criamos um teste para a busca do email na classe de serviço
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {

  @MockBean
  UserRepository repository;

  // Auto injetar a classe de service
  @Autowired
  UserService service;

  /**
   * Usando o Mockito para mocar os dados, quando o método findByEmailEquals for
   * acionado a gente retornar um opcional new User
   */
  @Before
  public void setUp() {
    BDDMockito.given(repository.findByEmailEquals(Mockito.anyString())).willReturn(Optional.of(new User()));
  }

  @Test
  public void testFindByEmail() {
    Optional<User> user = service.findByEmail("email@test.com");

    assertTrue(user.isPresent());
  }
}