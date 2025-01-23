package com.example.demo.Exceptions;

public class ModuleAlreadyExistsException extends RuntimeException {
  public ModuleAlreadyExistsException(String message) {
    super(message);
  }
  public ModuleAlreadyExistsException() {
    super("Module already exists");
  }
}
