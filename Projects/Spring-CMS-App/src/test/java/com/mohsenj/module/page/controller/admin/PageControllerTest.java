package com.mohsenj.module.page.controller.admin;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.category.service.CategoryService;
import com.mohsenj.module.module.service.ModuleService;
import com.mohsenj.module.page.model.Page;
import com.mohsenj.module.page.service.PageService;
import com.mohsenj.module.page.validator.PageValidator;

@RunWith(MockitoJUnitRunner.class)
public class PageControllerTest {


	@Mock
	private PageService pageService;

	@Mock
	private RedirectAttributes redirectAttribute;
	
	@Mock
	private PageValidator pageValidator;
	
	@Mock
	private BindingResult bindingResult;
	
	@InjectMocks
	PageController pageController = new PageController();
	
	private ExtendedModelMap modelMap;
	
	private final String MODULE_TEMPLATE_ROOT = "admin/module/category/";
	
	@Before
    public void setup() {
		modelMap = new ExtendedModelMap();
	}

	
	@Test
    public void creatingAPage_withNOError() {

		Page entityForm = new Page("test name", "test content");
		
		when(bindingResult.hasErrors()).thenReturn(false); // without error
		String viewName = pageController.store(entityForm , redirectAttribute, bindingResult, modelMap);
		
		//
		verify(pageService).save(entityForm);

    }
	
	@Test
    public void onSave_withError() {
		
		
		Page entityForm = new Page("test name", "test content");
		
		when(bindingResult.hasErrors()).thenReturn(true); // with error
		String viewName = pageController.store(entityForm , redirectAttribute, bindingResult, modelMap);
		
		//
		//verifyZeroInteractions(categoryService);
		assertEquals("admin/module/page/create", viewName);
	}
	

}
