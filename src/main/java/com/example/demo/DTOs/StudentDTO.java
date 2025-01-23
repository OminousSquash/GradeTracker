package com.example.demo.DTOs;

public class StudentDTO {
  private Long student_id;
  public StudentDTO(Long student_id) {
    this.student_id = student_id;
  }

  public Long getStudent_id() {
    return student_id;
  }

  public void setStudent_id(Long student_id) {
    this.student_id = student_id;
  }
}
