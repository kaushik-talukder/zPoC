package com.example.poc.restws;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class User {
	private Integer id;
	@Size(min = 2, message = "Name should have at least 2 characters")
	private String name;

	public User() {
	}

	public User(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
