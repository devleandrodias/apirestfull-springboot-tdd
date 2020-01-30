package com.devleandro.wallet.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

/**
 * UserDto DTO - Data Transfer Object
 */
@Data
public class UserDto {

  private Long id;

  @Email(message = "Email inválido")
  private String email;

  @Length(min = 3, max = 50, message = "Nome deve conter entre 3 e 50 caracteres")
  private String name;

  @NotNull
  @Length(min = 6, message = "Senha deve ter mínimo 6 caracteres")
  private String password;
}