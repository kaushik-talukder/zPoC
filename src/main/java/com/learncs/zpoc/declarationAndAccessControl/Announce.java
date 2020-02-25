package com.learncs.zpoc.declarationAndAccessControl;

/*
What is the result?
A. Compilation succeeds
B. Compilation fails with an error on line 6
C. Compilation fails with an error on line 7
D. Compilation fails with an error on line 8
E. Compilation fails with an error on line 9	

Answer: C, D
*/

class Announce {
	public static void main(String[] args) {
		for(int __x = 0; __x < 3; __x++); // Line 6
		
		//Variable name can't begin with a #
		//int #lb = 7; // Line 7
		
		//An array declaration can't include a size without an instantiation
		//long[] x[5]; // Line 8
		Boolean[] ba[]; // Line 9
	}
}
