package com.example.poc.absclass;

public abstract class Shape {
	protected final static Double PI = 3.1415;
	private static int uid = 0;
	protected int shapeId;

	public abstract Double area();

	Shape() {
		System.out.println("Shape Constructor");
		shapeId = ++uid;
	}

	public int getShapeId() {
		return shapeId;
	}
}
