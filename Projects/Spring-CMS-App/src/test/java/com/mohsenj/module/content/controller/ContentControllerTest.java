package com.mohsenj.module.content.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ExtendedModelMap;

import com.mohsenj.core.lib.exception.BadRequestException;
import com.mohsenj.core.lib.exception.ResourceNotFoundException;
import com.mohsenj.module.category.controller.admin.CategoryController;
import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.category.service.CategoryService;
import com.mohsenj.module.content.service.ContentService;

@RunWith(MockitoJUnitRunner.class)
public class ContentControllerTest {

	@Mock
	private ContentService contentService;
	
	@InjectMocks
	ContentController contentController = new ContentController();
	
	private ExtendedModelMap model = new ExtendedModelMap();
	
	private final String MODULE_TEMPLATE_ROOT = "module/content/";
	
	// content
	private final Long contentId1=1L;
	private final String contentSlug1="title-one";
	
	@Test(expected = ResourceNotFoundException.class)
    public void show_ifContentNotFoundThrowError() {

		when(contentService.findByIdForShow(contentId1)).thenReturn(null);
		
		//
		contentController.show(contentId1, contentSlug1, model);
	}
}
