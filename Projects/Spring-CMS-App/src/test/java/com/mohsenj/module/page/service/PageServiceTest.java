package com.mohsenj.module.page.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.category.repository.CategoryRepository;
import com.mohsenj.module.module.model.Module;
import com.mohsenj.module.page.model.Page;
import com.mohsenj.module.page.repository.PageRepository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class PageServiceTest {

	final Integer ID_NEW1 = 1;
	final String NAME_NEW1 = "test new category";
	final String NAME_NEW1_SLUGGED = "test-new-category";
	final String CONTENT_NEW1 = "test new CONTENT OF PAGE";
	
	final Integer PARENT_ID_NEW1 = 3;
	
	@Mock
	private PageRepository pageRepository;

	@Mock
	private RedirectAttributes redirectAttribute;
	
	@Mock
	private BindingResult bindingResult;
	
	@InjectMocks
	private PageServiceImp pageService = new PageServiceImp();
	
	private Page pageNew;
	
	private List<Page> pagesListNew;
	
	@Before
    public void setup() {
		pageNew = new Page(NAME_NEW1, CONTENT_NEW1);
		pageNew.setId(1);
		
		pagesListNew = Arrays.asList(pageNew);
		//
	}
	
	@Test
	public void onSave_doSlugify() {
		
		pageService.save(pageNew);
		
        assertThat(pageNew.getSlug(), equalTo(NAME_NEW1_SLUGGED));
     //   assertTrue(false);
	}
	
	@Test
	public void onSave_isPersisted() {
		pageService.save(pageNew);
		
		verify(pageRepository).save(pageNew);
	}
	
	@Test
	public void findAll_isPersisted() {
		Page p1 = new Page();
		List<Page> expected = new LinkedList<Page>();
		expected.add(p1);
		
		when(pageRepository.findAll()).thenReturn(expected);
		
		List<Page> result = pageService.findAll();
		
		//
		verify(pageRepository).findAll();
		assertEquals(expected, result);
	}
	
	@Test
	public void testFindById() {
		Integer pId=1;
		Page p1 = new Page();
		p1.setId(pId);

		
		when(pageRepository.findOne(pId)).thenReturn(p1);
		
		Page result = pageService.findById(pId);
		
		//
		verify(pageRepository).findOne(pId);
		assertEquals(p1, result);
	}
	
	@Test
	public void testUpdatePage() {
		Integer pId=1;
		Page p1 = new Page();
		p1.setTitle("new title");
		p1.setId(pId);

		
		when(pageRepository.findOne(pId)).thenReturn(p1);
		
		pageService.update(p1);
		
		//
		assertThat(p1.getSlug(), equalTo("new-title"));
		verify(pageRepository).save(p1);
	}
	
	@Test
	public void testDeletePage() {
		Integer pId=1;
		Page p1 = new Page();
		p1.setTitle("new title");
		p1.setId(pId);
		
		//
		pageService.delete(p1);
		
		//
		verify(pageRepository).delete(p1.getId());
	}
	
	
	@Test
	public void deleteById_call_repository() {
		Integer pId=1;

		
		//
		pageService.deleteById(pId);
		
		//
		verify(pageRepository).delete(pId);
	}
	
	@Test
	public void getPageSelectOptionRaw_return_proper_string() {
		
		String expected = "<option value=\""+pageNew.getId()+"\">"+pageNew.getTitle()+"</option>";
		when(pageRepository.findAll()).thenReturn(pagesListNew);
		
		String result = pageService.getPageSelectOptionRaw();
		
		assertEquals(expected, result);
	}
	
	@Test
	public void getPageSelectOptionRaw_return_empty_string_if_no_page() {
		
		String expected = "";
		List<Page> pages=null;
		when(pageRepository.findAll()).thenReturn(pages);
		
		String result = pageService.getPageSelectOptionRaw();
		
		assertEquals(expected, result);
	}
	
}
