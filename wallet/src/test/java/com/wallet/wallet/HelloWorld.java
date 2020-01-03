package com.wallet.wallet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Primeiro teste em java
 */

@SpringBootTest
public class HelloWorld {

  @Test
  public void testHelloWorld() {
    assertEquals(1, 1);
  }
}