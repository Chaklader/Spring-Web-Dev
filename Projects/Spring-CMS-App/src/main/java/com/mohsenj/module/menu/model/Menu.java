package com.mohsenj.module.menu.model;

import java.util.Set;

import javax.persistence.*;

import com.mohsenj.core.util.Hierarchically;
import com.mohsenj.module.module.model.Module;

@Entity
@Table(name = "menu")
public class Menu implements Hierarchically{

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="title", columnDefinition = "VARCHAR(50) ")
	private String title;
	
	@Column(name="slug", columnDefinition = "VARCHAR(50)")
	private String slug;
	
	@Column(name="link", columnDefinition = "VARCHAR(2056) ")
	private String link;
	
	@Column(name="itemType", columnDefinition = "VARCHAR(20)")
	private String itemType;
	
	@Column(name="refer_id")
	private Long referId;
	
	@Column(name="parent_id")
	private Integer parentId;
	
	@Column(name = "ordering", nullable = false, columnDefinition = "SMALLINT")
	private Integer ordering;
	
	@Column(name = "status", nullable = false, columnDefinition = "TINYINT")
	private Integer status;
	

	
	@Column(name = "deleteLock", nullable = false, columnDefinition = "TINYINT")
	private Integer deleteLock;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public Integer getParentId() {
		return parentId;
	}

	@Override
	public String getTitle() {
		return title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public Long getReferId() {
		return referId;
	}

	public void setReferId(Long referId) {
		this.referId = referId;
	}

	public Integer getOrdering() {
		return ordering;
	}

	public void setOrdering(Integer ordering) {
		this.ordering = ordering;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getDeleteLock() {
		return deleteLock;
	}

	public void setDeleteLock(Integer deleteLock) {
		this.deleteLock = deleteLock;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Object getHrefLink() {

		if(getLink().isEmpty()) {
			return "#";
		}
		
		return getLink();
	}

}
