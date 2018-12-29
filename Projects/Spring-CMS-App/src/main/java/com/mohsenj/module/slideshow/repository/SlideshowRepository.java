package com.mohsenj.module.slideshow.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.content.model.Content;
import com.mohsenj.module.module.model.Module;
import com.mohsenj.module.slideshow.model.Slideshow;

public interface SlideshowRepository extends JpaRepository<Slideshow, Integer>{

	@Modifying
	@Transactional
	@Query("delete from SlideshowItem sii WHERE sii.id in :ids")
	void deleteItems(@Param("ids") Set<Integer> ids);
	
	@Query("SELECT s FROM Slideshow s LEFT JOIN FETCH s.slideshowItems si WHERE s.id=:slideshowId")
	Slideshow findSlideshowWithItemsById(@Param("slideshowId") Integer slideshowId);

	@Query("DELETE FROM SlideshowItem sii WHERE sii.id=:id")
	void deleteItem(@Param("id") Integer id);

	@Query("SELECT s FROM Slideshow s LEFT JOIN FETCH s.slideshowItems si WHERE s.id=:slideshowId")
	Slideshow getSlideshowForShowById(@Param("slideshowId") int slideshowId);
	
}
