package com.evoltech.patrones.controller;

import com.evoltech.patrones.dto.DemoResponse;
import com.evoltech.patrones.service.BuilderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/builder")
public class BuilderController {
  private final BuilderService service;
  public BuilderController(BuilderService service) { this.service = service; }
  @GetMapping("/demo")
  public DemoResponse demo() { return new DemoResponse("builder", service.demo()); }
}
