package org.privatechat.user.models;

import org.hibernate.validator.constraints.Email;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="user", uniqueConstraints=@UniqueConstraint(columnNames={"email"}))
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotNull(message="valid email required")
  @Email(message = "valid email required")
  private String email;

  @NotNull(message="valid password required")
  private String password;

  @NotNull(message="valid name required")
  private String fullName;

  private String role;

  private Boolean isPresent;

  public User() {}

  public User(long id) {
    this.id = id;
  }

  public User(String email, String fullName, String password, String role) {
    this.email = email;
    this.fullName = fullName;
    this.password = password;
    this.role = role;
  }

  public String getFullName() {
    return this.fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Boolean getIsPresent() {
    return this.isPresent;
  }

  public void setIsPresent(Boolean stat) {
    this.isPresent = stat;
  }

  public String getRole() {
    return this.role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}