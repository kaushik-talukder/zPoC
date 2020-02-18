package com.example.poc.lambdaExpSession.behavParam;

import com.example.poc.lambdaExpSession.apple.Apple;

public class AppleGreenColorFilter implements AppleFilter {
	@Override
	public boolean test(Apple apple) {
		return "green".equalsIgnoreCase(apple.getColor());
	}
}
