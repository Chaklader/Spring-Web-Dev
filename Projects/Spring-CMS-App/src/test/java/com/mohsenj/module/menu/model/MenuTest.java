package com.mohsenj.module.menu.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MenuTest {

	@Test
	public void getHrefLink_ifLinkIsEmptyReturnHash() {
		Menu menu = new Menu();
		menu.setLink("");
		
		assertEquals(menu.getHrefLink(), "#");
	}
	@Test
	public void getHrefLink_ifLinkIsNotEmptyReturnLink() {
		Menu menu = new Menu();
		menu.setLink("test-link");
		
		assertEquals(menu.getHrefLink(), menu.getLink());
	}
}
