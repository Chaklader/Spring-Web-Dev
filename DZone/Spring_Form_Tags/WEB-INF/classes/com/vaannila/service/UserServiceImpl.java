package com.vaannila.service;

import java.util.ArrayList;
import java.util.List;

import com.vaannila.domain.Community;
import com.vaannila.domain.Country;
import com.vaannila.domain.User;

public class UserServiceImpl implements UserService {

	@Override
	public void add(User user) {
		//Persist the user object here. 
		System.out.println("User added successfully");

	}

	@SuppressWarnings("unchecked")
	@Override
	public List getAllCountries() {
		List countryList = new ArrayList();
		countryList.add(new Country(1,"India"));
		countryList.add(new Country(2,"USA"));
		countryList.add(new Country(3,"UK"));
		return countryList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List getAllCommunities() {
		List communityList = new ArrayList();
		communityList.add(new Community("Spring","Spring"));
		communityList.add(new Community("Hibernate","Hibernate"));
		communityList.add(new Community("Struts","Struts"));
		return communityList;
	}

}
