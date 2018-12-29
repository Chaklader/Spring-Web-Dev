package com.mohsenj.module.page.event;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mohsenj.core.lib.exception.ResourceNotFoundException;
import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.content.service.ContentServiceImp;
import com.mohsenj.module.menu.event.MenuItemOptionsEvent;
import com.mohsenj.module.menu.model.Menu;
import com.mohsenj.module.page.model.Page;
import com.mohsenj.module.page.service.PageService;

@Component("page MenuItemOptionsEventListener")
public class MenuItemOptionsEventListener implements ApplicationListener<MenuItemOptionsEvent>  {
	
	@Autowired
	private PageService pageService;
	
	public void onApplicationEvent(MenuItemOptionsEvent event) {
		
		if(event.getEventType() == MenuItemOptionsEvent.EventType.GETOPTIONS || 
				event.getEventType() == MenuItemOptionsEvent.EventType.EDITMENU) {
			getOptions(event);
		}
		else if(event.getEventType() == MenuItemOptionsEvent.EventType.SAVEMENU ||
				event.getEventType() == MenuItemOptionsEvent.EventType.UPDATEMENU) {
			saveMenu(event);
		}
		
		
		
	}
	
	public void getOptions(MenuItemOptionsEvent event) {
		Menu menu = event.getMenu();
		
		String selectOption="";
		
		if(menu != null && menu.getReferId() != null){
			selectOption = pageService.getPageSelectOptionRawWithSelected(menu.getReferId());

		}
		else {
			selectOption = pageService.getPageSelectOptionRaw();
		}
		
		
		
		String option = "<option value=\"page\">page</option>";

		String html = "<div class=\"types control-group\" id=\"page\"><label class='control-label'>page</label><div class=\"controls\"><select name=\"page\">"+selectOption+"</select></div></div>";

		event.addData(option, html);
	}
	
	public void saveMenu(MenuItemOptionsEvent event) {
		Map<String, String[]> parameters = event.getParameterMap();
		
		if("page".equals(parameters.get("itemType")[0])) {

			String refer_id;

			
			try {
				refer_id = parameters.get("page")[0];
			} catch ( IndexOutOfBoundsException e ) {
			    throw new ResourceNotFoundException();
			}
		    catch ( NullPointerException e ) {
		    	throw new ResourceNotFoundException();
		    }	
			
			if(refer_id == null) {
		    	throw new ResourceNotFoundException();

			}
			
			Page page = pageService.findById(Integer.valueOf(refer_id));
			
			if(page == null){
				System.out.println("category is empty");
				throw new ResourceNotFoundException();
			}
			
			String link = "/p-"+page.getId()+"/"+page.getSlug();
			
			event.addData("link", link);
			event.addData("refer_id", refer_id);
		}
	}
	

}
