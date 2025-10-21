package com.evoltech.patrones.service;

import org.springframework.stereotype.Service;

@Service
public class BridgeService {
  public String demo() {
    return String.join("\n",
      "Bridge demo → separando Abstracción de Implementación",
      "Enviando Notificación[ALERTA] por Plataforma[WEB]",
      "Enviando Mensaje por Plataforma[MÓVIL]");
  }
}
