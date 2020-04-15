package com.learncs.zpoc.declarationAndAccessControl;

/*

Which are true?
A. As the code stands, the output is bang
B. As the code stands, the output is sh-bang
C. As the code stands, compilation fails
D. If line A is uncommented, the output is bang bang
E. If line A is uncommented, the output is sh-bang bang
F. If line A is uncommented, compilation fails

Answer: 
B: It will invoke blastOff() from the type Shuttle
F: The method blastOff() from the type Rocket is not visible

Few more notes:
1. We cannot reduce the visibility of the inherited method from parent class
2. We cannot make a static reference to the non-static method blastOff()
3. To invoke a method in a parent class which is overridden use super.methodName()

 */

class Rocket {
	private void blastOff() {
		System.out.println("bang ");
	}
}

public class Shuttle extends Rocket {
	public static void main(String[] args) {
		new Shuttle().go();
	}

	private void go() {
		blastOff();
		// Rocket.blastOff(); // Line A
	}

	private void blastOff() {
		System.out.println("sh-bang ");
	}
}
