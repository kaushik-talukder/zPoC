package com.learncs.zpoc.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SockMarchent {

	static int sockMerchant(int n, String[] ar) {
		Map<String, Long> map = Arrays.asList(ar).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		for (Entry<String, Long> e : map.entrySet()) {
			System.out.println(e.getKey() + "::" + e.getValue());
		}
		return (int) Math.abs(map.get("U") - map.get("D"));

	}

	public static void main(String[] args) {

		System.out.println(sockMerchant(6, "UUDDD".split("")));
	}
}
