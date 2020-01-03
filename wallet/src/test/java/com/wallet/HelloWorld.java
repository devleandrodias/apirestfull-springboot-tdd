package com.wallet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Primeira classe de testes com Java
 */

@SpringBootTest
public class HelloWorld {

  @Test
  public void testHelloWorld() {
    assertEquals(1, 1);
  }
}