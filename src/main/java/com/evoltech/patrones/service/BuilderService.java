package com.evoltech.patrones.service;

import org.springframework.stereotype.Service;

@Service
public class BuilderService {
  public String demo() {
    return "Builder demo → construyendo objeto paso a paso\nResultado: {marca:'EvoTech', modelo:'GT-2025', color:'Negro', puertas:4}";
  }
}
