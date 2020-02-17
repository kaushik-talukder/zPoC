package stream;

import java.util.ArrayList;
import java.util.List;

public class Factory {
	public static List<Integer> getIntegerList(int size) {
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			l.add((int) (Math.random() * 100));
		}
		return l;
	}
}
