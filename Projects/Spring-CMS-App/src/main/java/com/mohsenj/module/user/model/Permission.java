package com.mohsenj.module.user.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "permission")
public class Permission {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name="name")
    private String name;
	
	@Column(name="title")
    private String title;
	
	@Column(name = "side", nullable = false, columnDefinition = "TINYINT")
	private Integer side;
	
	@ManyToMany(mappedBy = "permissions")
    private Set<Role> roles;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Integer getSide() {
		return side;
	}

	public void setSide(Integer side) {
		this.side = side;
	}

}
