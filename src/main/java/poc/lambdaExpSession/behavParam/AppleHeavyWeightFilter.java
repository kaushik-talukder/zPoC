package poc.lambdaExpSession.behavParam;

import poc.lambdaExpSession.apple.Apple;

public class AppleHeavyWeightFilter implements AppleFilter {
	@Override
	public boolean test(Apple apple) {
		return apple.getWeight() > 150;
	}
}
