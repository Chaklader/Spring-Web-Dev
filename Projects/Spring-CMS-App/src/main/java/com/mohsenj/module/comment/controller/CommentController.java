package com.mohsenj.module.comment.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mohsenj.module.comment.model.Comment;
import com.mohsenj.module.comment.service.CommentService;


@Controller
@RequestMapping(value="/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "/save", method = RequestMethod.POST/*,  consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE*/)
	@ResponseBody
	public Map<String,String> saveComment(@RequestParam("content") String content, @RequestParam("id") String idStr) {
		
		System.out.println(Comment.class.getClass());
		// get all comments
	//	List<Comment> comments = commentService.findAllByType(ContentComment.class.getClass());
		List<Comment> comments = commentService.findAllContentComment();

		System.out.println(comments);
		
	//	String content = requet.getParameter("content");
	//	System.out.println("content= "+content + " adn id = "+requet.getParameter("id") + " and map = "+requet.getParameterMap());
			System.out.println("content= "+content + " adn id = "+idStr);

		Long id = Long.parseLong(idStr);
		
		Comment c = new Comment();
		c.setContent(content);
		c.setItemId(id);
		c.setStatus(1);
		c.setCreatedAt(new Date());
		c.setItemType("CONTENT");
		commentService.save(c);
		
		
		
		Map<String,String> result = new HashMap<String,String>();
		result.put("status", "success");
	   
		
		
		return result;
	}
}
