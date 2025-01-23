package com.example.demo.Module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.Module.ModuleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/module")
public class ModuleController {

  private final ModuleService moduleService;

  @Autowired
  public ModuleController(ModuleService moduleService) {
    this.moduleService = moduleService;
  }

  @PostMapping
  public void addModule(@RequestBody Module module) {
    moduleService.addModule(module);
  }
}
