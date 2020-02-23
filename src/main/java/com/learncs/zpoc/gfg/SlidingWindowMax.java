package com.learncs.zpoc.gfg;

import java.util.Stack;
import java.util.StringJoiner;

/*
Give an array arr[] of N integers and another integer k <= N. 
The task is to find the maximum element of every sub-array of size k.
*/

public class SlidingWindowMax {

	private void maxNumbers(int[] arr, int windowSize) {
		if(windowSize > arr.length) {
			System.out.println("Window size is greater than array");
			System.exit(0);
		}
		Stack<Integer> stack = new Stack<>();
		int k = windowSize;
		StringJoiner sj = new StringJoiner(",", "[", "]");
		for (int i = 0; i < arr.length - windowSize + 1; i++) {
			stack.clear();
			k = windowSize;
			while (k > 0) {
				if (stack.isEmpty()) {
					stack.push(arr[i + k - 1]);
				} else {
					if (arr[i + k - 1] > stack.peek()) {
						stack.pop();
						stack.push(arr[i + k - 1]);
					}
				}
				k--;
			}
			sj.add(stack.pop() + "");
		}
		System.out.println(sj.toString());
	}

	public static void main(String[] args) {
		SlidingWindowMax obj = new SlidingWindowMax();
		int[] arr = new int[] { 10, 2, 3, 5};
		int windowSize = 3;
		obj.maxNumbers(arr, windowSize);
	}
}
