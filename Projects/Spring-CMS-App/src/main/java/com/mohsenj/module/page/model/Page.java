package com.mohsenj.module.page.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.comment.model.Comment;

import javax.persistence.*;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "page")
public class Page {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="title")
	private String title;

	@Column(columnDefinition = "TEXT")
	private String content;

	@Column(name="slug")
	private String slug;
	
	public Page() {
	}
	
	public Page(String title, String content) {

		this.title=title;
		this.content=content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}
}
