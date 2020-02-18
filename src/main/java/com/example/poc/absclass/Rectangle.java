package com.example.poc.absclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Rectangle extends Shape {

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