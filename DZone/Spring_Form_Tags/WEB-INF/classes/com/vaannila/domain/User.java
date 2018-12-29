package com.vaannila.domain;

import java.util.List;

@SuppressWarnings("unchecked")
public class User {

	private String name;
	private String password;
	private String gender;
	private String country;
	private List countryList;
	private String aboutYou;
	private String[] community;
	private List communityList;
	private Boolean mailingList;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List getCountryList() {
		return countryList;
	}
	public void setCountryList(List countryList) {
		this.countryList = countryList;
	}
	public String getAboutYou() {
		return aboutYou;
	}
	public void setAboutYou(String aboutYou) {
		this.aboutYou = aboutYou;
	}
	public String[] getCommunity() {
		return community;
	}
	public void setCommunity(String[] community) {
		this.community = community;
	}
	public List getCommunityList() {
		return communityList;
	}
	public void setCommunityList(List communityList) {
		this.communityList = communityList;
	}
	public Boolean getMailingList() {
		return mailingList;
	}
	public void setMailingList(Boolean mailingList) {
		this.mailingList = mailingList;
	}
	
		
}
