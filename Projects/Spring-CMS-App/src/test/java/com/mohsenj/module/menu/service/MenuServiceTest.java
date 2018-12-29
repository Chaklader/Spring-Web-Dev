package com.mohsenj.module.menu.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mohsenj.core.lib.exception.ResourceNotFoundException;
import com.mohsenj.core.util.HiararchyUtils;
import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.category.service.CategoryService;
import com.mohsenj.module.menu.event.MenuItemOptionsEvent;
import com.mohsenj.module.menu.event.MenuItemOptionsEventPublisher;
import com.mohsenj.module.menu.model.Menu;
import com.mohsenj.module.menu.repository.MenuRepository;
import com.mohsenj.module.menu.service.MenuService;
import com.mohsenj.module.module.service.ModuleService;

@RunWith(MockitoJUnitRunner.class)
public class MenuServiceTest {


	@Mock
	MenuRepository menuRepository;
	
	@Mock
	private HiararchyUtils hiararchyUtils;
	
	@Mock
	private MenuItemOptionsEvent menuItemOptionsEvent;
	
	@Mock
	private ApplicationEventPublisher applicationEventPublisher;
	
	@Mock
	private MenuItemOptionsEventPublisher menuItemOptionsEventPublisher;
	
	@InjectMocks
	MenuServiceImp menuService;// = new MenuServiceImp();
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void itemExist_TestCallRepository() {
		Integer itemId = 1;
		menuService.itemExist(itemId);
		
		verify(menuRepository).findOne(itemId);
	}
	
	@Test
	public void itemExist_IfMenuNotFoundReturnFalse() {
		
		Integer itemId = 1;
		when(menuRepository.findOne(itemId)).thenReturn(null);
		Boolean result = menuService.itemExist(itemId);
		
		assertFalse(result);
	}
	
	@Test
	public void itemExist_IfMenuFoundReturnTrue() {
		
		Integer itemId = 1;
		Menu menu = new Menu();
		when(menuRepository.findOne(itemId)).thenReturn(menu);
		Boolean result = menuService.itemExist(itemId);
		
		assertTrue(result);
	}
	
	@Test
	public void getTrForTableMenu_testVerifyCallRepositoryAndHiararchy() {
		Integer menuId = 1;
		List<Menu> menus = new LinkedList<Menu>();
		when(menuRepository.findAllOrderByOrderingAsc()).thenReturn(menus);
		menuService.getTrForTableMenu(hiararchyUtils, menuId);
		
		verify(menuRepository).findAllOrderByOrderingAsc();
		verify(hiararchyUtils).getHForTableMenu(menus, menuId);
	}
	
	@Test
	public void findOne_ReturnTypeAndcallRepository() {
		Integer menuId = 1;
		Menu menu = new Menu();
		menu.setId(menuId);
		//
		when(menuRepository.findOne(menuId)).thenReturn(menu);
		
		//
		Menu returnVal = menuService.findOne(menuId);
		
		//
		verify(menuRepository).findOne(menuId);
		assertEquals(returnVal.getId(), menu.getId());
		
	}
	
	@Test
	public void prepareForEdit_basicCallMethods() {

		Menu menu = new Menu();
		Map<String, String> expectedVal = new HashMap<String, String>();
		expectedVal.put("option", "dives");
		
		// expectation
		when(menuItemOptionsEventPublisher.publishForEdit(menu)).thenReturn(expectedVal);
		when(menuItemOptionsEventPublisher.getMenuItemOptionsEvent()).thenReturn(menuItemOptionsEvent);

		//
		Map<String, String> returnVal = menuService.prepareForEdit(menu);
		
		//
	//	assertEquals(expectedVal, returnVal);
		verify(menuItemOptionsEventPublisher).publishForEdit(menu);
	}
	
	@Test(expected = ResourceNotFoundException.class)
	public void deleteById_menuNotFound() {
		Integer menuId = 1;
		//
		when(menuRepository.findOne(menuId)).thenReturn(null);
		
		menuService.deleteById(menuId);
	}
	
	@Test
	public void deleteById_menuIsLeaf() {
		Integer menuId = 1;
		Menu menu = new Menu();
		menu.setId(menuId);
		//
		when(menuRepository.findOne(menuId)).thenReturn(menu);
		//
		menuService.deleteById(menuId);
		
		//
		verify(menuRepository).delete(menuId);
	}
	
	@Test
	public void deleteById_menuWithChildren() {
		Integer menuId = 1;
		Integer parentId = 100;
		Menu menu = new Menu();
		menu.setId(menuId);
		menu.setParentId(parentId);
		
		Integer menuId2 = 2;
		Menu menuChild2 = new Menu();
		menuChild2.setId(menuId2);
		menuChild2.setParentId(menuId);
		Set<Integer> ids = new HashSet<Integer>();
		ids.add(menuId2);
		//
		when(menuRepository.findOne(menuId)).thenReturn(menu);
		//
		menuService.deleteById(menuId);
		
		//
		verify(menuRepository).updateChildrenParentId(menuId, parentId);
	}
	
	@Test
	public void generateHtmlMenu_mainMenuRequested() {
		Integer parentId=null;
		List<Menu> entities = null;
		when(menuRepository.findAll()).thenReturn(entities);
		//
		String htmlMenu = menuService.generateHtmlMenu("mainMenu", parentId);
		
		//
		verify(menuRepository).findAll();
		verify(hiararchyUtils).getMainMenu(entities,0,parentId);
	}
	
	@Test
	public void generateHtmlMenu_mainMenuNotRequestedDoNotCallGetMainMenu() {
		Integer parentId=null;
		List<Menu> entities = null;
		when(menuRepository.findAll()).thenReturn(entities);
		//
		String htmlMenu = menuService.generateHtmlMenu("blah", parentId);
		
		//
		verify(menuRepository).findAll();
		verify(hiararchyUtils, never()).getMainMenu(entities,0,parentId);
	}

}
