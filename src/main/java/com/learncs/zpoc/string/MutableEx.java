package com.learncs.zpoc.string;

public class MutableEx {
	public void foo(String s) {
		System.out.println("String");
	}

	public void foo(StringBuffer sb) {
		System.out.println("StringBuffer");
	}

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = new String("abc");
		s2 = s2.intern();
		System.out.println(s1 == s2);
	}
}
