package com.mohsenj.module.user.model;


import java.util.Set;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "user")
public class User {
	
	public User() {
        super();
        this.enabled=false;
    }
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Long id;
    
	@Column(name = "enabled")
    private Boolean enabled;
	
	@Column(name = "email")
	private String email;
	
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    private String passwordConfirm;
    
    @ManyToMany
    @JoinTable(
    		name = "user_role",
    		joinColumns = @JoinColumn(name = "user_id"),
    		inverseJoinColumns = @JoinColumn(name = "role_id")
    		)
    private Set<Role> roles;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    public Boolean hasRole(String role) {
    	return true;
    }

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
    
}
