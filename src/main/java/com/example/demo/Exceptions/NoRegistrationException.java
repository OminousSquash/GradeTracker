package com.example.demo.Exceptions;

public class NoRegistrationException extends Exception {
  public NoRegistrationException(String message) {
    super(message);
  }
  public NoRegistrationException() {
    super("Registration is not found");
  }
}
