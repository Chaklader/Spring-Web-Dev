package com.mohsenj.module.category.model;

import java.util.Set;

import javax.persistence.*;

import com.mohsenj.core.util.Hierarchically;
import com.mohsenj.module.module.model.Module;

@Entity
@Table(name = "category")
public class Category implements Hierarchically{

	
	
	public Category(String name, Module module, Integer parentId) {
		this.name = name;
		this.module = module;
		this.parentId = parentId;
	}
	
	public Category() {
	}

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="slug")
	private String slug;
	
	@Column(name="parent_id")
	private Integer parentId;
	
	@ManyToOne
	@JoinColumn(name="module_id")
	private Module module;
	

	
	@Column(name = "deleteLock", nullable = false, columnDefinition = "TINYINT")
	private Integer deleteLock;

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

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public int getDeleteLock() {
		return deleteLock;
	}

	public void setDeleteLock(int deleteLock) {
		this.deleteLock = deleteLock;
	}

	@Override
	public String getTitle() {
		return name;
	}
	
	
}
