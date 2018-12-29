package com.vaannila.service;

import java.util.List;

import com.vaannila.domain.Community;
import com.vaannila.domain.Country;
import com.vaannila.domain.User;

public interface UserService {

	public void add(User user);
	public List<Country> getAllCountries();
	public List<Community> getAllCommunities(); 
}
