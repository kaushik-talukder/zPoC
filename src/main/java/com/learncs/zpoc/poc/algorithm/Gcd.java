package com.learncs.zpoc.poc.algorithm;

public class Gcd {

	private static int calGcd(int m, int n) {
		int r;
		r = n % m;
		if (r > 0) {
			n = m;
			m = r;
			return calGcd(m, n);
		} else {
			return m;
		}
	}

	public static void main(String[] args) {
		System.out.println(calGcd(12587963, 120));
	}
}
