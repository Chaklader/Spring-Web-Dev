package com.apache.cxf.spring.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYER")
public class Player {

	// member variables
	@Id 
	@GeneratedValue
	@Column(name = "PLAYER_ID")
	private int playerId;

	@Column(name= "NAME")
	private String name;

	@Column(name= "AGE")
	private int age;

	@Column(name= "MATCHES")
	private int matches;

	// default constructor
	public Player() {
		super();
	}

	// 3-arg parameterized-constructor
	public Player(String name, int age, int matches) {
		super();
		this.name = name;
		this.age = age;
		this.matches = matches;
	}

	// 4-arg parameterized-constructor
	public Player(int playerId, String name, int age, int matches) {
		super();
		this.playerId = playerId;
		this.name = name;
		this.age = age;
		this.matches = matches;
	}

	// getter and setter
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMatches() {
		return matches;
	}
	public void setMatches(int matches) {
		this.matches = matches;
	}
}