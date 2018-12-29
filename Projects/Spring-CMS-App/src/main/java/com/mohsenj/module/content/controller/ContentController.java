package com.mohsenj.module.content.controller;

import java.util.List;
import java.util.Set;

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
import com.mohsenj.module.comment.model.Comment;
import com.mohsenj.module.comment.service.CommentService;
import com.mohsenj.module.content.model.Content;
import com.mohsenj.module.content.service.ContentService;
import com.mohsenj.module.content.service.ContentServiceImp;
import com.mohsenj.module.menu.model.Menu;
import com.mohsenj.module.menu.repository.MenuRepository;

@Controller
@RequestMapping(value = "/content")
public class ContentController {

	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private ContentService contentService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CommentService commentService;
	
	private final String MODULE_TEMPLATE_ROOT = "site/module/content/";
	private final int MODULE_CONTENT_ID = 1;
	
	@RequestMapping(value="/show/{id}/{slug}", method=RequestMethod.GET)
	public String show(@PathVariable Long id, @PathVariable String slug, Model model) {
		
		Content content = contentService.findByIdForShow(id);
		
		if(content == null) {
			throw new ResourceNotFoundException();
		}
		
		Set<Comment> comments =  commentService.findModuleCommentsByIdForShow("CONTENT", Long.valueOf(content.getId()));
		content.setComments(comments);
		
		model.addAttribute("content", content);
		
		
		
		List<Menu> entities = menuRepository.findAll();

		HiararchyUtils hiararchyUtils = new HiararchyUtils();
		String mainMenuStr = hiararchyUtils.getMainMenu(entities, 0, null);
		System.out.println(mainMenuStr);
		model.addAttribute("mainMenuStr", mainMenuStr);
		
		
		
		
		return MODULE_TEMPLATE_ROOT + "show";
	}
	
	/**
	 * 
	 * @param id category id
	 * @param slug Category slug
	 * @param model
	 * @param page page number requested
	 * @return
	 */
	@RequestMapping(value="/catList/{id}/{slug}", method=RequestMethod.GET)
	public String catList(@PathVariable Integer id, @PathVariable String slug, Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
		
		// first get category and check slug
		Category category = categoryService.findById(id);
		
		if(category == null){
			throw new ResourceNotFoundException("Requested Category not found!");
		}
		
		if(!category.getSlug().equals(slug)) {
			return "redirect:/content/catList/"+id+"/"+category.getSlug();
		}
		
		Page<Content> result = contentService.getForCatListContents(id, page,size);
		PageWrapper<Content> pagination = new PageWrapper<Content>(result, "/blog");
	//	Page<Content> result = contentService.getForCatListContents(id, page)
		
		
		model.addAttribute("category", category);
		model.addAttribute("result", result);
		model.addAttribute("pagination", pagination);
		return MODULE_TEMPLATE_ROOT + "catlist";
	}
	
	//Page<PostView> postViewPage = PostView.pageOf(page, dateFactory);
    // List<PostView> posts = postViewPage.getContent();
    // model.addAttribute("posts", posts);
    // model.addAttribute("paginationInfo", new PaginationInfo(postViewPage));
}
