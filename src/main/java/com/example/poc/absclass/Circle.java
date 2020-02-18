package com.example.poc.absclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Circle extends Shape {

	private int radius;

	@Override
	public Double area() {
		return 2 * PI * radius;
	}

	private Circle(int radius) {
		System.out.println("Circle Constructor");
		this.radius = radius;
	}
		
	public static Circle getInstance(int rad) {
		Circle c = new Circle(rad);
		return c;
	}
		
}
