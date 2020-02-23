package com.learncs.zpoc.absclass;

public class MainStart {
	public static void main(String[] args) {
		Rectangle r = new Rectangle(10, 12);
		Square s = new Square(12);
		System.out.println(r.getShapeId() + ":" + r.area() + ":" + r.toString());
		System.out.println(s.getShapeId() + ":" + s.area() + ":" + s.toString());
		Shape c = Circle.getInstance(5);
		System.out.println(c.getShapeId() + ":" + c.area() + ":" + c.toString());
	}
}