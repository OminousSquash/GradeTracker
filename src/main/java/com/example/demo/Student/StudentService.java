package com.example.demo.Student;

import com.example.demo.Exceptions.NoRegistrationException;
import com.example.demo.Exceptions.StudentAlreadyExistsException;
import com.example.demo.Exceptions.StudentNotFoundException;
import com.example.demo.Grade.Grade;
import com.example.demo.Module.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public void addStudentGrade(Long studentId, Grade grade) {
    Optional<Student> student = studentRepository.findById(studentId);
    if (!student.isPresent()) {
      throw new StudentNotFoundException();
    }
    Student s = student.get();
    try {
      s.addGrade(grade);
      studentRepository.save(s);
    } catch (NoRegistrationException e) {
      throw new RuntimeException(e);
    }
  }

  public void addStudent(Student student) throws StudentAlreadyExistsException {
    // student with same email or username must not exist
    Optional<Student> emailMatches = studentRepository.findByEmail(student.getEmail());
    Optional<Student> usernameMatches = studentRepository.findByUsername(student.getUserName());
    if (emailMatches.isPresent() || usernameMatches.isPresent()) {
      throw new StudentAlreadyExistsException();
    }
    studentRepository.save(student);
  }

  public void addStudentRegistration(Long id, Module module) {
    Optional<Student> studentOptional = studentRepository.findById(id);
    if (!studentOptional.isPresent()) {
      throw new StudentNotFoundException();
    }
    Student s = studentOptional.get();
    s.registerModule(module);
    studentRepository.save(s);
  }
}
