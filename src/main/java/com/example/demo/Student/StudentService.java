package com.example.demo.Student;

import com.example.demo.Grade.Grade;
import com.example.demo.Registration.Registration;
import com.example.demo.Module.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

  private final studentRepository studentRepository;

  @Autowired
  public StudentService(studentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public void addStudentGrade(Long studentId, Grade grade) {
    Optional<Student> student = studentRepository.findById(studentId);
    if (!student.isPresent()) {
      throw new IllegalArgumentException("Student not found");
    }
    Student s = student.get();
    s.addGrade(grade);
    studentRepository.save(s);
  }

  public void addStudent(Student student) {
    studentRepository.save(student);
  }

//  public void addStudentRegistration(Long id, Module module) {
//    Optional<Student> studentOptional = studentRepository.findById(id);
//    if (!studentOptional.isPresent()) {
//
//    }
//    studentOptional.get().registerModule(module);
//    studentRepository.save(studentOptional.get());
//  }
}
