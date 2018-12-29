package com.mohsenj.module.category.service;

import java.util.List;

import com.mohsenj.module.category.model.Category;

public interface CategoryService {

	public void save(Category category);
	
	public Category findById(Integer id);
	
	public void update(Category category);
	
	public List<Category> findAll();

	public void deleteById(Integer id);
	
	public List<Category> findByModuleId(int module_id);

	public List<Category> getModuleCategoriesByName(String string);
}
