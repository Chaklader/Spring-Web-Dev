package com.mohsenj.core.lib.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.mohsenj.module.user.repository.UserRepository;


@Component("roleBaseSecurityService")
public class RoleBaseSecurityService {
	
	@Autowired UserRepository userRepository;
	
    public boolean hasPermission(Authentication authentication, String permission) {
    	
System.out.println("role= "+permission);
    	
    	System.out.println("cre=" + authentication + "vv=" + authentication.getAuthorities());
    	
    	if(!authentication.isAuthenticated()) {
    		return false;
    	}
    	
    	if(hasRole((UserDetails)authentication.getPrincipal(), permission)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    	
    /*	
    	return true;*/
    }

	private boolean hasRole(UserDetails principal, String permission) {

		int result = userRepository.findUserIfHasPermission(principal.getUsername(), permission);
		
		if(result == 0){
			return false;
		}
		
		return true;
	}
}
