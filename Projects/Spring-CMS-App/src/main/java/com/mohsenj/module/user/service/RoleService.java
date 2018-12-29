package com.mohsenj.module.user.service;

import java.util.List;

import com.mohsenj.module.user.model.Permission;
import com.mohsenj.module.user.model.Role;
import com.mohsenj.module.user.model.User;

public interface RoleService {

	List<Role> findAllRoles();

	Role findRoleAndPermissionByRoleId(int id);

	List<Permission> findAllPermissions();

	void updatePermissionRole(Role entityForm);

	void updateUserWithRoles(User user);
}
