package com.wallet.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import com.wallet.entity.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UserRepositoryTest
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class UserRepositoryTest {

  private static final String EMAIL = "email@teste.com";

  // Importar ele mesmo
  @Autowired
  UserRepository repository;

  /**
   * Instruções que serão excutadas antes de todas os testes da nossa classe de
   * teste
   */
  @Before
  public void setUp() {
    User user = new User();

    user.setName("Set up User");
    user.setPassword("123456");
    user.setEmail(EMAIL);

    repository.save(user);
  }

  @After
  public void tearDown() {

    repository.deleteAll();
  }

  // Primeiro teste mesmo com erros, pois é assim que funciona TDD

  @Test
  public void testSave() {
    User user = new User();

    user.setName("Teste");
    user.setPassword("1234");
    user.setEmail(EMAIL);

    User response = repository.save(user);

    assertNotNull(response);
  }

  @Test
  public void testFindByEmail() {
    Optional<User> response = repository.findByEmailEquals(EMAIL);

    assertTrue(response.isPresent());
    assertEquals(response.get().getEmail(), EMAIL);
  }
}