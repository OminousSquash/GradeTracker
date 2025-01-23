package com.example.demo.Registration;

import com.example.demo.DTOs.RegistrationDTO;
import com.example.demo.Module.Module;
import com.example.demo.Module.ModuleRepository;
import com.example.demo.Student.Student;
import com.example.demo.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {
  private final RegistrationRepository registrationRepository;
  private final StudentRepository studentRepository;
  private final ModuleRepository moduleRepository;

  @Autowired
  public RegistrationService(RegistrationRepository registrationRepository, StudentRepository studentRepository, ModuleRepository moduleRepository) {
    this.moduleRepository = moduleRepository;
    this.registrationRepository = registrationRepository;
    this.studentRepository = studentRepository;
  }
  public void addRegistration(RegistrationDTO registrationDTO) {
    Long student_id = registrationDTO.getStudent_id();
    Long module_id = registrationDTO.getModule_id();
    Optional<Student> student = studentRepository.findById(student_id);
    Optional<Module> module = moduleRepository.findById(module_id);
    if (!(student.isPresent() && module.isPresent())) {
      throw new IllegalArgumentException("Student or Module not found");
    }
    Registration registration = new Registration(module.get(), student.get());
    registrationRepository.save(registration);
  }
}
