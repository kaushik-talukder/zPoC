package com.example.poc.gfg;

import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
class Height {
	int feet;
	int inches;

	public Height(int ft, int inc) {
		feet = ft;
		inches = inc;
	}

}

public class GfG {
	public static int findMax(Height arr[], int n) {
		// your code here
		List<Height> heightList = Arrays.asList(arr);
		Height maxHeight = heightList.stream()
				.reduce((h1, h2) -> h1.getFeet() >= h2.getFeet() ? (h1.getInches() >= h2.getInches() ? h1 : h2) : h2)
				.get();
		System.out.println(maxHeight);
		return maxHeight.feet * 12 + maxHeight.inches;
	}

	public static void main(String[] args) {
		Height h1 = new Height(4, 7);
		Height h2 = new Height(4, 6);
		Height h3 = new Height(6, 9);
		Height[] heightAr = new Height[3];
		heightAr[0] = h1;
		heightAr[1] = h2;
		heightAr[2] = h3;

		System.out.println(findMax(heightAr, heightAr.length));
	}
}
