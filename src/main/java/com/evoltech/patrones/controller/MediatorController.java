package com.evoltech.patrones.controller;

import com.evoltech.patrones.dto.DemoResponse;
import com.evoltech.patrones.service.MediatorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mediator")
public class MediatorController {
  private final MediatorService service;
  public MediatorController(MediatorService service) { this.service = service; }
  @GetMapping("/demo")
  public DemoResponse demo() { return new DemoResponse("mediator", service.demo()); }
}
