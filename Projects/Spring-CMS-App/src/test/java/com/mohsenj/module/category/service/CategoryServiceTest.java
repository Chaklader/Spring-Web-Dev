package com.mohsenj.module.category.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.category.repository.CategoryRepository;
import com.mohsenj.module.module.model.Module;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {

	final Integer ID_NEW1 = 1;
	final String NAME_NEW1 = "test new category";
	final String NAME_NEW1_SLUGGED = "test-new-category";
	
	final Integer PARENT_ID_NEW1 = 3;
	
	@Mock
	private CategoryRepository categoryRepository;
	
	@Mock Module moduleNew_1;
	
	@InjectMocks
	private CategoryServiceImp categoryService = new CategoryServiceImp();
	
	private Category categoryNew;
	
	@Before
    public void setup() {
		categoryNew = new Category(NAME_NEW1, moduleNew_1, null);
		//
		when(moduleNew_1.getId()).thenReturn(1);
		
		categoryService.save(categoryNew);
	}
	
	@Test
	public void onSave_doSlugify() {
        assertThat(categoryNew.getSlug(), equalTo(NAME_NEW1_SLUGGED));
     //   assertTrue(false);
	}
	
	@Test
	public void onSave_category_isPersisted() {
		verify(categoryRepository).save(categoryNew);
	}
}
