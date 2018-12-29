package com.mohsenj.module.menu.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.mohsenj.module.menu.model.Menu;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface MenuRepository extends JpaRepository<Menu, Integer>{
	
	@Query("SELECT m FROM Menu m WHERE m.parentId = null ORDER BY m.ordering DESC")
	List<Menu> findRootMenusOrdeingDesc();

	@Query("SELECT m FROM Menu m ORDER BY m.ordering ASC")
	List<Menu> findAllOrderByOrderingAsc();

	@Modifying
	@Transactional
	@Query("UPDATE Menu m SET m.parentId=:parentId where m.parentId = :OldParentid")
	void update(@Param("OldParentid") Integer OldParentid, @Param("parentId") Integer parentId);
	
	
	@Modifying
	@Transactional
	@Query("UPDATE Menu m SET m.parentId=:parentId where m.parentId = :OldParentid")
	void updateChildrenParentId(@Param("OldParentid") Integer OldParentid, @Param("parentId") Integer parentId);
	
}
