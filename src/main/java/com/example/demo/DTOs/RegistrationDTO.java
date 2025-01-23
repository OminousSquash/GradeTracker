package com.example.demo.DTOs;

public class RegistrationDTO {
  private Long registration_id;
  private Long student_id;
  private Long module_id;

  public RegistrationDTO(Long registration_id, Long student_id, Long module_id) {
    this.registration_id = registration_id;
    this.student_id = student_id;
    this.module_id = module_id;
  }

  public Long getRegistration_id() {
    return registration_id;
  }

  public void setRegistration_id(Long registration_id) {
    this.registration_id = registration_id;
  }

  public Long getStudent_id() {
    return student_id;
  }

  public void setStudent_id(Long student_id) {
    this.student_id = student_id;
  }

  public Long getModule_id() {
    return module_id;
  }

  public void setModule_id(Long module_id) {
    this.module_id = module_id;
  }
}
