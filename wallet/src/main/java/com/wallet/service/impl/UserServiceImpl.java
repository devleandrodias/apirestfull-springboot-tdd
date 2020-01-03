package com.wallet.service.impl;

import java.util.Optional;

import com.wallet.entity.User;
import com.wallet.repository.UserRepository;
import com.wallet.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe implementação para spring mapear nosso serviço.
 * 
 * A camada de serviço faz implementação das regras de negócio e se comunica com
 * repository.
 */
@Service
public class UserServiceImpl implements UserService {

  // Injetando o repositório
  @Autowired
  UserRepository repository;

  @Override
  public User save(User user) {
    return repository.save(user);
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return repository.findByEmailEquals(email);
  }
}