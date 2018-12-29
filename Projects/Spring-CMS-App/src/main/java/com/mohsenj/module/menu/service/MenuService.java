package com.mohsenj.module.menu.service;

import java.util.List;
import java.util.Map;

import com.mohsenj.core.util.HiararchyUtils;
import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.menu.model.Menu;

public interface MenuService {

	List<Menu> findRootMenusOrdeingDesc();

	void store(Menu entityForm, Map<String, String[]> parameters);

	Boolean itemExist(Integer parentId);


	String getTrForTableMenu(HiararchyUtils hiararchyUtils, Integer menuId);

	Menu findOne(Integer menuId);

	Map<String, String> prepareForEdit(Menu menu);

	Object getParentSelectOptions(Menu menu);

	void update(Menu entityForm, Map<String, String[]> parameters);

	Integer deleteById(Integer id);

	String generateHtmlMenu(String menyType, Integer parentId);

	
}
