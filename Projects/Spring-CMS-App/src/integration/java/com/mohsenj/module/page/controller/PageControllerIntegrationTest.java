package com.mohsenj.module.page.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mohsenj.BaseIntegrationTest;
import com.mohsenj.module.page.model.Page;
import com.mohsenj.module.page.repository.PageRepository;

@Transactional
public class PageControllerIntegrationTest  extends BaseIntegrationTest{

	private final String PAGE_CONTENT_1 = "<p>page content test 1</p>";
	private final String PAGE_TITLE_1 = "page title test 1";
	private final String PAGE_SLUG_1 = "page-title-test-1";
	
	@Autowired
	private PageRepository pageRepository;
	
	private Page page_1;
	
	@Before
	public void beforeSetUp() {
		page_1 = new Page(PAGE_TITLE_1,PAGE_CONTENT_1);
		page_1.setSlug(PAGE_SLUG_1);
	}
	
	@Test
	public void showPage_can_load_page_to_view() throws Exception {
		pageRepository.save(page_1);
		
		mockMvc.perform(get("/p-"+page_1.getId()+"/"+page_1.getSlug())
	            
	        )
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("page"))

	        .andExpect(model().attribute("page", hasProperty("title",is(page_1.getTitle())) ))
	        .andExpect(model().attribute("page", hasProperty("content",is(page_1.getContent())) ))

	        .andExpect(view().name("site/module/page/showpage"))
	        .andExpect(content().string(containsString(page_1.getTitle())))
	        .andExpect(content().string(containsString(page_1.getContent())));

	}
	
	@Test
	public void showPage_show_404_if_not_found() throws Exception {
		
		mockMvc.perform(get("/p-"+500+"/"+"fake-slug")
	            
	        )
			.andExpect(status().is4xxClientError())
			.andExpect(status().isNotFound())
;
	}
	
	@Test
	public void showPage_redirect_to_true_page_url_if_slug_is_wrong() throws Exception {
		pageRepository.save(page_1);
		
		mockMvc.perform(get("/p-"+page_1.getId()+"/"+"wrong-slug")
	            
	        )
        .andExpect(status().is3xxRedirection())
;
	}
}
