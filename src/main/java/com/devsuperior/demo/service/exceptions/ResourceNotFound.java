package com.devsuperior.demo.service.exceptions;

public class ResourceNotFound extends RuntimeException {
  public ResourceNotFound(String message) {
    super(message);
  }
}
