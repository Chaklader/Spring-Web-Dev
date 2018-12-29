package com.mohsenj.module.menu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mohsenj.core.util.MiscellaneousUtils;
import com.mohsenj.module.menu.service.MenuService;

public class MenuGenerationInterceptor  extends HandlerInterceptorAdapter {

	@Autowired
	private MenuService menuService;
	
	@Override
	public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
			final ModelAndView modelAndView) {
		System.out.println("hey mj! MenuGenerationInterceptor called");
		if(!MiscellaneousUtils.isAdminSideString(request.getRequestURI().toString())) {
			
			String menuStr = menuService.generateHtmlMenu("mainMenu", 1);
			
			if(modelAndView != null) {
				ModelMap modelmap = modelAndView.getModelMap();
				if(modelmap != null){
					modelmap.addAttribute("mainMenuStr", menuStr);
				}
			}
			
			
		}
		
		
	}

}
