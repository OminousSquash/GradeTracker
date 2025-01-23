package com.example.demo.Student;

import com.example.demo.Grade.Grade;
import com.example.demo.Module.Module;
import com.example.demo.Registration.Registration;
import com.example.demo.Exceptions.NoRegistrationException;
import com.example.demo.Exceptions.NoGradeAvailableException;
import jakarta.persistence.*;
import org.hibernate.generator.Generator;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="student")
public class Student {

  @Id
  @SequenceGenerator(
          name="student_sequence",
          sequenceName = "student_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "student_sequence"
  )

  private Long id;
  private String firstName;
  private String lastName;
  private String userName;
  private String email;

  @OneToMany(
          mappedBy = "student",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<Grade> grades;

  @OneToMany(
          mappedBy = "student",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<Registration> registrations;

  public Student(Long id, String firstName, String lastName, String userName, String email) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.email = email;
    this.grades = new ArrayList<>();
    this.registrations = new ArrayList<>();
  }

  public Student(String firstName, String lastName, String userName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.email = email;
    this.grades = new ArrayList<>();
    this.registrations = new ArrayList<>();
  }

  public Student() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Float computeAverage() {
    float sum = 0;
    for (Grade grade : grades) {
      sum += grade.getScore();
    }
    float average = sum / grades.size();
    return average;
  }

  public void addGrade(Grade g) {
    grades.add(g);
  }

  public Grade getGrade(Module module) throws NoGradeAvailableException {
    for (Grade grade : grades) {
      if (grade.getModule().equals(module)) {
        return grade;
      }
    }
    throw new NoGradeAvailableException("Student does not have grade for: " + module.getCode());
  }
}
