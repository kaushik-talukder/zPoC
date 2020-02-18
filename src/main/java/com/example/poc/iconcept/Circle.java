package com.example.poc.iconcept;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Circle implements Shape {

	private int radius;

	@Override
	public Double area() {
		return 2 * PI * radius;
	}

	Circle(int radius) {
		System.out.println("Circle Constructor");
		this.radius = radius;
	}

	public Double area(String shape) {
		return 1.0;
	}
}
