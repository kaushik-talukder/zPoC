package poc.lambdaExpSession.behavParam;

import poc.lambdaExpSession.apple.Apple;

public class AppleGreenColorFilter implements AppleFilter {
	@Override
	public boolean test(Apple apple) {
		return "green".equalsIgnoreCase(apple.getColor());
	}
}
