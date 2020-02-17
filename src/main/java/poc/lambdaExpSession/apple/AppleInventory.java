package poc.lambdaExpSession.apple;

import java.util.ArrayList;
import java.util.List;

public class AppleInventory {
	public static List<Apple> createInventory() {
		Apple a1 = Apple.builder().color("green").weight(160).build();
		Apple a2 = Apple.builder().color("red").weight(155).build();
		Apple a3 = Apple.builder().color("green").weight(140).build();

		List<Apple> inventory = new ArrayList<>();
		inventory.add(a1);
		inventory.add(a2);
		inventory.add(a3);
		return inventory;
	}
}
