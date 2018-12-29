package com.mohsenj.module.menu.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mohsenj.core.lib.exception.ResourceNotFoundException;
import com.mohsenj.core.util.HiararchyUtils;
import com.mohsenj.module.menu.event.MenuItemOptionsEvent;
import com.mohsenj.module.menu.event.MenuItemOptionsEventPublisher;
import com.mohsenj.module.menu.model.Menu;
import com.mohsenj.module.menu.service.MenuService;
import com.mohsenj.core.lib.exception.BadRequestException;


@Controller
@RequestMapping(value="/admin/menu")
public class MenuController {

	private MenuService menuService;
	
	private MenuItemOptionsEventPublisher menuItemOptionsEventPublisher;
	
	private HiararchyUtils hiararchyUtils;
	
	@Autowired
	public MenuController(MenuService menuService, MenuItemOptionsEventPublisher mp, HiararchyUtils hiararchyUtils) {
		this.menuService = menuService;
		this.menuItemOptionsEventPublisher = mp;
		this.hiararchyUtils =  hiararchyUtils;
	}


	MenuItemOptionsEvent menuItemOptionsEvent;
	
	private final String MODULE_TEMPLATE_ROOT = "admin/module/menu/";
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(Model model) {
		
		List<Menu> rootMenus = menuService.findRootMenusOrdeingDesc();
		
		model.addAttribute("rootMenus", rootMenus);
		
		return MODULE_TEMPLATE_ROOT + "index";
    }
	
	@RequestMapping(value="/show", method=RequestMethod.GET)
	public String show(Model model) {
		
		List<Menu> rootMenus = menuService.findRootMenusOrdeingDesc();
		
		model.addAttribute("rootMenus", rootMenus);
		
		return MODULE_TEMPLATE_ROOT + "index";
    }
	
	
	
	@RequestMapping(value="/create/{parentId}", method=RequestMethod.GET)
	public String create(@PathVariable Integer parentId, Model model) {
		
		// first check if parent exist if parentId in number(not null or empty)
		if(parentId != null && !menuService.itemExist(parentId)) {
			throw new BadRequestException("menu with given parent not found");
		}
		
			
		
		menuItemOptionsEventPublisher.publish();
		System.out.println(menuItemOptionsEventPublisher.getMenuItemOptionsEvent().getData().values());
		
		model.addAttribute("data", menuItemOptionsEventPublisher.getMenuItemOptionsEvent().getData());
		
		Menu menu = new Menu();
		menu.setParentId(parentId);
		model.addAttribute("entityForm", menu);
		return MODULE_TEMPLATE_ROOT + "create";
	}
	
	/*
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String create( Model model) {
		return create(null, model);
	}
	*/
	
	@RequestMapping(value="/store", method=RequestMethod.POST)
	public String store(@ModelAttribute("entityForm") Menu entityForm, BindingResult bindingResult, HttpServletRequest request, final RedirectAttributes redirectAttributes, Model model) {
			
		if (bindingResult.hasErrors()) {
			
			return "redirect:/admin/menu/create";
        } else {

        	Map<String, String[]> parameters = request.getParameterMap();
        	
        	System.out.println(parameters);
        	
    		menuService.store(entityForm, parameters);
        	redirectAttributes.addFlashAttribute("message", "Successfully added!");
        	return "redirect:/admin/menu/index";
        }
	}

	@RequestMapping(value="/indexSubmenu/{menuId}", method=RequestMethod.GET)
	public String indexSubmenu(@PathVariable Integer menuId, Model model) {
	
		Menu menu = menuService.findOne(menuId);
		
		if(menu==null){
			throw new ResourceNotFoundException("menu not found");
		}
		model.addAttribute("menu", menu);
		
		String trMenus = menuService.getTrForTableMenu(hiararchyUtils, menuId);
		model.addAttribute("trMenus", trMenus);
		
		return MODULE_TEMPLATE_ROOT + "indexSubmenu";
	}

	@RequestMapping(value="/edit/{menuId}", method=RequestMethod.GET)
	public String edit(@PathVariable Integer menuId, Model model) {

		Menu menu = menuService.findOne(menuId);
		
		if(menu == null) {
			throw new ResourceNotFoundException("Menu not found!");
		}
		
		model.addAttribute("entityForm", menu);
		
		// not properly tested!
		model.addAttribute("data", menuService.prepareForEdit(menu));
		
		System.out.println("fff2s = " + menuService.getParentSelectOptions(menu));

		model.addAttribute("selectOptions", menuService.getParentSelectOptions(menu));
		
		return MODULE_TEMPLATE_ROOT + "edit";
	}
	
	@RequestMapping(value="/update/{menuId}", method=RequestMethod.POST)
	public String update(@PathVariable Integer menuId, @ModelAttribute("entityForm") Menu entityForm, BindingResult bindingResult, HttpServletRequest request, final RedirectAttributes redirectAttributes, Model model) {
			
		if (bindingResult.hasErrors()) {
			
			return "redirect:/admin/menu/edit/"+menuId;
        } else {

        	Map<String, String[]> parameters = request.getParameterMap();
        	
        	System.out.println(parameters);
        	
        	entityForm.setId(menuId);
    		menuService.update(entityForm, parameters);
        	redirectAttributes.addFlashAttribute("message", "Successfully updated!");
        	return "redirect:/admin/menu/index";
        }
	}
	
	@RequestMapping(value="/delete/{id}",  method=RequestMethod.POST)
	public String delete(@PathVariable Integer id, final RedirectAttributes redirectAttributes) {
		
		Integer redirectId = menuService.deleteById(id);
		redirectAttributes.addFlashAttribute("message", "Successfully deleted!");
		return "redirect:/admin/menu/indexSubmenu/"+redirectId;
	}
}
