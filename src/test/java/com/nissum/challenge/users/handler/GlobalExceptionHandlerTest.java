package com.nissum.challenge.users.handler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

class GlobalExceptionHandlerTest {

  private GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

  @Test
  void testHandleDataIntegrityViolationException() {

    DataIntegrityViolationException exception = new DataIntegrityViolationException("Mensaje de error");

    ResponseEntity<Map<String, String>> response = globalExceptionHandler.handleDataIntegrityViolationException(exception);

    Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    Assertions.assertNotNull(response.getBody());
    Assertions.assertTrue(response.getBody().containsKey("email"));
    Assertions.assertEquals("El correo ya registrado.", response.getBody().get("email"));
  }

}