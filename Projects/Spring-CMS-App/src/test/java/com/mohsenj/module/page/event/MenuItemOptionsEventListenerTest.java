package com.mohsenj.module.page.event;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mohsenj.core.lib.exception.ResourceNotFoundException;
import com.mohsenj.module.content.repository.ContentRepository;
import com.mohsenj.module.content.service.ContentService;
import com.mohsenj.module.content.service.ContentServiceImp;
import com.mohsenj.module.menu.event.MenuItemOptionsEvent;
import com.mohsenj.module.menu.model.Menu;
import com.mohsenj.module.page.model.Page;
import com.mohsenj.module.page.service.PageService;

@RunWith(MockitoJUnitRunner.class)
public class MenuItemOptionsEventListenerTest {

	@Mock
	PageService pageService;
		
	@InjectMocks
	private MenuItemOptionsEventListener menuItemOptionsEventListener = new MenuItemOptionsEventListener();
	
	private MenuItemOptionsEvent menuItemOptionsEvent;
	
	
	private String expectedTopOption = "<option value=\"page\">page</option>";
	private String selectOption = "<option value=\"1\">page title 1</option><option value=\"2\">page title 2</option>";
	private String selectOptionSelected = "<option value=\"1\" selected>page title 1</option><option value=\"2\">page title 2</option>";
	private String expectedHtml = "<div class=\"types control-group\" id=\"page\"><label class='control-label'>page</label><div class=\"controls\"><select name=\"page\">"+selectOption+"</select></div></div>";
	private String expectedHtmlSelected = "<div class=\"types control-group\" id=\"page\"><label class='control-label'>page</label><div class=\"controls\"><select name=\"page\">"+selectOptionSelected+"</select></div></div>";

	private final int PAGE_ID=1;
	private final String PAGE_TITLE= "page title 1";
	private final String PAGE_SLUG= "page-title-1";
	private Page page1;
	
	@Before
	public void beforeSetup() {
		menuItemOptionsEvent = new MenuItemOptionsEvent(new Object());
		page1= new Page(PAGE_TITLE, "");
		page1.setId(PAGE_ID);
		page1.setSlug(PAGE_SLUG);
	}
	
	@Test
	public void getOption_add_expected_info_to_data_variable() {
		
		menuItemOptionsEvent.setEventType(MenuItemOptionsEvent.EventType.GETOPTIONS);
		when(pageService.getPageSelectOptionRaw()).thenReturn(selectOption);
		
		
		menuItemOptionsEventListener.onApplicationEvent(menuItemOptionsEvent);
		
		Map<String, String> data = menuItemOptionsEvent.getData();
		
		assertTrue(data.containsKey(expectedTopOption));
		assertEquals(expectedHtml, data.get(expectedTopOption));
	}
	
	@Test
	public void savemenu_add_expected_info_to_data_variable() {

		menuItemOptionsEvent.setEventType(MenuItemOptionsEvent.EventType.SAVEMENU);
		Map<String, String[]> parameters = new HashMap<String, String[]>();
		parameters.put("itemType", new String[]{"page"});
		parameters.put("page", new String[]{"1"});
		menuItemOptionsEvent.setParameterMap(parameters);

		when(pageService.findById(PAGE_ID)).thenReturn(page1);

		
		menuItemOptionsEventListener.onApplicationEvent(menuItemOptionsEvent);
		
		Map<String, String> data = menuItemOptionsEvent.getData();
		
		assertEquals("1", data.get("refer_id"));
		assertEquals("/p-1/page-title-1", data.get("link"));

	}
	
	@Test(expected = ResourceNotFoundException.class)
	public void savemenu_pageId_notSet_throw_exception() {

		menuItemOptionsEvent.setEventType(MenuItemOptionsEvent.EventType.SAVEMENU);
		Map<String, String[]> parameters = new HashMap<String, String[]>();
		parameters.put("itemType", new String[]{"page"});
	//	parameters.put("page", new String[]{"1"});
		menuItemOptionsEvent.setParameterMap(parameters);

		when(pageService.findById(PAGE_ID)).thenReturn(null);
		
		menuItemOptionsEventListener.onApplicationEvent(menuItemOptionsEvent);

	}
	
