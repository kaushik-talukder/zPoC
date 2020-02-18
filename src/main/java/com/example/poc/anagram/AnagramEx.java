package com.example.poc.anagram;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramEx {

	boolean checkAnagram(String orinigal, String test) {
		Map<Character, Long> originalMap = orinigal.chars().mapToObj(c -> (char) c).collect(Collectors.toList()).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Map<Character, Long> testMap = test.chars().mapToObj(c -> (char) c).collect(Collectors.toList()).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(originalMap);
		System.out.println(testMap);
		return originalMap.equals(testMap);
	}

	public static void main(String[] args) {
		AnagramEx obj = new AnagramEx();
		System.out.println(obj.checkAnagram("forr", "fror"));
	}
}