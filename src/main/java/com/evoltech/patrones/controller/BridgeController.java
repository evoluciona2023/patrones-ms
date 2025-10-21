package com.evoltech.patrones.controller;

import com.evoltech.patrones.dto.DemoResponse;
import com.evoltech.patrones.service.BridgeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bridge")
public class BridgeController {
  private final BridgeService service;
  public BridgeController(BridgeService service) { this.service = service; }
  @GetMapping("/demo")
  public DemoResponse demo() { return new DemoResponse("bridge", service.demo()); }
}
