package com.mohsenj.module.category.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.module.model.Module;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
//	 List<Category> findByModule(Module module);
	@Transactional
	 @Query("SELECT c FROM Category c  WHERE c.module.id = :module_id")
	 List<Category> findByModuleId(@Param("module_id") int module_id);
	 
     @Transactional
	 @Query("SELECT c FROM Category c  WHERE c.id = :id")
	 Category findById(@Param("id") Integer id);

	 @Modifying
		@Transactional
	    @Query("UPDATE Category c SET c.name = :name, c.slug=:slug, module_id=:module_id, c.parentId=:parentId WHERE c.id = :contentId")
	    int update(@Param("contentId") Integer contentId,
	    		@Param("name") String name, @Param("slug") String slug, @Param("module_id") Module module, @Param("parentId") Integer parentId
	    		);
	
	void delete(Integer id);

	@Query("SELECT c FROM Category c JOIN c.module m WHERE m.name = :moduleName")
	List<Category> getModuleCategoriesByName(@Param("moduleName") String moduleName);
	
	
	
}
