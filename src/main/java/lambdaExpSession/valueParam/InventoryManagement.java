package lambdaExpSession.valueParam;

import java.util.ArrayList;
import java.util.List;

import lambdaExpSession.apple.Apple;
import lambdaExpSession.apple.AppleInventory;

public class InventoryManagement {

	private static List<Apple> filterGreenApple(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if ("green".equalsIgnoreCase(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}

	private static List<Apple> filterHeavyWeightApple(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (apple.getWeight() > 150) {
				result.add(apple);
			}
		}
		return result;
	}

	private static List<Apple> filterGreenHeavyWeightApple(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if ("green".equalsIgnoreCase(apple.getColor()) && apple.getWeight() > 150) {
				result.add(apple);
			}
		}
		return result;
	}

	private static List<Apple> filterAppleByColor(List<Apple> inventory, String color) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (color.equalsIgnoreCase(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}

	private static List<Apple> filterAppleByColorByWeight(List<Apple> inventory, String color, int weight) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (color.equalsIgnoreCase(apple.getColor()) && apple.getWeight() > weight) {
				result.add(apple);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<Apple> inventory = AppleInventory.createInventory();

		System.out.println(filterGreenApple(inventory));
		System.out.println(filterHeavyWeightApple(inventory));
		System.out.println(filterGreenHeavyWeightApple(inventory));

		System.out.println(filterAppleByColor(inventory, "red"));
		System.out.println(filterAppleByColorByWeight(inventory, "green", 150));
	}

}
