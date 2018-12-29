package com.mohsenj.module.module.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "module")
public class Module {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;

	@Column(name="title")
	private String title;
	
	@Column(name = "status", nullable = false, columnDefinition = "TINYINT")
	private Integer status;
	
	@Column(name = "createdAt", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
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
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
