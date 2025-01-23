package com.example.demo.Grade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.DTOs.*;

@RestController
@RequestMapping("/grade")
public class GradeController {
  private final GradeService gradeService;

  @Autowired
  public GradeController(GradeService gradeService) {
    this.gradeService = gradeService;
  }

  @PostMapping
  public void addGrade(@RequestBody GradeDTO gradeDTO) {
    gradeService.addGrade(gradeDTO);
  }
}
