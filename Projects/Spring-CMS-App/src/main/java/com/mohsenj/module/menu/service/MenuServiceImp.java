package com.mohsenj.module.menu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohsenj.core.lib.exception.ResourceNotFoundException;
import com.mohsenj.core.util.HiararchyUtils;
import com.mohsenj.core.util.StringUtils;
import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.menu.event.MenuItemOptionsEvent;
import com.mohsenj.module.menu.event.MenuItemOptionsEventPublisher;
import com.mohsenj.module.menu.model.Menu;
import com.mohsenj.module.menu.repository.MenuRepository;

@Service
public class MenuServiceImp implements MenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Autowired
	private MenuItemOptionsEventPublisher menuItemOptionsEventPublisher;
	
	@Autowired
	private HiararchyUtils hiararchyUtils;
	
	@Override
	public List<Menu> findRootMenusOrdeingDesc() {
		return menuRepository.findRootMenusOrdeingDesc();
	}

	@Override
	public void store(Menu menu, Map<String, String[]> parameters) {

		menuItemOptionsEventPublisher.getMenuItemOptionsEvent().setEventType(MenuItemOptionsEvent.EventType.SAVEMENU);
		
		menuItemOptionsEventPublisher.getMenuItemOptionsEvent().setParameterMap(parameters);
		menuItemOptionsEventPublisher.getMenuItemOptionsEvent().setMenu(menu);
		menuItemOptionsEventPublisher.publish();
		//
		
		Map<String, String> data = menuItemOptionsEventPublisher.getMenuItemOptionsEvent().getData();
		
		Long referId = Long.parseLong(data.get("refer_id"));
		String link = data.get("link");
		
		menu.setReferId(referId);
		menu.setLink(link);
		menu.setSlug(StringUtils.slugify( menu.getTitle()) );
		menu.setDeleteLock(0);
		
		if(menu.getOrdering() == null) {
			menu.setOrdering(1);
		}
		
		menu.setStatus(1);
		menuRepository.save(menu);
		
	}

	@Override
	public Boolean itemExist(Integer parentId) {
		
		Menu menu = menuRepository.findOne(parentId);
		
		if(menu == null) {
			return false;
		}
		else {
			return true;
		}
		
	}


	@Override
	public String getTrForTableMenu(HiararchyUtils hiararchyUtils, Integer menuId) {
		
		List<Menu> menus = menuRepository.findAllOrderByOrderingAsc();
		
		return hiararchyUtils.getHForTableMenu(menus, menuId);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Menu findOne(Integer menuId) {
		return menuRepository.findOne(menuId);
	}

	@Override
	public Map<String, String> prepareForEdit(Menu menu) {
		
		 menuItemOptionsEventPublisher.publishForEdit(menu);
		//	System.out.println("heh heh " + menuItemOptionsEventPublisher.getMenuItemOptionsEvent().getData().values());

		 return menuItemOptionsEventPublisher.getMenuItemOptionsEvent().getData();
		
	}

	@Override
	public String getParentSelectOptions(Menu menu) {
		List<Menu> entities = menuRepository.findAll();
		
		HiararchyUtils hiararchyUtils = new HiararchyUtils();
		
		List<Integer> excludeList = new ArrayList<Integer>();
		excludeList.add(menu.getId());
		
		return hiararchyUtils.getHForSelect(entities, menu.getParentId(), null, excludeList);
	}

	@Override
	public void update(Menu menu, Map<String, String[]> parameters) {

		menuItemOptionsEventPublisher.getMenuItemOptionsEvent().setEventType(MenuItemOptionsEvent.EventType.UPDATEMENU);
		
		menuItemOptionsEventPublisher.getMenuItemOptionsEvent().setParameterMap(parameters);
		menuItemOptionsEventPublisher.getMenuItemOptionsEvent().setMenu(menu);
		menuItemOptionsEventPublisher.publish();
		//
		
		Map<String, String> data = menuItemOptionsEventPublisher.getMenuItemOptionsEvent().getData();
		
		Long referId = Long.parseLong(data.get("refer_id"));
		String link = data.get("link");
		
		menu.setReferId(referId);
		menu.setLink(link);
		menu.setSlug(StringUtils.slugify( menu.getTitle()) );
		menu.setDeleteLock(0);
		
		if(menu.getOrdering() == null) {
			menu.setOrdering(1);
		}
		
		menu.setStatus(1);
	    menuRepository.save(menu);
		
	}

	@Override
	public Integer deleteById(Integer id) {

		Menu menu = menuRepository.findOne(id);
		if(menu == null) {
			throw new ResourceNotFoundException("menu not found");
		}
		
		Integer redirectId = menu.getParentId();
		
		menuRepository.updateChildrenParentId(menu.getId(), menu.getParentId());
		
		menuRepository.delete(menu.getId());
		
		return redirectId;
	}

	@Override
	public String generateHtmlMenu(String menyType, Integer parentId) {

		List<Menu> entities = menuRepository.findAll();
		
		String mainMenuStr="";
		if(menyType.equals("mainMenu")) {
			mainMenuStr = hiararchyUtils.getMainMenu(entities, 0, parentId);
		}
		return  mainMenuStr;
	}
	
}
