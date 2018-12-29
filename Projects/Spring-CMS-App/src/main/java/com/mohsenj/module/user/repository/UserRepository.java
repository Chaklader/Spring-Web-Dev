package com.mohsenj.module.user.repository;

import com.mohsenj.module.category.model.Category;
import com.mohsenj.module.user.model.Role;
import com.mohsenj.module.user.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    
     @Transactional
	 @Query("SELECT c FROM Category c  WHERE c.module.id = :module_id")
	 List<Category> findByModuleId(@Param("module_id") int module_id);
	 
     @Transactional
	 @Query("SELECT count(u) FROM User u join u.roles r join r.permissions p WHERE u.username = :username and p.name=:permission")
	 int findUserIfHasPermission(@Param("username") String username, @Param("permission") String permission);

 	@Query("SELECT u FROM User u LEFT JOIN FETCH u.roles r where u.id=:userId")
     User findUserAndRolesByUserId(@Param("userId") long userId);
 	
 	@Query("SELECT u FROM User u where u.email=:email")
    User findByEmail(@Param("email") String email);
}
