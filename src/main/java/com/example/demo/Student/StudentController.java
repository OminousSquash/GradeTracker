package com.example.demo.Student;

import com.example.demo.Exceptions.StudentAlreadyExistsException;
import com.example.demo.Grade.Grade;
import com.example.demo.Module.Module;
import com.example.demo.Registration.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @PostMapping
  public void addStudent(@RequestBody Student student) {
    studentService.addStudent(student);
  }

  @PostMapping("/grade/{id}")
  public void addStudentGrade(@PathVariable("id") Long id, @RequestBody Grade grade) {
    studentService.addStudentGrade(id, grade);
  }

  @PostMapping("/registration/{id}")
  public void addStudentRegistration(@PathVariable("id") Long id, @RequestBody Module module) {
    studentService.addStudentRegistration(id, module);
  }
}
