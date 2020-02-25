package com.learncs.zpoc.declarationAndAccessControl;

/*
What is the result?
A. 13
B. Compilation fails due to multiple errors
C. Compilation fails due to an error on line 6
D. Compilation fails due to an error on line 7
E. Compilation fails due to an error on line 11

Answer: D
The countGold() method cannot be invoked from a static context
 
 */
public class Frodo extends Hobbit {
	public static void main(String[] args) {
		int myGold = 7; //Line 6
		// System.out.println(countGold(myGold, 6)); //Line 7
	}
}

class Hobbit {
	int countGold(int x, int y) { //Line 11
		return x + y;
	}
}
