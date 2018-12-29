package com.mohsenj.module.slideshow.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "slideshow")
public class Slideshow {

	public Slideshow() {
		slideshowItems = new HashSet<SlideshowItem>();
	}
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="title")
	private String title;
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "slideshow", targetEntity=SlideshowItem.class)
	private Set<SlideshowItem> slideshowItems;

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

	public Set<SlideshowItem> getSlideshowItems() {
		return slideshowItems;
	}

	public void setSlideshowItems(Set<SlideshowItem> slideshowItems) {
		this.slideshowItems = slideshowItems;
	}
	
	public void addSlideshowItems(SlideshowItem slideshowItem) {
		slideshowItems.add(slideshowItem);
	}
	
	/**
	 * remove slideshow item from collection
	 * find it by it's id
	 * @param SlideshowItem slideshowItem
	 */
	public Boolean removeSlideshowItem(SlideshowItem slideshowItem) {

		boolean isRemoved = false;
		
		for (Iterator<SlideshowItem> iterator = this.slideshowItems.iterator(); iterator.hasNext();) {
			SlideshowItem item =  iterator.next();
			
			if(item.getId() == slideshowItem.getId()) {
				iterator.remove();
				isRemoved=true;
			}
		      
		}
		
		return isRemoved;

	}
    
}
