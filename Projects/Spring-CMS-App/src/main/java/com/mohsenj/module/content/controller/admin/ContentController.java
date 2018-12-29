package com.mohsenj.module.content.controller.admin;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
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
import com.mohsenj.module.content.model.Content;
import com.mohsenj.module.content.service.ContentServiceImp;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;

import com.mohsenj.core.util.pagination.PageWrapper;

@Controller("Admin ContentController")
@RequestMapping(value = "/admin/content")
@CacheEvict(value="latestContents", allEntries = true)
public class ContentController {

	@Autowired
	private ContentServiceImp contentService;
	
	@Autowired
	private CategoryService categoryService;
	
	final int MODULE_ID = 3;
	private final String MODULE_TEMPLATE_ROOT = "admin/module/content/";
	
	@ModelAttribute("contentCategory")
    public Collection<Category> getCategoriesForContent() {
        return this.categoryService.findByModuleId(MODULE_ID);
    }
	
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(Model model, @RequestParam(defaultValue = "1") int page) {
		page--;
		Pageable pageRequest = new PageRequest(page, 10/*pageSize*/, Sort.Direction.DESC, "id");
		Page<Content> result = contentService.findAll(pageRequest);
	  //      System.out.println(result);
	    model.addAttribute("page", result);
		
		return MODULE_TEMPLATE_ROOT + "index";
	}
	
	@PreAuthorize("@roleBaseSecurityService.hasPermission(authentication, 'admin_content_manage')")
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String create(Model model) {
		
		// get category list to select from
		List<Category> entities = categoryService.findByModuleId(MODULE_ID);
		
		HiararchyUtils hiararchyUtils = new HiararchyUtils();
		String selectOptions = hiararchyUtils.getHForSelect(entities, 0, 0);
		model.addAttribute("categorySelectOptions", selectOptions);
		
		model.addAttribute("entityForm", new Content());
		return MODULE_TEMPLATE_ROOT + "create";
	}
	
	
	
	@RequestMapping(value="/store", method=RequestMethod.POST)
	public String store(@ModelAttribute("contentForm") Content contentForm,
			BindingResult bindingResult, @RequestParam("file") MultipartFile file, final RedirectAttributes redirectAttributes, Model model) {
		
		if (bindingResult.hasErrors()) {
			List<Category> entities = categoryService.findByModuleId(MODULE_ID);
			
			HiararchyUtils hiararchyUtils = new HiararchyUtils();
			String selectOptions = hiararchyUtils.getHForSelect(entities, 0, 0);
			model.addAttribute("categorySelectOptions", selectOptions);
			
			model.addAttribute("entityForm", new Content());
			return MODULE_TEMPLATE_ROOT + "create";
        } else {

        	contentService.save(contentForm, file);
        	redirectAttributes.addFlashAttribute("message", "Successfully added..");
			return "redirect:/admin/content/index";
        }
		
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable Long id, Model model) {
		
		Content content = contentService.findById(id);
		
		if(content == null) {
			throw new ResourceNotFoundException("");
		}
		
		
		
		// get category list to select from
		List<Category> entities = categoryService.findByModuleId(MODULE_ID);
		HiararchyUtils hiararchyUtils = new HiararchyUtils();
	
		int contentCategoryId = 0;
		if(content.hasCategory()) {
			contentCategoryId = content.getCategory().getId();
		}
		String selectOptions = hiararchyUtils.getHForSelect(entities, contentCategoryId, 0);
		model.addAttribute("categorySelectOptions", selectOptions);
				
		model.addAttribute("entityForm", content);
		return MODULE_TEMPLATE_ROOT + "edit";
		
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public String update(@PathVariable Long id, @ModelAttribute("contentForm") Content contentForm, BindingResult bindingResult
			, @RequestParam("file") MultipartFile file, final RedirectAttributes redirectAttributes, Model model,
			HttpServletRequest request) {
			Map<String, String[]> parameterMap = request.getParameterMap();
		if (bindingResult.hasErrors()) {
			return "redirect:/admin/content/edit/"+id;
        } else {

        	contentService.update(contentForm, file, parameterMap);
        	redirectAttributes.addFlashAttribute("message", "Successfully updated..");
			return "redirect:/admin/content/index";
        }
	}

	/* @PreAuthorize("@roleBaseSecurityService.hasPermission(authentication, 'admin_content_delete')") */
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public String delete(@PathVariable Long id, final RedirectAttributes redirectAttributes) {
		
		contentService.deleteById(id);
		
		redirectAttributes.addFlashAttribute("message", "Successfully deleted!");
		
		return "redirect:/admin/content/index";
	}
}
