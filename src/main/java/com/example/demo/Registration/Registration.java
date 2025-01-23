package com.example.demo.Registration;

import com.example.demo.Module.Module;
import com.example.demo.Student.Student;
import jakarta.persistence.*;

@Entity
@Table(name="registration")
public class Registration {

  @Id
  @SequenceGenerator(
          name="registration_sequence",
          sequenceName = "registration_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "registration_sequence"
  )
  private Long id;

  @OneToOne
  @JoinColumn(name = "module_id")
  private Module module;

  @ManyToOne
  @JoinColumn(name = "student_id")
  private Student student;

  public Registration(Long id, Module module) {
    this.id = id;
    this.module = module;
  }

  public Registration(Module module, Student student) {
    this.module = module;
    this.student = student;
  }


  public Registration() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Module getModule() {
    return module;
  }

  public void setModule(Module module) {
    this.module = module;
  }
}
