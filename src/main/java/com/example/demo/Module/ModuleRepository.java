package com.example.demo.Module;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ModuleRepository extends JpaRepository<Module, Long> {

  @Query(value = "SELECT * FROM module WHERE code = ?1",nativeQuery = true)
  Optional<Module> findByCode(String code);
}
