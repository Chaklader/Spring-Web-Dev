package com.mohsenj.module.category.controller.admin;

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

@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {

	@Mock
	private CategoryService categoryService;

	@Mock
	private ModuleService moduleService;

	@Mock
	private RedirectAttributes redirectAttribute;
	
	@Mock
	private BindingResult bindingResult;
	
	@InjectMocks
	CategoryController categoryController = new CategoryController();
	
	private ExtendedModelMap model = new ExtendedModelMap();
	
	private final String MODULE_TEMPLATE_ROOT = "admin/module/category/";
	
	@Before
    public void setup() {
		//
	//	when(moduleNew_1.getId()).thenReturn(1);
		
		
		//categoryService.save(categoryNew);
	}
	
	@Test
    public void indexView() {
        assertThat(categoryController.index(model), is("admin/module/category/index"));
    }
	
	@Test
    public void testListPeopleInGroup() {
		
		List<Category> entities = Arrays.asList(new Category());
        when(categoryService.findAll()).thenReturn(entities);
        ExtendedModelMap modelMap = new ExtendedModelMap();
        String viewName = categoryController.index(modelMap);
		
        //
        assertEquals("admin/module/category/index", viewName);
        assertThat(modelMap, IsMapContaining.hasEntry("entities", (Object) entities));

        /*
        assertThat(modelMap, hasEntry("entities", (Object) entities));
        
		List<Category> entities = categoryService.findAll();
		
		model.addAttribute("entities", entities);
		return MODULE_TEMPLATE_ROOT + "index";
		
        List<Person> expectedPeople = asList(new Person());
        when(mockPeopleService.listPeople("group")).thenReturn(expectedPeople);

        ModelMap modelMap = new ModelMap();
        String viewName = controller.listPeopleInGroup("group", modelMap);

        assertEquals("peopleList", viewName);
        assertThat(modelMap, hasEntry("people", (Object) expectedPeople));
        */
    }
	
	@Test
    public void creatingACatgory_withNOError() {
		
		
		ExtendedModelMap modelMap = new ExtendedModelMap();
		Category entityForm = new Category("test name", null, null);
		
		when(bindingResult.hasErrors()).thenReturn(false); // without error
		String viewName = categoryController.store(entityForm , redirectAttribute, bindingResult, modelMap);
		
		//
		verify(categoryService).save(entityForm);
		assertEquals("redirect:/admin/category/index", viewName);
		
		/*
		
        String username = "username";

        MemberProfile member = new MemberProfile();
        member.setUsername(username);

        given(teamRepository.findById(12345L)).willReturn(member);
        PostForm postForm = new PostForm();

        given(blogService.addPost(eq(postForm), anyString())).willReturn(TEST_POST);
        controller.createPost(principal, postForm, new BindException(postForm, "postForm"), null);
        verify(blogService).addPost(postForm, username);
        */
    }
	
	@Test
    public void creatingACatgory_withError() {
		
		
		ExtendedModelMap modelMap = new ExtendedModelMap();
		Category entityForm = new Category("test name", null, null);
		
		when(bindingResult.hasErrors()).thenReturn(true); // with error
		String viewName = categoryController.store(entityForm , redirectAttribute, bindingResult, modelMap);
		
		//
		//verifyZeroInteractions(categoryService);
		assertEquals("admin/module/category/create", viewName);
	}

}
