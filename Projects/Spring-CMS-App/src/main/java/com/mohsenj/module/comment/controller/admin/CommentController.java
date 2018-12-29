package com.mohsenj.module.comment.controller.admin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mohsenj.core.lib.exception.ResourceNotFoundException;
import com.mohsenj.core.util.HiararchyUtils;
import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.category.service.CategoryService;
import com.mohsenj.module.comment.model.Comment;
import com.mohsenj.module.comment.service.CommentService;
import com.mohsenj.module.content.model.Content;
import com.mohsenj.module.module.service.ModuleService;
import com.mohsenj.module.module.model.Module;


@Controller("Admin CommentController")
@RequestMapping(value="/admin/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;

	private final String MODULE_TEMPLATE_ROOT = "admin/module/comment/";

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model, @RequestParam(defaultValue = "1") int page) {
		page--;
		Pageable pageRequest = new PageRequest(page, 10/*pageSize*/, Sort.Direction.DESC, "id");
		Page<Comment> result = commentService.findAll(pageRequest);
	        System.out.println(result);
	    model.addAttribute("page", result);
		
		return MODULE_TEMPLATE_ROOT + "index";
	}
	
	@RequestMapping(value = "/changeStatus/{id}", method = RequestMethod.POST)
	public String changeStatus(Model model, @PathVariable long id, @RequestParam String status) {
		
		commentService.updateStatus(id, status);
		
		return "redirect:/admin/comment/index";
	}
}
