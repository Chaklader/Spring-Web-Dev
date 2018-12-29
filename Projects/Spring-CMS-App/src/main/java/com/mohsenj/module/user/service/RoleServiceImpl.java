package com.mohsenj.module.user.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohsenj.module.user.model.Permission;
import com.mohsenj.module.user.model.Role;
import com.mohsenj.module.user.model.User;
import com.mohsenj.module.user.repository.RoleRepository;
import com.mohsenj.module.user.repository.UserRepository;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
    private RoleRepository roleRepository;
	
	@Autowired
    private UserRepository userRepository;
	
	@Override
	public List<Role> findAllRoles() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public Role findRoleAndPermissionByRoleId(int id) {
		return roleRepository.findRoleAndPermissionByRoleId(id);
	}

	@Override
	public List<Permission> findAllPermissions() {
		return roleRepository.findAllPermissions();
	}

	@Override
	public void updatePermissionRole(Role role) {

		// get original role from database
		Role OriginalRole = roleRepository.findOne(role.getId());
		
		// update original role
		OriginalRole.setPermissions(role.getPermissions());
		roleRepository.save(OriginalRole);
	/*	
	Set<Permission>	sp = new HashSet<Permission>();
	sp.add( roleRepository.getTestPermission());
	
	role.setSide(1);
	role.setTitle("rr");
	
	role.setPermissions(sp);
	*/
		
	}

	@Override
	public void updateUserWithRoles(User user) {

		User originalUser = userRepository.findOne(user.getId());
		
		// update original role
		originalUser.setRoles(user.getRoles());
		userRepository.save(originalUser);
		
	}

}
