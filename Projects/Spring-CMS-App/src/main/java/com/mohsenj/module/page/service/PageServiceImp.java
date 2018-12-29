package com.mohsenj.module.page.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.category.repository.CategoryRepository;
import com.mohsenj.module.page.model.Page;
import com.mohsenj.module.page.repository.PageRepository;
import com.mohsenj.core.util.StringUtils;

@Service
public class PageServiceImp implements PageService {

	@Autowired
	PageRepository pageRepository;
	
	@Override
	public void save(Page page) {
		updatePageSlugWithTitle(page);
		
		pageRepository.save(page);
	}

	@Override
	public List<Page> findAll() {

		return pageRepository.findAll();
	}

	@Override
	public Page findById(Integer pId) {
		// TODO Auto-generated method stub
		return pageRepository.findOne(pId);
	}
	
	@Override
	public void update(Page p1) {

		updatePageSlugWithTitle(p1);
		pageRepository.save(p1);
	}
	
	private void updatePageSlugWithTitle(Page p){
		p.setSlug(StringUtils.slugify( p.getTitle()) );
	}

	@Override
	public void delete(Page page) {
		pageRepository.delete(page.getId());
		
	}

	@Override
	public void deleteById(int id) {
		pageRepository.delete(id);
		
	}

	/**
	 * return pages as html <option></option> tags
	 */
	@Override
	public String getPageSelectOptionRaw() {

		List<Page> pages = pageRepository.findAll();
		
		String html = "";
		
		if(pages == null) {
			return html;		
		}
		
		for(Page page : pages) {
			html += "<option value=\""+page.getId()+"\">"+page.getTitle()+"</option>";
		}
		
		return html;
	}

	@Override
	public String getPageSelectOptionRawWithSelected(Long referId) {
		int referId_integer = (int) (long)referId;

		List<Page> pages = pageRepository.findAll();
		
		String html = "";
		
		if(pages == null) {
			return html;		
		}
		
		for(Page page : pages) {
			html += "<option value=\""+page.getId()+"\"";
			
			if(page.getId().equals(referId_integer)) {
				html += " selected";
			}
			
			html += ">"+page.getTitle()+"</option>";
		}
		
		return html;
	}

}
