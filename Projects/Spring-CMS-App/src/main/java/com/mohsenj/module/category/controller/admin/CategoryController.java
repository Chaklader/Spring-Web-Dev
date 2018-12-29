package com.mohsenj.module.category.controller.admin;

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
import com.mohsenj.module.category.service.CategoryService;
import com.mohsenj.module.category.validator.CategoryValidator;
import com.mohsenj.module.module.service.ModuleService;
import com.mohsenj.module.module.model.Module;


@Controller
@RequestMapping(value="/admin/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ModuleService moduleService;

	private final String MODULE_TEMPLATE_ROOT = "admin/module/category/";
	
	@ModelAttribute("modules")
    public Collection<Module> getModules() {
		List<Module> modules = moduleService.findAll();
		return modules;
    }
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(Model model) {
		
		List<Category> entities = categoryService.findAll();
		
		model.addAttribute("entities", entities);
		return MODULE_TEMPLATE_ROOT + "index";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String create(Model model) {
		
		model.addAttribute("entityForm", new Category());
		
		List<Category> entities = categoryService.findAll();
		
		HiararchyUtils hiararchyUtils = new HiararchyUtils();
		String selectOptions = hiararchyUtils.getHForSelect(entities, 0, 0);
		model.addAttribute("selectOptions", selectOptions);
		model.addAttribute("entities", entities);
		
		

		return MODULE_TEMPLATE_ROOT+"create";
	}
	
	
	@RequestMapping(value="/store", method=RequestMethod.POST)
	public String store(@ModelAttribute("entityForm") Category entityForm, final RedirectAttributes redirectAttributes,BindingResult bindingResult, Model model) {
		
		CategoryValidator categoryValidator = new CategoryValidator();
		categoryValidator.validate(entityForm, bindingResult);
        
		if (bindingResult.hasErrors()) {
       //     model.addAttribute("entityForm", new Category());
		
			//List<Category> entities = categoryService.findAll();
			//model.addAttribute("entities", entities);
			
		//	List<Module> modules = moduleService.findAll();
			//model.addAttribute("modules", modules);

			return MODULE_TEMPLATE_ROOT+"create";
        } else {

        	redirectAttributes.addFlashAttribute("message", "Successfully created!");
        	
            categoryService.save(entityForm);
			return "redirect:/admin/category/index";
        }

	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable Integer id, Model model) {
		
		Category category = categoryService.findById(id);		
		
		if(category == null) {
			throw new ResourceNotFoundException("");
		}	
	
		model.addAttribute("entityForm", category);
				
		List<Category> entities = categoryService.findAll();

		HiararchyUtils hiararchyUtils = new HiararchyUtils();
		List<Integer> excludeList = new ArrayList<Integer>();
		excludeList.add(category.getId());
		String selectOptions = hiararchyUtils.getHForSelect(entities, category.getParentId(), 0, excludeList);
		model.addAttribute("selectOptions", selectOptions);
		model.addAttribute("entities", entities);
		
		return MODULE_TEMPLATE_ROOT+"edit";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public String update(@PathVariable Long id, @ModelAttribute("entityForm") Category entityForm, final RedirectAttributes redirectAttributes,BindingResult bindingResult) {
		
		CategoryValidator categoryValidator = new CategoryValidator();
		categoryValidator.validate(entityForm, bindingResult);
        
		if (bindingResult.hasErrors()) {
          //  return "redirect:/admin/category/edit/"+id;
			return MODULE_TEMPLATE_ROOT+"edit";
        } else {

        	redirectAttributes.addFlashAttribute("message", "Successfully updated!");
            categoryService.update(entityForm);
			return "redirect:/admin/category/index";
        }

	}
	
	@RequestMapping(value="/delete/{id}",  method=RequestMethod.POST)
	public String delete(@PathVariable Integer id, final RedirectAttributes redirectAttributes) {
		
		categoryService.deleteById(id);
		redirectAttributes.addFlashAttribute("message", "Successfully deleted!");
		return "redirect:/admin/category/index";
	}
}
