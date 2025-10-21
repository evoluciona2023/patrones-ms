package com.evoltech.patrones.service;

import org.springframework.stereotype.Service;

@Service
public class MediatorService {
  public String demo() {
    return String.join("\n",
      "Mediator demo → coordinación centralizada de componentes",
      "Alice → (mediador) → Bob: 'Hola Bob'",
      "Bob → (mediador) → Alice: 'Hola Alice'");
  }
}
