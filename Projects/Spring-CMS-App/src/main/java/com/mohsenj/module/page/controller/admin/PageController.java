package com.mohsenj.module.page.controller.admin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.category.repository.CategoryRepository;
import com.mohsenj.module.category.service.CategoryService;
import com.mohsenj.module.category.validator.CategoryValidator;
import com.mohsenj.module.module.service.ModuleService;
import com.mohsenj.module.page.model.Page;
import com.mohsenj.module.page.service.PageService;
import com.mohsenj.module.page.validator.PageValidator;
import com.mohsenj.module.module.model.Module;


@Controller("Admin PageController")
@RequestMapping(value="/admin/page")
public class PageController {

	private final String MODULE_TEMPLATE_ROOT = "admin/module/page/";
	
	@Autowired
	private PageService pageService;
	
	@Autowired
	private PageValidator pageValidator;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String create(Model model) {

		model.addAttribute("entityForm", new Page());
		
		return MODULE_TEMPLATE_ROOT+"create";
	}
	
	@RequestMapping(value="/store", method=RequestMethod.POST)
	public String store(@ModelAttribute("entityForm") Page entityForm, final RedirectAttributes redirectAttributes,BindingResult bindingResult, Model model) {
		
		pageValidator.validate(entityForm, bindingResult);
        
		if (bindingResult.hasErrors()) {

	//		model.addAttribute("entityForm", entityForm);
			return MODULE_TEMPLATE_ROOT+"create";
        } else {

        	redirectAttributes.addFlashAttribute("message", "Successfully created!");
        	
            pageService.save(entityForm);
			return "redirect:/admin/page/index";
        }

	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(Model model) {
		List<Page> entites = pageService.findAll();
		
		model.addAttribute("entities", entites);
		return MODULE_TEMPLATE_ROOT + "index";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable Integer id, Model model) {
		
		Page entity = pageService.findById(id);
		
		if(entity == null) {
			throw new ResourceNotFoundException("");
		}	
		
		model.addAttribute("entityForm", entity);
		
		return MODULE_TEMPLATE_ROOT + "edit";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public String update(@ModelAttribute("entityForm") Page entityForm, @PathVariable Integer id, Model model, final RedirectAttributes redirectAttributes, BindingResult bindingResult) {
		
		pageValidator.validate(entityForm, bindingResult);
        
		if (bindingResult.hasErrors()) {
			return MODULE_TEMPLATE_ROOT+"edit";
        } else {
		
			pageService.update(entityForm);
			
			redirectAttributes.addFlashAttribute("message", "Successfully updated!");
			return "redirect:/admin/page/index";
        }
		
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public String delete(@PathVariable int id, final RedirectAttributes redirectAttributes) {
		
		pageService.deleteById(id);
		
		redirectAttributes.addFlashAttribute("message", "Successfully deleted!");
		
		return "redirect:/admin/page/index";
	}
	
}
