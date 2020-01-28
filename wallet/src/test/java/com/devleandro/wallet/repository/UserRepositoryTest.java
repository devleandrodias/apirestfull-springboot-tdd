package com.devleandro.wallet.repository;

import static org.junit.Assert.assertNotNull;

import com.devleandro.wallet.entity.User;

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

  @Autowired
  UserRepository userRepository;

  @Test
  public void testSave() {
    User user = new User();

    user.setName("Test");
    user.setPassword("123456");
    user.setEmail("test@gmail.com");

    User response = userRepository.save(user);

    assertNotNull(response);
  }
}