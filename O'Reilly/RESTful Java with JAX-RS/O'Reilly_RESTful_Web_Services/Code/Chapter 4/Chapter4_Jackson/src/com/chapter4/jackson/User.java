package com.chapter4.jackson;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;


@XmlRootElement(name = "user")
public class User {

	@JsonProperty
	private int id;
	
	@JsonProperty
	private String name;

	public User() {

	}

	public User(int id,String name) {
		this.id = id ;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return "User <> Id: " + id + ", Name: " + name;
	}
}
