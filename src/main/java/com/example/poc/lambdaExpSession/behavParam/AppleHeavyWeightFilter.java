package com.example.poc.lambdaExpSession.behavParam;

import com.example.poc.lambdaExpSession.apple.Apple;

public class AppleHeavyWeightFilter implements AppleFilter {
	@Override
	public boolean test(Apple apple) {
		return apple.getWeight() > 150;
	}
}
