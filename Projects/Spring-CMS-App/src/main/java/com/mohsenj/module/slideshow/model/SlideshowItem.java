package com.mohsenj.module.slideshow.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "slideshowitem")
public class SlideshowItem {

	public SlideshowItem() {
		
	}
	
	public SlideshowItem(Slideshow slideshow) {
		setSlideshow(slideshow);
	}
	
	public SlideshowItem(Slideshow slideshow, String title, String fileName) {
		setSlideshow(slideshow);
		setTitle(title);
		setFileName(fileName);
	}
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="title")
	private String title;

	@Column(name="fileName")
	private String fileName;
	
	@Column(columnDefinition = "TEXT")
	private String data;
	
	@Column(name = "ordering", nullable = false, columnDefinition = "SMALLINT")
	private Integer ordering;
		
	@ManyToOne(optional = false, targetEntity=Slideshow.class)
    @JoinColumn(name = "slideshow_id", referencedColumnName = "id")
	private Slideshow slideshow;

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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getOrdering() {
		return ordering;
	}

	public void setOrdering(Integer ordering) {
		this.ordering = ordering;
	}

	public Slideshow getSlideshow() {
		return slideshow;
	}

	public void setSlideshow(Slideshow slideshow) {
		this.slideshow = slideshow;
		
		slideshow.addSlideshowItems(this);
	}
	
}
