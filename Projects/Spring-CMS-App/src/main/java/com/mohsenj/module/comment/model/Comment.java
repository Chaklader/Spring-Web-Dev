package com.mohsenj.module.comment.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@Column(name = "status", nullable = false, columnDefinition = "TINYINT")
	private Integer status;
	
	@Column(name = "createdAt", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name="itemType")
	private String itemType;
	
	@Column(name="itemId")
	private Long itemId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	
}
