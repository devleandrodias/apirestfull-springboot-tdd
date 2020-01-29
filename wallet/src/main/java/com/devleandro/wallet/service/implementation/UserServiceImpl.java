package com.devleandro.wallet.service.implementation;

import java.util.Optional;

import com.devleandro.wallet.entity.User;
import com.devleandro.wallet.repository.UserRepository;
import com.devleandro.wallet.service.interfaces.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository userRepository;

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return userRepository.findByEmailEquals(email);
  }
}