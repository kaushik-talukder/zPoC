package com.example.poc.iconcept;

public class MainStart {
	public static void main(String[] args) {
		Rectangle r = new Rectangle(10, 12);
		Square s = new Square(12);
		System.out.println(r.area() + ":" + r.toString());
		System.out.println(s.area() + ":" + s.toString());
		Shape c = new Circle(5);
		System.out.println(c.area("assa") + ":" + c.toString());
	}
}