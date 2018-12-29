package com.mohsenj.module.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.category.repository.CategoryRepository;
import com.mohsenj.core.util.StringUtils;

@Service
public class CategoryServiceImp implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void save(Category category) {
		
		category.setSlug(StringUtils.slugify(category.getName()));
		
		category.setDeleteLock(0);
		
		categoryRepository.save(category);
	}

	@Override
	public Category findById(Integer id) {

		return categoryRepository.findById(id);
	}

	@Override
	public void update(Category category) {

		category.setSlug(StringUtils.slugify(category.getName()));
		
		categoryRepository.update(category.getId(), category.getName(), category.getSlug(), category.getModule(), category.getParentId());

	}

	@Override
	public List<Category> findAll() {

		return categoryRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		
		categoryRepository.delete(id);
		
	}
	
	public List<Category> findByModuleId(int module_id) {
		return categoryRepository.findByModuleId(module_id);
	}

	@Override
	public List<Category> getModuleCategoriesByName(String moduleName) {
		return categoryRepository.getModuleCategoriesByName(moduleName);
	}

}
