package com.devleandro.wallet.controller;

import javax.validation.Valid;

import com.devleandro.wallet.dto.UserDto;
import com.devleandro.wallet.entity.User;
import com.devleandro.wallet.response.Response;
import com.devleandro.wallet.service.interfaces.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * UserController
 */
@RestController
@RequestMapping("user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  public ResponseEntity<Response<UserDto>> create(@Valid @RequestBody UserDto dto, BindingResult result) {

    Response<UserDto> response = new Response<UserDto>();

    User user = userService.save(this.convertDtoToEntity(dto));

    response.setData(this.convertEntityToDto(user));

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  private User convertDtoToEntity(UserDto dto) {
    User user = new User();

    user.setEmail(dto.getEmail());
    user.setName(dto.getName());
    user.setPassword(dto.getPassword());

    return user;
  }

  private UserDto convertEntityToDto(User entity) {
    UserDto dto = new UserDto();

    dto.setEmail(entity.getEmail());
    dto.setName(entity.getName());
    dto.setPassword(entity.getPassword());

    return dto;
  }
}