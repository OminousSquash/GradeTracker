package com.example.demo.Grade;

import com.example.demo.DTOs.GradeDTO;
import com.example.demo.Module.Module;
import com.example.demo.Module.ModuleRepository;
import com.example.demo.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Student.StudentRepository;

import java.util.Optional;

@Service
public class GradeService {

  private final GradeRepository gradeRepository;
  private final StudentRepository studentRepository;
  private final ModuleRepository moduleRepository;

  @Autowired
  public GradeService(GradeRepository gradeRepository, StudentRepository studentRepository, ModuleRepository moduleRepository) {
    this.gradeRepository = gradeRepository;
    this.studentRepository = studentRepository;
    this.moduleRepository = moduleRepository;
  }

  public void addGrade(GradeDTO gradeDTO) {
    Long student_id = gradeDTO.getStudent_id();
    Long module_id = gradeDTO.getModule_id();
    int score = gradeDTO.getScore();
    Optional<Student> student = studentRepository.findById(student_id);
    Optional<Module> module = moduleRepository.findById(module_id);
    Boolean scoreCheck = (0 <= score && score <= 100);
    if (!student.isPresent() || !module.isPresent() || !scoreCheck) {
      throw new IllegalArgumentException("Student or Module not found or invalid score entered");
    }
    Grade grade = new Grade(score, module.get(), student.get());
    gradeRepository.save(grade);
  }
}
