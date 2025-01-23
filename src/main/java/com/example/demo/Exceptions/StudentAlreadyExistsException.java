package com.example.demo.Exceptions;

public class StudentAlreadyExistsException extends RuntimeException {
  public StudentAlreadyExistsException(String message) {
    super(message);
  }
  public StudentAlreadyExistsException() {
    super("Student already exists");
  }
}
