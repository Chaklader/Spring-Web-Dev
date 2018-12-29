package com.mohsenj.module.comment.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.category.repository.CategoryRepository;
import com.mohsenj.module.comment.model.Comment;
import com.mohsenj.module.comment.repository.CommentRepository;
import com.mohsenj.module.content.model.Content;
import com.mohsenj.core.util.StringUtils;

@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Override
	public void save(Comment category) {

		commentRepository.save(category);
	}

	@Override
	public Comment findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comment> findAllByType(Class<? extends Class> class1) {

		return null;//commentRepository.findAllByType(class1);
	}

	@Override
	public List<Comment> findAllContentComment() {

		return commentRepository.findAllContentComment();
	}

	@Override
	public Page<Comment> findAll(Pageable pageRequest) {
		return commentRepository.findAll(pageRequest);
	}

	@Override
	public void updateStatus(long id, String status) {
		
		int statusInt = 0;
		
		if(status.equals("activate")) {
			statusInt = 1;
		}
		
		commentRepository.updateStatus(id, statusInt);
		
	}
	
	
	@Override
	public Set<Comment> findModuleCommentsByIdForShow(String itemType, Long itemId) {

		return commentRepository.findModuleCommentsByIdForShow(itemType, itemId);
	}
}
