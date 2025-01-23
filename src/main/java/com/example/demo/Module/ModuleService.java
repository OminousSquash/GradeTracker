package com.example.demo.Module;

import com.example.demo.DTOs.ModuleDTO;
import com.example.demo.Exceptions.ModuleAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModuleService {

  private final ModuleRepository moduleRepository;

  @Autowired
  public ModuleService(ModuleRepository moduleRepository) {
    this.moduleRepository = moduleRepository;
  }

  public void addModule(Module module) {
    String code = module.getCode();
    Optional<Module> optionalModule = moduleRepository.findByCode(code);
    if (optionalModule.isPresent()) {
      throw new ModuleAlreadyExistsException();
    }
    moduleRepository.save(module);
  }
}
