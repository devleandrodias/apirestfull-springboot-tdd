package com.devleandro.wallet.service.interfaces;

import java.util.Optional;

import com.devleandro.wallet.entity.User;

/**
 * UserService
 */
public interface UserService {

  User save(User user);

  Optional<User> findByEmail(String email);
}