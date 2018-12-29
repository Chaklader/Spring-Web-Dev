package com.mohsenj.module.user.model;


import javax.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name="name")
    private String name;
	
	@Column(name="title", columnDefinition = "VARCHAR(70)")
    private String title;

	@Column(name = "side", nullable = false, columnDefinition = "TINYINT")
	private Integer side;
	
	@ManyToMany(mappedBy = "roles")
    private Set<User> users;

	@ManyToMany
    @JoinTable(
    		name = "role_permission",
    		joinColumns = @JoinColumn(name = "role_id"),
    		inverseJoinColumns = @JoinColumn(name = "permission_id")
    		)
    private Set<Permission> permissions;
	
	public boolean hasPermission(String permissionStr) {
		
		for(Permission permission : permissions) {
			
			if(permissionStr.equals(permission.getName())) {
				return true;
			}
			
		}
		
		return false;
	}
	
    public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

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

    
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getSide() {
		return side;
	}

	public void setSide(Integer side) {
		this.side = side;
	}
    
	public boolean hasPermission(Permission permission) {
		
		for(Permission p : this.permissions) {
			if(p.getId() == permission.getId()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 5;
		hash = 83 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Role other = (Role) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}
}
