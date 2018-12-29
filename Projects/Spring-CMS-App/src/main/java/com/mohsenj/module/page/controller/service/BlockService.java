package com.mohsenj.module.page.controller.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.content.model.Content;

public interface BlockService {

	public Page<Content> getLatestContents();
	
	public List<Category> getContentCategories();
}
