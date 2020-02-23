package com.learncs.zpoc.stream;

import java.util.List;
import java.util.stream.Collectors;

public class SeqStream {
	public static void main(String[] args) {
		List<Integer> l = Factory.getIntegerList(100);
		PrintItem p = (int a) -> {
			System.out.println(a);
		};

		List<Integer> a = l.stream().distinct().filter(i -> i > 50).collect(Collectors.toList());

		a.forEach(i -> p.print(i));

	}
}
