package com.mohsenj.module.page.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import com.mohsenj.core.util.pagination.PageWrapper;
import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.category.service.CategoryService;
import com.mohsenj.module.content.model.Content;
import com.mohsenj.module.content.service.ContentService;
import com.mohsenj.module.content.service.ContentServiceImp;
import com.mohsenj.module.menu.model.Menu;
import com.mohsenj.module.menu.repository.MenuRepository;
import com.mohsenj.module.page.service.PageService;
import com.mohsenj.module.slideshow.model.Slideshow;
import com.mohsenj.module.slideshow.service.SlideshowService;

@Controller
public class PageController {

	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private ContentService contentService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SlideshowService slideshowService;
	
	@Autowired
	private PageService pageService;
	
	private final String MODULE_TEMPLATE_ROOT = "site/module/page/";
	private final int MODULE_CONTENT_ID = 1;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model) {

		
		int categoryId = 1;
		Page<Content> result = contentService.getForCatListContents(categoryId, 1,3);
		PageWrapper<Content> pagination = new PageWrapper<Content>(result, "/blog");
		Category category = categoryService.findById(categoryId);
		
		model.addAttribute("category", category);
		model.addAttribute("contents", result);
		model.addAttribute("pagination", pagination);
		
		Slideshow slideshow = slideshowService.getSlideshowForShowById(1);
		model.addAttribute("slideshow", slideshow);
		return MODULE_TEMPLATE_ROOT + "home";
	}
	
	@RequestMapping(value="p-{id}/{slug}", method=RequestMethod.GET)
	public String pageShow(@PathVariable Integer id, @PathVariable String slug,Model model) {
		
		com.mohsenj.module.page.model.Page page = pageService.findById(id);
		
		if(page == null) {
			throw new ResourceNotFoundException();
		}
		
		if(!slug.equals(page.getSlug())) {
			return "redirect:/p-"+id+"/"+page.getSlug();
		}
		
		model.addAttribute("page", page);
		return MODULE_TEMPLATE_ROOT + "showpage";
	}

}
