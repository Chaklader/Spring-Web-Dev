package com.mohsenj.module.user.repository;

import com.mohsenj.module.user.model.Permission;
import com.mohsenj.module.user.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.lang.Integer;
import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	
	@Query("SELECT r FROM Role r LEFT JOIN FETCH r.permissions p where r.id=:id")
	Role findRoleAndPermissionByRoleId(@Param("id") Integer id);

	@Query("SELECT p FROM Permission p")
	List<Permission> findAllPermissions();
	
	@Query("SELECT p FROM Permission p where id=1")
	Permission getTestPermission();

	Role findByName(String name);
}

