package com.example.demo.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {
  @Query(value = "SELECT * FROM student WHERE email=?1", nativeQuery = true)
  Optional<Student> findByEmail(String email);

  @Query(value = "SELECT * FROM student WHERE user_name = ?1", nativeQuery = true)
  Optional<Student> findByUsername(String username);
}
