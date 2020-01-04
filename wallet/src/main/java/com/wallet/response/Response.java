package com.wallet.response;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response
 */
@Getter
@Setter
@NoArgsConstructor // Seja criado um construtor sem parâmetros
public class Response<T> { // T Genérico

  private T data; // Sucesso payload de resposta no data
  private List<String> errors; // Caso der erro lista de erros
}