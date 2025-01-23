package com.example.demo.Module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleService {

  private final ModuleRepository moduleRepository;

  @Autowired
  public ModuleService(ModuleRepository moduleRepository) {
    this.moduleRepository = moduleRepository;
  }

  public void addModule(Module module) {
    moduleRepository.save(module);
  }
}
