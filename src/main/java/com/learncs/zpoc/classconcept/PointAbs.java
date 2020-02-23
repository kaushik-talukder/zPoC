package com.learncs.zpoc.classconcept;

import lombok.Data;

@Data
public abstract class PointAbs {

	private int x;
	private int y;

	PointAbs(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public double distance(PointAbs otherPoint) {
		return Math.sqrt(Math.pow((this.x - otherPoint.x), 2) + Math.pow(this.y - otherPoint.y, 2));
	}
}
