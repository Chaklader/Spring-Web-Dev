package com.mohsenj.module.slideshow.controller.admin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mohsenj.core.lib.exception.BadRequestException;
import com.mohsenj.core.lib.exception.ResourceNotFoundException;
import com.mohsenj.module.menu.controller.admin.MenuController;
import com.mohsenj.module.slideshow.model.Slideshow;
import com.mohsenj.module.slideshow.service.SlideshowService;

@RunWith(MockitoJUnitRunner.class)
public class SlideshowControllerTest {

	@Mock
	private SlideshowService slideshowService;
	
	@Mock
	HttpServletRequest request;
	
	@Mock
	private RedirectAttributes redirectAttributes;
	
	@InjectMocks
	SlideshowController slideshowController;
	
	private Map<String, String> data = new TreeMap<String, String>();

	
	private ExtendedModelMap model = new ExtendedModelMap();
	
	private final String MODULE_TEMPLATE_ROOT = "admin/module/slideshow/";
	
	
	@Test
	public void index_testModelData() {
		
		String viewName = slideshowController.index(model);
		
		//
		verify(slideshowService).findAll();
        assertEquals(MODULE_TEMPLATE_ROOT + "index", viewName);
     //   assertThat(model, IsMapContaining.hasEntry("entityForm", menu));
        assertThat(model, IsMapContaining.hasKey("entities"));
	}
	
	@Test
	public void editItems_testModelData() {
		Integer slideshowId=1;
		Slideshow slideshow = new Slideshow();
		//
		when(slideshowService.getForEditItems(slideshowId)).thenReturn(slideshow);
		
		//
		String viewName = slideshowController.editItems(model, slideshowId);
		
		//
		verify(slideshowService).getForEditItems(slideshowId);
        assertEquals(MODULE_TEMPLATE_ROOT + "editItems", viewName);
     //   assertThat(model, IsMapContaining.hasEntry("entityForm", menu));
        assertThat(model, IsMapContaining.hasKey("entity"));
	}
	
	@Test(expected = ResourceNotFoundException.class)
    public void editItems_testSlideshowNotExistShowExceptionError() {
		Integer slideshowId=1;
		
		//
		when(slideshowService.getForEditItems(slideshowId)).thenReturn(null);

		String viewName = slideshowController.editItems(model, slideshowId);	
    }
	
	@Test
	public void updateItems_() {
		Integer slideshowId=1;
		Slideshow slideshow = new Slideshow();
		
		Map<String, String[]> parameters = new HashMap<String, String[]>();
		
		when(slideshowService.getForEditItems(slideshowId)).thenReturn(slideshow);
		when(request.getParameterMap()).thenReturn(parameters);
		
		//
		String viewName = slideshowController.updateItems(slideshowId, model, request, redirectAttributes, null);
		
		//
		verify(slideshowService).updateSlideshowItems(slideshowId, parameters, null);
		verify(redirectAttributes).addFlashAttribute("message", "Successfully updated!");
        assertEquals("redirect:/admin/slideshow/index", viewName);
        //assertThat(model, IsMapContaining.hasEntry("entityForm", menu));
        //assertThat(model, IsMapContaining.hasKey("entity"));
	}
}
