package com.mohsenj.module.menu.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.transaction.Status;

import org.springframework.context.ApplicationEvent;

import com.mohsenj.module.menu.model.Menu;

public class MenuItemOptionsEvent  extends ApplicationEvent{

//	List<Map<String, String>> data = new ArrayList<Map<String, String>>();
	private Map<String, String> data = new TreeMap<String, String>();
	private Map<String, String[]> parameters;
	private Menu menu;
	
	public enum EventType  {GETOPTIONS, SAVEMENU, EDITMENU, UPDATEMENU};
	
	EventType eventType = EventType.GETOPTIONS;
	
	public MenuItemOptionsEvent(Object source) {
		super(source); 
	}
	
	public Map<String, String> getData() {
		return data;
	}


	public void addData(String key, String value) {
		data.put(key, value);
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public void setParameterMap(Map<String, String[]> parameters) {
		this.parameters = parameters;
		
	}
	public Map<String, String[]> getParameterMap() {
		return parameters;
		
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
/*

	public List<Map<String, String>> getData() {
		return data;
	}


	public void addData(Map<String, String> m) {
		data.add(m);
	}
*/
}
