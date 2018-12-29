package com.chapter4.shared;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private int id;
	private String name;

	public User() {
	}
	
	public User(int id,String name) {
		this.id = id;
		this.name = name;
	}

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
