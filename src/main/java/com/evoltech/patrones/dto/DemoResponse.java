package com.evoltech.patrones.dto;

public class DemoResponse {
  private String patron;
  private String output;
  public DemoResponse() {}
  public DemoResponse(String patron, String output) { this.patron = patron; this.output = output; }
  public String getPatron() { return patron; }
  public void setPatron(String patron) { this.patron = patron; }
  public String getOutput() { return output; }
  public void setOutput(String output) { this.output = output; }
}
