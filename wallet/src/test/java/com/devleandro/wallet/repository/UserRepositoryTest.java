package com.devleandro.wallet.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import com.devleandro.wallet.entity.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

  @Autowired
  UserRepository userRepository;

  @Before
  public void setUp() {
    User user = new User();

    user.setName("Set up User");
    user.setPassword("Senha123!");
    user.setEmail(EMAIL);

    userRepository.save(user);
  }

  @After
  public void tearDown() {
    userRepository.deleteAll();
  }

  @Test
  public void testSave() {
    User user = new User();

    user.setName("Test");
    user.setPassword("123456");
    user.setEmail("test@gmail.com");

    User response = userRepository.save(user);

    assertNotNull(response);
  }

  @Test
  public void testFindByEmail() {
    Optional<User> response = userRepository.findByEmailEquals(EMAIL);

    assertTrue(response.isPresent());
    assertEquals(response.get().getEmail(), EMAIL);
  }
}