package com.example.poc.classconcept;

public class AppStart {
	public static void main(String[] args) {
		Point firstPoint = new Point(10, 20);
		Point secondPoint = new Point(5, 35);
		System.out.println(Point.origin.toString());
		System.out.println(firstPoint.distance(Point.origin));
		System.out.println(secondPoint.distance(Point.origin));
		System.out.println(firstPoint.distance(secondPoint));
		System.out.println(secondPoint.distance(firstPoint));
	}
}
