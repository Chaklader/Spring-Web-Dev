package com.mohsenj.module.content.event;

import com.mohsenj.module.content.service.ContentServiceImp;
import com.mohsenj.module.menu.event.MenuItemOptionsEvent;
import com.mohsenj.module.menu.model.Menu;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class MenuItemOptionsEventListenerTest {

	@Mock
	private MenuItemOptionsEvent menuItemOptionsEvent;

	@Mock
	private ContentServiceImp contentService;
	
	@InjectMocks
	private MenuItemOptionsEventListener menuItemOptionsEventListener = spy(new MenuItemOptionsEventListener());
	
/*	@Before
	public void setup() {
		
	}*/
	
	@Test
	public void editMenuListener_testMenuItemTypeMatched() {
		//
		Integer menuId = 1;
		Menu menu = new Menu();
		menu.setId(menuId);
		menu.setReferId(1L);
		menu.setItemType("content_list_khabar");
		when(menuItemOptionsEvent.getEventType()).thenReturn(MenuItemOptionsEvent.EventType.EDITMENU);
		when(menuItemOptionsEvent.getMenu()).thenReturn(menu);
		when(contentService.getCategorySelectOption(1,0)).thenReturn("testStr");

	/*	when(menuItemOptionsEvent.addData(anyString(), anyString())).thenAnswer(new Answer<String>() {
		    @Override
		    public String answer(InvocationOnMock invocation) throws Throwable {
		      Object[] args = invocation.getArguments();
		      return (String) args[0];
		    }
		  });*/
		
	/*	when(menuItemOptionsEvent.addData(anyString(), anyString())).doAnswer(new Answer() {
		    private int count = 0;

		    public Object answer(InvocationOnMock invocation) {
		        if (count++ == 1)
		            return 1;

		        return 2;
		    }
		});*/
	/*	
		doReturn(new Answer<String>() {
		    @Override
		    public String answer(InvocationOnMock invocation) throws Throwable {
		      Object[] args = invocation.getArguments();
		      return (String) args[0];
		    }
		  })
	       .when(menuItemOptionsEvent)
	       .addData(anyString(), anyString());
	*/
		/*
		String  arg1;
		doAnswer(new Answer<Void>() {
	        @Override
	        public Void answer(InvocationOnMock invocation) throws Throwable {
	        	Object[] args = invocation.getArguments();
	        	arg1 =  (String) args[0];
	          //  return null;
	        }
	    }).when(menuItemOptionsEvent)
	       .addData(anyString(), anyString());
		*/
		
		//
		menuItemOptionsEventListener.onApplicationEvent(menuItemOptionsEvent);
		
		verify(menuItemOptionsEvent, atLeastOnce()).getEventType();
		verify(contentService).getCategorySelectOption(1,0);
	//	assertEquals();

	}
	/*
	@Test
	public void editMenuListener_testMenuItemTypeMatched() {
		//
		Integer menuId = 1;
		Menu menu = new Menu();
		menu.setId(menuId);
		menu.setReferId(1L);
		menu.setItemType("content_list_khabar");
		when(menuItemOptionsEvent.getEventType()).thenReturn(MenuItemOptionsEvent.EventType.EDITMENU);
		when(menuItemOptionsEvent.getMenu()).thenReturn(menu);
		when(contentService.getCategorySelectOption(1,0)).thenReturn("testStr");

		
		//
		menuItemOptionsEventListener.onApplicationEvent(menuItemOptionsEvent);
		
		//
		verify(menuItemOptionsEvent).getMenu();
	}*/
	
	/*
	@Test
	public void editMenuListener_testMenuItemTypeNotMatched() {
		//
		Menu menu = new Menu();
		menu.setItemType("content_list_khabar");
		when(menuItemOptionsEvent.getEventType()).thenReturn(MenuItemOptionsEvent.EventType.EDITMENU);
		when(menuItemOptionsEvent.getMenu()).thenReturn(menu);

		//
		menuItemOptionsEventListener.onApplicationEvent(menuItemOptionsEvent);
		
		//
		verify(menuItemOptionsEvent).getMenu();
	}*/
}
