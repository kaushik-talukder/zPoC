package com.example.poc.iconcept;

import lombok.Data;

@Data
public class Rectangle implements Shape {

	private int length;
	private int breadth;

	Rectangle(int length, int breadth) {
		System.out.println("Rectangle Constructor");
		this.length = length;
		this.breadth = breadth;
	}

	Rectangle() {
		System.out.println("Rectangle Constructor");
	}

	@Override
	public Double area() {
		return (double) this.length * this.breadth;
	}
}