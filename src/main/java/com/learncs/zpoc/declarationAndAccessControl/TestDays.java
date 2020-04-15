package com.learncs.zpoc.declarationAndAccessControl;

/*
What is the result?
A. TUE
B. WED
C. The output is unpredictable
D. Compilation fails due to an error on line 4
E. Compilation fails due to an error on line 6
F. Compilation fails due to an error on line 8
G. Compilation fails due to an error on line 9

Answer: B
Every enum comes with a static values() method that returns an array of the enum’s values in the order in which they are declared in the enum

*/

public class TestDays {

	public enum Days { //Line 4
		MON, TUE, WED
	};

	public static void main(String[] args) {
		for (Days d : Days.values()) //Line 6
			;
		Days[] d2 = Days.values(); //Line 8
		System.out.println(d2[2]); //Line 9
	}
}
