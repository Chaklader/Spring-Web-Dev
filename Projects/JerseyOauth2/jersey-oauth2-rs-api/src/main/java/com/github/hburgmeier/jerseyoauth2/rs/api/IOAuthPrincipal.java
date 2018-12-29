package com.github.hburgmeier.jerseyoauth2.rs.api;

import java.util.Set;

import com.github.hburgmeier.jerseyoauth2.api.user.IUser;

public interface IOAuthPrincipal {

	IUser getUser();
	
	String getClientId();
	
	Set<String> getAllowedScopes();
	
}
