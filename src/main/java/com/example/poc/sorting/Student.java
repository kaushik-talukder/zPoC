package com.example.poc.sorting;

import java.util.StringJoiner;

public class Student {
	private int id;
	private String name;
	
	public Student(int id, String name) {
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
	
	@Override
	public String toString() {
		StringJoiner sj2 = new StringJoiner(",", "[", "]");
		sj2.add("id=" + id);
		sj2.add("name=" + name);
		return this.getClass().getName()+ sj2.toString();
	}
}
