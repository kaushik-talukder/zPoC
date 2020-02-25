package com.learncs.zpoc.declarationAndAccessControl;


/*
What is the result?
A. Compilation succeeds
B. Compilation fails with an error on line 1
C. Compilation fails with an error on line 3
D. Compilation fails with an error on line 6
E. Compilation fails with an error on line 7
F. Compilation fails with an error on line 9

Answer: A (All are legal statements)

*/

public class Electronic implements Device { // Line 1
	public void doIt() {

	}
}

abstract class Phone1 extends Electronic { // Line 3

}

abstract class Phone2 extends Electronic { // Line 5
	public void doIt(int x) {

	}
}

class Phone3 extends Electronic implements Device { // Line 7
	public void doStuff() {
	
	}
}

interface Device { // Line 9
	public void doIt();
}