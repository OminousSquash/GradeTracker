package com.example.demo.Module;
import jakarta.persistence.*;


@Entity
@Table(name="module")
public class Module {
  @Id
  @SequenceGenerator(
          name="module_sequence",
          sequenceName = "module_sequence",
          allocationSize = 1
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "module_sequence"
  )
  private Long id;
  private String code;
  private String name;
  private Boolean mnc;

  public Module(Long id, String code, String name, Boolean mnc) {
    this.id = id;
    this.code = code;
    this.name = name;
    this.mnc = mnc;
  }

  public Module(String code, String name, Boolean mnc) {
    this.code = code;
    this.name = name;
    this.mnc = mnc;
  }

  public Module() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getMnc() {
    return mnc;
  }

  public void setMnc(Boolean mnc) {
    this.mnc = mnc;
  }
}
