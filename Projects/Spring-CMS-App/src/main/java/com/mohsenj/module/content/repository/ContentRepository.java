package com.mohsenj.module.content.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.content.model.Content;

public interface ContentRepository extends JpaRepository<Content, Long>{

	@Query("SELECT c FROM Content c LEFT JOIN FETCH c.comments cc WHERE c.id=:id AND (cc.id is NULL OR cc.status=1)")
	Content findById(@Param("id") Long id);
	
	@Modifying
	@Transactional
    @Query("UPDATE Content c SET c.title = :title, c.slug=:slug, content=:content, category=:category, fileName=:fileName WHERE c.id = :contentId")
    int update(@Param("contentId") Long contentId,
    		@Param("title") String title, @Param("slug") String slug, @Param("content") String content,
    		@Param("category") Category category, @Param("fileName") String fileName
    		);
	
	
    Page<Content> findAll(Pageable pageRequest);

	@Query("SELECT c FROM Content c LEFT JOIN FETCH c.category cat WHERE c.id=:id")
	Content findByIdForShow(@Param("id") Long id);

	
	
	@Query(value = "SELECT c FROM Content c JOIN c.category ca WHERE ca.id = :categoryId"/*,
		    countQuery = "SELECT c FROM Content c LEFT JOIN FETCH c.category ca WHERE ca.id = :categoryId",
		    nativeQuery = true*/)
	Page<Content> findForCatListContents(@Param("categoryId") Integer categoryId, Pageable pageable);

	@Query(value = "SELECT c FROM Content c LEFT JOIN c.category ca WHERE c.status=1")
	Page<Content> getLatestContent(Pageable pageable);
	
}
