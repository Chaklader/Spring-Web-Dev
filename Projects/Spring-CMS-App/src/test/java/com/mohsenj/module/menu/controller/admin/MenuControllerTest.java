package com.mohsenj.module.menu.controller.admin;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.category.service.CategoryService;
import com.mohsenj.module.menu.event.MenuItemOptionsEvent;
import com.mohsenj.module.menu.event.MenuItemOptionsEventPublisher;
import com.mohsenj.module.menu.model.Menu;
import com.mohsenj.module.menu.service.MenuService;
import com.mohsenj.module.module.service.ModuleService;


import com.mohsenj.core.lib.exception.BadRequestException;
import com.mohsenj.core.lib.exception.ResourceNotFoundException;
import com.mohsenj.core.util.HiararchyUtils;


@RunWith(MockitoJUnitRunner.class)
public class MenuControllerTest {

	@Mock
	private MenuService menuService;

	@Mock
	private MenuItemOptionsEventPublisher menuItemOptionsEventPublisher;
	
	@Mock
	private MenuItemOptionsEvent menuItemOptionsEvent;
	
	@Mock
	private HiararchyUtils hiararchyUtils;
	
	@InjectMocks
	MenuController menuController;
	
	private Map<String, String> data = new TreeMap<String, String>();

	
	private ExtendedModelMap model = new ExtendedModelMap();
	
	private final String MODULE_TEMPLATE_ROOT = "admin/module/menu/";

	private Menu menu_2;
	
	@Before
	public void setup() {
		
		when(menuItemOptionsEvent.getData()).thenReturn(data);
		
		when(menuItemOptionsEventPublisher.getMenuItemOptionsEvent()).thenReturn(menuItemOptionsEvent);
		menuController = new MenuController(menuService, menuItemOptionsEventPublisher, hiararchyUtils);
		
		menu_2 = new Menu();
		menu_2.setId(2);
	}
	
	
	@Test
    public void testCreate_itemExistMethodCall() {
		
		Integer parentId = 1;
		when(menuService.itemExist(parentId)).thenReturn(true);
		
		String viewName = menuController.create(parentId, model);
		
		verify(menuService).itemExist(parentId);
    }
	
	
	
	@Test
    public void testCreateParentIdNotExistForController_not() {
		
		Integer parentId = null;
		
		String viewName = menuController.create( parentId, model);
		
		verify(menuService, never()).itemExist(parentId);
    }
	
	@Test(expected = BadRequestException.class)
    public void testCreate_parentItemNotExistShowExceptionError() {
		Integer parentId = 2;
		when(menuService.itemExist(parentId)).thenReturn(false);

		String viewName = menuController.create(parentId, model);	
    }
	

	
	@Test
    public void indexSubmenu_testViewName() {

		when(menuService.findOne(menu_2.getId())).thenReturn(menu_2);
		
		String viewName = menuController.indexSubmenu(menu_2.getId(), model);
		
        assertEquals(MODULE_TEMPLATE_ROOT + "indexSubmenu", viewName);
    }
	
	@Test
    public void indexSubmenu_testTableTr() {
		Integer menuId = menu_2.getId();
		
		String expected = "";
		expected += "<tr class=\"level-1\">";
		expected += "<td> menu3</td>";
		expected += "<td><a class=\"btn btn-mini btn-info\" th:href=\"@{/admin/menu/edit/3\" ><i class=\"icon-pencil\"></i> <span th:text=\"#{text.general.edit}\"></span></a></td>";
		expected += "</tr>";
		//
		
		when(menuService.findOne(menuId)).thenReturn(menu_2);

		when(menuService.getTrForTableMenu(hiararchyUtils, menuId)).thenReturn(expected);
		String viewName = menuController.indexSubmenu(menuId, model);
		
		verify(menuService).getTrForTableMenu(hiararchyUtils, menuId);
	//	verify(hiararchyUtils).getHForTableMenu(null, menuId);
        assertThat(model, IsMapContaining.hasEntry("trMenus", expected));
    }
	
	@Test
    public void edit_basic() {
		Integer menuId = 1;
		Menu menu = new Menu();
		
		//
		when(menuService.findOne(menuId)).thenReturn(menu);
		
		//
		String viewName = menuController.edit(menuId, model);
		
		//
		verify(menuService).findOne(menuId);
		verify(menuService).prepareForEdit(menu);
        assertEquals(MODULE_TEMPLATE_ROOT + "edit", viewName);
        assertThat(model, IsMapContaining.hasEntry("entityForm", menu));
        assertThat(model, IsMapContaining.hasKey("data"));


    }
	
	@Test(expected = ResourceNotFoundException.class)
    public void edit_MenuNotFoundThrowException() {
		Integer menuId = 1;
		
		//
		when(menuService.findOne(menuId)).thenReturn(null);
		
		//
		String viewName = menuController.edit(menuId, model);

    }
	
}
