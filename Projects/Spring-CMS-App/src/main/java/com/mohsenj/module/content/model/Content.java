package com.mohsenj.module.content.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.comment.model.Comment;

import javax.persistence.*;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "content")
public class Content {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="title")
	private String title;

	@Column(name="slug")
	private String slug;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@Column(name = "status", nullable = false, columnDefinition = "TINYINT")
	private Integer status;
	
	@Column(name = "createdAt", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name="fileName")
	private String fileName;
	
	/* private List<CategoryItem> categoryItem;*/
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

	/*
	@OneToMany
	@JoinColumn(name="itemId2")
	private Set<ContentComment> comments;
	*/
	
	@OneToMany
	@JoinColumn(name = "itemId")
	@Where(clause = "itemType = 'CONTENT'")
	Set<Comment> comments;
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
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
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public boolean hasCategory() {
		
		if(category != null) {
			return true;
		} 
		else {
			return false;
		}
	}

	
	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	
}
