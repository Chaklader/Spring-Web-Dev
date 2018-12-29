package org.privatechat.user.DTOs;

public class RegistrationDTO {
  private String email;
  private String password;
  private String fullName;

  public RegistrationDTO() {}

  public RegistrationDTO(String email, String fullName, String password) {
    this.email = email;
    this.fullName = fullName;
    this.password = password;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getFullName() {
    return this.fullName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return this.email;
  }

  public String getPassword() {
    return this.password;
  }
}