package org.privatechat.user.DTOs;

public class UserDTO {
  private long id;

  private String email;

  private String fullName;

  public UserDTO() {}

  public UserDTO(long id, String email, String fullName) {
    this.id = id;
    this.email = email;
    this.fullName = fullName;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getId() {
    return this.id;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return this.email;
  }

  public String getFullName() {
    return this.fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }
}