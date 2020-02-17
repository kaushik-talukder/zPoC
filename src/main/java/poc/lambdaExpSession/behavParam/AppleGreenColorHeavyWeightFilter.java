package poc.lambdaExpSession.behavParam;

import poc.lambdaExpSession.apple.Apple;

public class AppleGreenColorHeavyWeightFilter implements AppleFilter {
	@Override
	public boolean test(Apple apple) {
		return "green".equalsIgnoreCase(apple.getColor()) 
				&& apple.getWeight() > 150;
	}
}
