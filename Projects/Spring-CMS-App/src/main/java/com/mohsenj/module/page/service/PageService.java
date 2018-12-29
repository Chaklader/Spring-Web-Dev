package com.mohsenj.module.page.service;

import java.util.List;

import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.page.model.Page;

public interface PageService {

	void save(Page page);

	List<Page> findAll() ;

	Page findById(Integer pId);
	
	void update(Page p1);
	
	void delete(Page page);

	void deleteById(int id);
	
	String getPageSelectOptionRaw();

	String getPageSelectOptionRawWithSelected(Long referId);
}
