package com.mohsenj.module.content.event;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mohsenj.core.lib.exception.ResourceNotFoundException;
import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.category.service.CategoryServiceImp;
import com.mohsenj.module.content.service.ContentServiceImp;
import com.mohsenj.module.menu.event.MenuItemOptionsEvent;
import com.mohsenj.module.menu.model.Menu;
import static java.lang.Math.toIntExact;


@Component
public class MenuItemOptionsEventListener implements ApplicationListener<MenuItemOptionsEvent> {

	@Autowired
	private ContentServiceImp contentService;
	
	@Autowired
	private CategoryServiceImp categoryService;
	
	@Override
	public void onApplicationEvent(MenuItemOptionsEvent event) {
	//	System.out.println(event.toString());
		/*
		Map<String, String> m = new HashMap<String, String>();
		
		String option = "<option value='content_list_khabar'>Content List</option>";
		String html = "<select><option>cat1</option></select>";
		m.put(option, html);
		
		event.addData(m);
		*/
		
	//	System.out.println("ev type = " + event.getEventType());
		if(event.getEventType() == MenuItemOptionsEvent.EventType.SAVEMENU) {
			saveMenuListener(event);
		}
		else if(event.getEventType() == MenuItemOptionsEvent.EventType.GETOPTIONS) {
			String categoryOptions = contentService.getCategorySelectOptionRaw();
			
			String option = "<option value='content_list_khabar'>Content List</option>";
			option += "<option value='content_list_khabar2'>Content List2</option>";
			
			String html = "<div class=\"types control-group\" id=\"content_list_khabar\"><label class='control-label'>Parent</label><div class=\"controls\"><select name=\"content_list_khabar\">"+categoryOptions+"</select></div></div>";
			html += "<div class=\"types control-group\" id=\"content_list_khabar2\"><label class='control-label'>Parent</label><div class=\"controls\"><select><option>cat1</option></select></div></div>";

			event.addData(option, html);
		}
		else if(event.getEventType() == MenuItemOptionsEvent.EventType.EDITMENU) {
			editMenuListener(event);
		}
		else if(event.getEventType() == MenuItemOptionsEvent.EventType.UPDATEMENU) {
			updateMenuListener(event);
		}
		
	}
	
	private void saveMenuListener(MenuItemOptionsEvent event) {
		Map<String, String[]> parameters = event.getParameterMap();
		//System.out.println("inside saveMenuListener: " + parameters);
		//System.out.println("itemtype saveMenuListener: " + parameters.get("itemType")[0]);
		//System.out.println("itemtype2 saveMenuListener: " +event.getMenu().getItemType());
		if("content_list_khabar".equals(parameters.get("itemType")[0])) {
		//		if(event.getMenu().getItemType().equals("content_list_khabar")) {
			System.out.println("referId f: " + parameters.get("content_list_khabar")[0]);
			System.out.println("referId f: " + Integer.valueOf(parameters.get("content_list_khabar")[0]));

			String refer_id;
			/*
			if(parameters.containsKey("content_list_khabar") && parameters.containsKey("content_list_khabar").get) {
				refer_id = parameters.get("content_list_khabar")[0];
			}
			else {
				
			}
			*/
			try {
				refer_id = parameters.get("content_list_khabar")[0];
			} catch ( IndexOutOfBoundsException e ) {
			    throw new ResourceNotFoundException();
			}
			
			Category category = categoryService.findById(Integer.valueOf(refer_id));
			
			if(category == null){
				System.out.println("category is empty");
				throw new ResourceNotFoundException();
			}
			
			String link = ServletUriComponentsBuilder.fromCurrentContextPath().path("/content/catList/"+refer_id+"/"+category.getSlug()).build().toUriString();
			
			System.out.println("link = " + link);
			event.addData("link", link);
			
			event.addData("refer_id", refer_id);
			
			System.out.println(event.getData());
		}
	}

	private void editMenuListener(MenuItemOptionsEvent event) {
		Menu menu = event.getMenu();
		
		
		// not tested
		String categoryOptions;
		if(menu.getItemType() == "content_list_khabar") {
			categoryOptions = contentService.getCategorySelectOption(toIntExact(menu.getReferId()), 0);
		}
		else {
			categoryOptions = contentService.getCategorySelectOptionRaw();
		}
		
		String option = "<option value='content_list_khabar'>Content List</option>";	
	//	option += "<option value='content_list_khabar2'>Content List2</option>";

		
		String html = "<div class=\"types control-group\" id=\"content_list_khabar\"><label class='control-label'>Parent</label><div class=\"controls\"><select name=\"content_list_khabar\">"+categoryOptions+"</select></div></div>";
	//	html += "<div class=\"types control-group\" id=\"content_list_khabar2\"><label class='control-label'>Parent</label><div class=\"controls\"><select><option>cat1</option></select></div></div>";

		event.addData(option, html);
		
	}
	
	private void updateMenuListener(MenuItemOptionsEvent event) {
		Map<String, String[]> parameters = event.getParameterMap();


		if("content_list_khabar".equals(parameters.get("itemType")[0])) {

			String refer_id;

			try {
				refer_id = parameters.get("content_list_khabar")[0];
			} catch ( IndexOutOfBoundsException e ) {
			    throw new ResourceNotFoundException();
			}
			
			Category category = categoryService.findById(Integer.valueOf(refer_id));
			
			if(category == null){
				System.out.println("category is empty");
				throw new ResourceNotFoundException();
			}
			
			String link = ServletUriComponentsBuilder.fromCurrentContextPath().path("/content/catList/"+refer_id+"/"+category.getSlug()).build().toUriString();
			
			System.out.println("link = " + link);
			event.addData("link", link);
			
			event.addData("refer_id", refer_id);
			
		}
	}

}
