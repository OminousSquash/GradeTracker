package com.example.demo.Exceptions;

public class NoGradeAvailableException extends Exception{
  public NoGradeAvailableException(String message) {
    super(message);
  }
  public NoGradeAvailableException() {
    super("Grade is not available");
  }
}
