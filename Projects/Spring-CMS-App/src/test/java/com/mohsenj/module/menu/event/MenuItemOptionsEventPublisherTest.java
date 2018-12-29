package com.mohsenj.module.menu.event;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ApplicationEventPublisher;

import com.mohsenj.module.menu.model.Menu;

@RunWith(MockitoJUnitRunner.class)
public class MenuItemOptionsEventPublisherTest {

	@Mock
	private MenuItemOptionsEvent menuItemOptionsEvent;
	
	@Mock
	private ApplicationEventPublisher applicationEventPublisher;
	
	@InjectMocks
	private MenuItemOptionsEventPublisher menuItemOptionsEventPublisher;// = new MenuItemOptionsEventPublisher();
	
	@Before
	public void setup() {
	//	menuItemOptionsEventPublisher = new MenuItemOptionsEventPublisher();
	}
	
	@Test
	public void publishForEdit_test() {
		
		Menu menu = new Menu();
		menu.setId(11);
		
		//
		Map<String, String> returndata = menuItemOptionsEventPublisher.publishForEdit(menu);
		
		//
		MenuItemOptionsEvent menuItemOptionsEvent = menuItemOptionsEventPublisher.getMenuItemOptionsEvent();
	//	assertEquals(menuItemOptionsEvent.getEventType(), MenuItemOptionsEvent.EventType.EDITMENU);
	//	assertEquals(menuItemOptionsEvent.getMenu().getId(), menu.getId());
	}
}
