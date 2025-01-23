package com.example.demo.Exceptions;

public class StudentNotFoundException extends RuntimeException {
  public StudentNotFoundException(String message) {
    super(message);
  }
  public StudentNotFoundException() {
    super("Student not found");
  }
}
