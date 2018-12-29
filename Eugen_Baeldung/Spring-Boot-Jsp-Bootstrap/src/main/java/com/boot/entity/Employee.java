package com.boot.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Chaklader on Oct, 2017
 */
public class Employee {

    private int id;

//    @Size(min=2, max=30)
//    @NotNull
//    @NotEmpty
    private String name;

    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

}

