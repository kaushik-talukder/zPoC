package lambdaExpSession.behavParam;

import lambdaExpSession.apple.Apple;

public class AppleHeavyWeightFilter implements AppleFilter {
	@Override
	public boolean test(Apple apple) {
		return apple.getWeight() > 150;
	}
}
