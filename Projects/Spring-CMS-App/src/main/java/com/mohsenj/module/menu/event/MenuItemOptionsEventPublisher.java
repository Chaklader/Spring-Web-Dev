package com.mohsenj.module.menu.event;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import com.mohsenj.module.menu.model.Menu;

@Component
public class MenuItemOptionsEventPublisher implements ApplicationEventPublisherAware {

	@Autowired
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
		
	}	
	
	private ApplicationEventPublisher publisher;

	private MenuItemOptionsEvent menuItemOptionsEvent;
   
	public MenuItemOptionsEventPublisher() {
		menuItemOptionsEvent = new MenuItemOptionsEvent(this);
	}
	
	public MenuItemOptionsEvent getMenuItemOptionsEvent() {
		return menuItemOptionsEvent;
	}

	public void publish() {
		// MenuItemOptionsEvent ce = new MenuItemOptionsEvent(this);
	    publisher.publishEvent(menuItemOptionsEvent);
	}

	public Map<String, String> publishForEdit(Menu menu) {
		
		menuItemOptionsEvent.setEventType(MenuItemOptionsEvent.EventType.EDITMENU);
		menuItemOptionsEvent.setMenu(menu);
		// not tested!!
		publish();
		
		return menuItemOptionsEvent.getData();
		
	}

}
