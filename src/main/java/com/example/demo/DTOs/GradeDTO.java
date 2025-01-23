package com.example.demo.DTOs;

public class GradeDTO {
  private int score;
  private Long student_id;
  private Long module_id;

  public GradeDTO(int score, Long student_id, Long module_id) {
    this.score = score;
    this.student_id = student_id;
    this.module_id = module_id;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
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
