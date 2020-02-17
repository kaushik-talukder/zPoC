package poc.lambdaExpSession.behavParam;

import java.util.ArrayList;
import java.util.List;

import poc.lambdaExpSession.apple.Apple;
import poc.lambdaExpSession.apple.AppleInventory;

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

	public static void main(String[] args) {
		List<Apple> inventory = AppleInventory.createInventory();

		//Using class
		System.out.println(filterApples(inventory, new AppleGreenColorFilter()));
		System.out.println(filterApples(inventory, new AppleHeavyWeightFilter()));
		System.out.println(filterApples(inventory, new AppleGreenColorHeavyWeightFilter()));
		
		//Using anonymous class
		System.out.println(filterApples(inventory, new AppleFilter(){
			public boolean test(Apple apple){
				return "green".equalsIgnoreCase(apple.getColor());
			}
		}));
		
		System.out.println(filterApples(inventory, new AppleFilter(){
			public boolean test(Apple apple){
				return apple.getWeight() > 150;
			}
		}));
		
		System.out.println(filterApples(inventory, new AppleFilter(){
			public boolean test(Apple apple){
				return "green".equalsIgnoreCase(apple.getColor()) && apple.getWeight() > 150;
			}
		}));
	}

}
