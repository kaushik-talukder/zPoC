package com.learncs.zpoc.poc.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapEx {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("A", "A");
		map.put("B", "B");
		for (Entry<String, String> e : map.entrySet()) {
			System.out.println(e.getKey() + ":" + e.getValue());
		}
		map.forEach((key, value) -> System.out.println(key+"::"+value));
	}
}

