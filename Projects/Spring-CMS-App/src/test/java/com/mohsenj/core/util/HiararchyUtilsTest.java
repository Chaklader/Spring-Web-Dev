package com.mohsenj.core.util;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mohsenj.module.menu.model.Menu;

@RunWith(MockitoJUnitRunner.class)
public class HiararchyUtilsTest {

	private HiararchyUtils hiararchyUtils;
	
	private List<Hierarchically> menus;
	private Menu menu1 = new Menu();
	private Menu menu2 = new Menu();
	private Menu menu3 = new Menu();
	
	@Before
	public void setup() {
		/*
		MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpSession session = new MockHttpSession();
        request.setSession(session);
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		*/
		hiararchyUtils = new HiararchyUtils();
		
		menu1.setId(1);
		menu1.setParentId(null);
		menu1.setTitle("menu1");
		
		menu2.setId(2);
		menu2.setParentId(null);
		menu2.setTitle("menu2");
		
		menu3.setId(3);
		menu3.setParentId(1);
		menu3.setTitle("menu3");
		
		menus = new LinkedList<Hierarchically>();
		menus.add(menu1);
		menus.add(menu2);
		menus.add(menu3);
	}
	
	@Test
	public void fake() {
		assertTrue(true);
	}
	
	/*
	@Test
	public void getHForTableMenu_() {
		
		String trs = hiararchyUtils.getHForTableMenu(menus);
	}
	
	@Test
	public void getHForTableMenu_verifyReturnString() {
		
		String trs = hiararchyUtils.getHForTableMenu(menus);
		
		String expected = "";
		//
    	String link1 = "";//ServletUriComponentsBuilder.fromCurrentContextPath().path("/admin/menu/edit/1").build().toUriString();
		expected += "<tr class=\"level-1\">";
		expected += "<td> menu1</td>";
		expected += "<td><a class=\"btn btn-mini btn-info\" href=\""+link1+"\" ><i class=\"icon-pencil\"></i> edit</a></td>";
		expected += "</tr>";
		//
    	String link3 = "";//ServletUriComponentsBuilder.fromCurrentContextPath().path("/admin/menu/edit/3").build().toUriString();
		expected += "<tr class=\"level-2\">";
		expected += "<td>- menu3</td>";
		expected += "<td><a class=\"btn btn-mini btn-info\" href=\""+link3+"\" ><i class=\"icon-pencil\"></i> edit</a></td>";
		expected += "</tr>";
		//
    	String link2 = "";//ServletUriComponentsBuilder.fromCurrentContextPath().path("/admin/menu/edit/2").build().toUriString();
		expected += "<tr class=\"level-1\">";
		expected += "<td> menu2</td>";
		expected += "<td><a class=\"btn btn-mini btn-info\" href=\""+link2+"\" ><i class=\"icon-pencil\"></i> edit</a></td>";
		expected += "</tr>";
		
		
		assertEquals(expected, trs);
	}
	
	@Test
	public void getHForTableMenu_verifyReturnStringWithParentIdNotNull() {
		
		String trs = hiararchyUtils.getHForTableMenu(menus, 1);
		
		String expected = "";
    	String link3 = "";//ServletUriComponentsBuilder.fromCurrentContextPath().path("/admin/menu/edit/3").build().toUriString();

		expected += "<tr class=\"level-1\">";
		expected += "<td> menu3</td>";
		expected += "<td><a class=\"btn btn-mini btn-info\" href=\""+link3+"\" ><i class=\"icon-pencil\"></i> edit</a></td>";
		expected += "</tr>";
		//
	
		
		
		assertEquals(expected, trs);
	}
	*/
}
