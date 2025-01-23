package com.example.demo.DTOs;

public class ModuleDTO {
  private Long module_id;

  public ModuleDTO(Long module_id) {
    this.module_id = module_id;
  }

  public Long getModule_id() {
    return module_id;
  }

  public void setModule_id(Long module_id) {
    this.module_id = module_id;
  }
}
