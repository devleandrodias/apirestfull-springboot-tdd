package com.wallet.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.wallet.entity.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * UserRepositoryTest
 */
@ActiveProfiles("test")
@SpringBootTest
public class UserRepositoryTest {

  // Importar ele mesmo
  @Autowired
  UserRepository repository;

  // Primeiro teste mesmo com erros, pois é assim que funciona TDD
  @Test
  public void testSave() {
    User user = new User();

    user.setName("Teste");
    user.setPassword("1234");
    user.setEmail("teste@test.com");

    User response = repository.save(user);

    assertNotNull(response);
  }
}