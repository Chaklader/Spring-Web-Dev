package com.boot.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Chaklader on Oct, 2017
 */
@Entity
@Table(name = "User")
public class User {

    // form:hidden - hidden value
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // form:input - textbox
    @Column(name = "name", columnDefinition = "VARCHAR(30)", nullable = false)
    String name;

    // form:input - textbox
    @Column(name = "email", columnDefinition = "VARCHAR(50)", nullable = false)
    String email;

    // form:input - password
    @Column(name = "password", columnDefinition = "VARCHAR(20)", nullable = false)
    String password;

    // form:textarea - textarea
    @Column(name = "address", columnDefinition = "VARCHAR(255)")
    String address;

    // form:input - password
    @Transient
    String confirmPassword;

    // form:checkbox - single checkbox
    @Column(name = "newsletter")
    boolean newsletter;

    // form:radiobutton - radio button
    @Column(name = "sex", columnDefinition = "VARCHAR(1)")
    String sex;

    // form:radiobuttons - radio button
    @Column(name = "number")
    Integer number;

    // form:select - form:option - dropdown - single select
    @Column(name = "country", columnDefinition = "VARCHAR(10)")
    String country;

    // form:checkboxes - multiple checkboxes
    @ElementCollection
    @Column(name = "framework", columnDefinition = "VARCHAR(500)")
    List<String> framework;

    // form:select - multiple=true - dropdown - multiple select
    @ElementCollection
    @Column(name = "skill", columnDefinition = "VARCHAR(500)")
    List<String> skill;

    //Check if this is for New of Update
    public boolean isNew() {
        return (this.id == null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }

    public List<String> getFramework() {
        return framework;
    }

    public void setFramework(List<String> framework) {
        this.framework = framework;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getSkill() {
        return skill;
    }

    public void setSkill(List<String> skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (isNewsletter() != user.isNewsletter()) return false;
        if (!getId().equals(user.getId())) return false;
        if (!getName().equals(user.getName())) return false;
        if (!getEmail().equals(user.getEmail())) return false;
        if (getAddress() != null ? !getAddress().equals(user.getAddress()) : user.getAddress() != null) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (getConfirmPassword() != null ? !getConfirmPassword().equals(user.getConfirmPassword()) : user.getConfirmPassword() != null)
            return false;
        if (!getFramework().equals(user.getFramework())) return false;
        if (getSex() != null ? !getSex().equals(user.getSex()) : user.getSex() != null) return false;
        if (getNumber() != null ? !getNumber().equals(user.getNumber()) : user.getNumber() != null) return false;
        if (getCountry() != null ? !getCountry().equals(user.getCountry()) : user.getCountry() != null) return false;
        return getSkill() != null ? getSkill().equals(user.getSkill()) : user.getSkill() == null;
    }

    @Override
    public int hashCode() {

        int result = getId().hashCode();

        result = 31 * result + getName().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + (getConfirmPassword() != null ? getConfirmPassword().hashCode() : 0);
        result = 31 * result + (isNewsletter() ? 1 : 0);
        result = 31 * result + getFramework().hashCode();
        result = 31 * result + (getSex() != null ? getSex().hashCode() : 0);
        result = 31 * result + (getNumber() != null ? getNumber().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getSkill() != null ? getSkill().hashCode() : 0);
        return result;
    }
}