package com.mohsenj.module.slideshow.controller.admin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mohsenj.core.lib.exception.ResourceNotFoundException;
import com.mohsenj.core.util.HiararchyUtils;
import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.category.service.CategoryService;
import com.mohsenj.module.category.validator.CategoryValidator;
import com.mohsenj.module.module.service.ModuleService;
import com.mohsenj.module.slideshow.model.Slideshow;
import com.mohsenj.module.slideshow.service.SlideshowService;
import com.mohsenj.module.module.model.Module;


@Controller
@RequestMapping(value="/admin/slideshow")
public class SlideshowController {

	@Autowired
	public SlideshowController(SlideshowService slideshowService) {
		this.slideshowService = slideshowService;
	}
	
	
	private SlideshowService slideshowService;
	
	private final String MODULE_TEMPLATE_ROOT = "admin/module/slideshow/";

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(Model model) {

		List<Slideshow> entities = slideshowService.findAll();
		
		model.addAttribute("entities", entities);
		return MODULE_TEMPLATE_ROOT + "index";
	}

	@RequestMapping(value="/editItems/{slideshowId}", method=RequestMethod.GET)
	public String editItems(Model model, @PathVariable Integer slideshowId) {

		Slideshow slideshow = slideshowService.getForEditItems(slideshowId);

		if(slideshow == null) {
			throw new ResourceNotFoundException("Slideshow not found");
		}
		
		model.addAttribute("entity", slideshow);
		
		return MODULE_TEMPLATE_ROOT + "editItems";
	}

	@RequestMapping(value="/updateItems/{slideshowId}", method=RequestMethod.POST)
	public String updateItems(@PathVariable Integer slideshowId, Model model, HttpServletRequest request,
			RedirectAttributes redirectAttributes, @RequestParam("newItemsFiles") MultipartFile[] newItemsFiles) {

    	Map<String, String[]> parameters = request.getParameterMap();

    	//System.out.println(parameters);
    	//System.out.println("newItemsTitle[]= "+ parameters.get("newItemsTitle").length);
    	
    	slideshowService.updateSlideshowItems(slideshowId, parameters, newItemsFiles);
    	redirectAttributes.addFlashAttribute("message", "Successfully updated!");
		return "redirect:/admin/slideshow/index";
	}
	
	
/*	
	
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
	*/
}
