package com.mohsenj.module.page.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.ExtendedModelMap;

import com.mohsenj.module.category.service.CategoryService;
import com.mohsenj.module.content.model.Content;
import com.mohsenj.module.content.service.ContentService;
import com.mohsenj.module.page.service.PageService;
import com.mohsenj.module.slideshow.service.SlideshowService;

@RunWith(MockitoJUnitRunner.class)
public class PageControllerTest {

	@Mock
	private PageService pageService;
	
	@Mock
	private ContentService contentService;
	
	@Mock
	private CategoryService categoryService;
	
	@Mock
	private SlideshowService slideshowService;
	
	@InjectMocks
	PageController pageController = new PageController();
	
	private ExtendedModelMap model = new ExtendedModelMap();
	private final String MODULE_TEMPLATE_ROOT = "site/module/page/";
	
	@Test
    public void home_() {
		Integer menuId = 1;

		Page<Content> page = new Page<Content>() {

			@Override
			public List<Content> getContent() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getNumber() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int getNumberOfElements() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int getSize() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Sort getSort() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean hasContent() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean hasPrevious() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isFirst() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isLast() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Pageable nextPageable() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Pageable previousPageable() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Iterator<Content> iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public long getTotalElements() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int getTotalPages() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public <S> Page<S> map(Converter<? super Content, ? extends S> arg0) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		when(contentService.getForCatListContents(1, 1,3)).thenReturn(page);
		

		
		String viewName = pageController.home(model);
		
        assertEquals(MODULE_TEMPLATE_ROOT + "home", viewName);
    }
}
