package com.chapter2;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private String name;

	public User() {
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
}
