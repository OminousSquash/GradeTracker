package com.example.demo.Grade;

import com.example.demo.Module.Module;
import com.example.demo.Student.Student;
import jakarta.persistence.*;


@Entity
@Table(name="grade")
public class Grade {
  @Id
  @SequenceGenerator(
          name = "grade_sequence",
          sequenceName = "grade_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "grade_sequence"
  )
  private Long id;

  private int score;

  @OneToOne
  @JoinColumn(name="module_id")
  private Module module;

  @ManyToOne
  @JoinColumn(name="student_id")
  private Student student;

  public Grade(int score, Module module, Student student) {
    this.score = score;
    this.module = module;
    this.student = student;
  }

  public Grade() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public Module getModule() {
    return module;
  }

  public void setModule(Module module) {
    this.module = module;
  }

  public Student getStudent(Student student) {
    return this.student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }
}
