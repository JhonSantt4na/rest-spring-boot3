package com.santt4na.rest_springboot3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // Sempre retornara esse erro
public class ResouseNotFoundException extends RuntimeException {
  public ResouseNotFoundException(String msg) {
    super(msg);
  }

  private static final long serialVersionUID = 1L;

}
