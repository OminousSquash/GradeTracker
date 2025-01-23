package com.example.demo.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepository extends JpaRepository<Student,Long> {

}