	@Test(expected = ResourceNotFoundException.class)
	public void savemenu_page_notFound_error() {

		menuItemOptionsEvent.setEventType(MenuItemOptionsEvent.EventType.SAVEMENU);
		Map<String, String[]> parameters = new HashMap<String, String[]>();
		parameters.put("itemType", new String[]{"page"});
		parameters.put("page", new String[]{"1"});
		menuItemOptionsEvent.setParameterMap(parameters);

		when(pageService.findById(PAGE_ID)).thenReturn(null);

		
		menuItemOptionsEventListener.onApplicationEvent(menuItemOptionsEvent);

	}
	
	@Test
	public void savemenu_if_not_for_page_do_nothing() {

		menuItemOptionsEvent.setEventType(MenuItemOptionsEvent.EventType.SAVEMENU);
		Map<String, String[]> parameters = new HashMap<String, String[]>();
		parameters.put("itemType", new String[]{"something-not-page"});
		parameters.put("page", new String[]{"1"});
		menuItemOptionsEvent.setParameterMap(parameters);

		when(pageService.findById(PAGE_ID)).thenReturn(page1);

		
		menuItemOptionsEventListener.onApplicationEvent(menuItemOptionsEvent);
		
		Map<String, String> data = menuItemOptionsEvent.getData();
		
		assertFalse(data.containsKey("refer_id"));
		assertFalse(data.containsKey("link"));
	}
	
	@Test
	public void editMenuOptions_expected_info_to_data_variable() {
		Menu menu = new Menu();
		menu.setReferId(Long.decode(page1.getId().toString()));
		
		menuItemOptionsEvent.setEventType(MenuItemOptionsEvent.EventType.EDITMENU);
		menuItemOptionsEvent.setMenu(menu);
		when(pageService.getPageSelectOptionRawWithSelected(menu.getReferId())).thenReturn(selectOptionSelected);
		
		
		menuItemOptionsEventListener.onApplicationEvent(menuItemOptionsEvent);
		
		Map<String, String> data = menuItemOptionsEvent.getData();
		
		assertTrue(data.containsKey(expectedTopOption));
		assertEquals(expectedHtmlSelected, data.get(expectedTopOption));

	}
	
	@Test
	public void savemenu_updatemenu_add_expected_info_to_data_variable() {

		menuItemOptionsEvent.setEventType(MenuItemOptionsEvent.EventType.UPDATEMENU);
		Map<String, String[]> parameters = new HashMap<String, String[]>();
		parameters.put("itemType", new String[]{"page"});
		parameters.put("page", new String[]{"1"});
		menuItemOptionsEvent.setParameterMap(parameters);

		when(pageService.findById(PAGE_ID)).thenReturn(page1);

		
		menuItemOptionsEventListener.onApplicationEvent(menuItemOptionsEvent);
		
		Map<String, String> data = menuItemOptionsEvent.getData();
		
		assertEquals("1", data.get("refer_id"));
		assertEquals("/p-1/page-title-1", data.get("link"));

	}
	
	@Test
	public void savemenu_updatemenu_if_not_for_page_do_nothing() {

		menuItemOptionsEvent.setEventType(MenuItemOptionsEvent.EventType.UPDATEMENU);
		Map<String, String[]> parameters = new HashMap<String, String[]>();
		parameters.put("itemType", new String[]{"something-not-page"});
		parameters.put("page", new String[]{"1"});
		menuItemOptionsEvent.setParameterMap(parameters);

		when(pageService.findById(PAGE_ID)).thenReturn(page1);

		
		menuItemOptionsEventListener.onApplicationEvent(menuItemOptionsEvent);
		
		Map<String, String> data = menuItemOptionsEvent.getData();
		
		assertFalse(data.containsKey("refer_id"));
		assertFalse(data.containsKey("link"));
	}
	
	
}
