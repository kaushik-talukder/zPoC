package com.learncs.zpoc.lambdaExpSession.behavParam;

import com.learncs.zpoc.lambdaExpSession.apple.Apple;

public class AppleGreenColorFilter implements AppleFilter {
	@Override
	public boolean test(Apple apple) {
		return "green".equalsIgnoreCase(apple.getColor());
	}
}
