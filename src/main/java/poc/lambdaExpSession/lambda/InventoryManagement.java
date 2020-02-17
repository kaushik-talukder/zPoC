package poc.lambdaExpSession.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import poc.lambdaExpSession.apple.Apple;
import poc.lambdaExpSession.apple.AppleInventory;
import poc.lambdaExpSession.behavParam.AppleFilter;

public class InventoryManagement {
	public static List<Apple> filterApples(List<Apple> inventory, AppleFilter filter) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (filter.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static <T> List<T> filter(List<T> list, FilterPredicate<T> p) {
		List<T> result = new ArrayList<>();
		for (T e : list) {
			if (p.test(e)) {
				result.add(e);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<Apple> inventory = AppleInventory.createInventory();

		System.out.println(filterApples(inventory, (Apple apple) -> "green".equalsIgnoreCase(apple.getColor())));
		System.out.println(filterApples(inventory, (Apple apple) -> apple.getWeight() > 150));
		System.out.println(filterApples(inventory,
				(Apple apple) -> "green".equalsIgnoreCase(apple.getColor()) && apple.getWeight() > 150));

		// Abstracting over list type
		System.out.println(filter(inventory, (Apple apple) -> "green".equalsIgnoreCase(apple.getColor())));
		System.out.println(filter(inventory, (Apple apple) -> apple.getWeight() > 150));
		System.out.println(filter(inventory,
				(Apple apple) -> "green".equalsIgnoreCase(apple.getColor()) && apple.getWeight() > 150));
		
		//Find even numbers
		List<Integer> numbers = Arrays.asList(new Integer(1), new Integer(2), new Integer(3), new Integer(4));
		System.out.println(filter(numbers, (Integer i) -> i % 2 == 0));
	}
}
