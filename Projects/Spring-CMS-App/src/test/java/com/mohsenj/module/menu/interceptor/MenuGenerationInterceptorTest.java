package com.mohsenj.module.menu.interceptor;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import com.mohsenj.module.menu.service.MenuService;

@RunWith(MockitoJUnitRunner.class)
public class MenuGenerationInterceptorTest {

	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	Object handler;
	
	@Mock
	private MenuService menuService;;
	
	ModelAndView modelAndView = new ModelAndView();
	
	@InjectMocks
	private MenuGenerationInterceptor menuGenerationInterceptor = new MenuGenerationInterceptor();
	
	@Test
	public void postHandle_ifInFrontSideAddHasMainMenuStr() {
		
		when(request.getRequestURI()).thenReturn(new String("/blah/blah"));

		//
		menuGenerationInterceptor.postHandle(request, response,handler,modelAndView);
		
		//
		assertTrue(modelAndView.getModelMap().containsKey("mainMenuStr"));
	}
	
	@Test
	public void postHandle_ifNotInFrontSideDoNotAddMainMenuStr() {
		
		when(request.getRequestURI()).thenReturn(new String("/admin/blah/blah"));

		//
		menuGenerationInterceptor.postHandle(request, response,handler,modelAndView);
		
		//
		assertFalse(modelAndView.getModelMap().containsKey("mainMenuStr"));
	}
	
}
