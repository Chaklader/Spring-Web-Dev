package com.chapter3;

import java.io.Serializable;

public class Person implements Serializable {
    public static final String PERSON_MIME_TYPE = "application/personMimeType";

    private int id;
    private String name;

    public Person() {
    }

    public Person(int id,String name) {
        this.id = id;
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
}
