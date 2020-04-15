package com.learncs.zpoc.declarationAndAccessControl.pkgb;

import com.learncs.zpoc.declarationAndAccessControl.pkga.Foo;

/*
 What is the result?
 A. 5 6 7
 B. 5 followed by an exception
 C. Compilation fai;s with an error on line 7
 D. Compilation fai;s with an error on line 8
 E. Compilation fai;s with an error on line 9
 F. Compilation fai;s with an error on line 10
 
 Answer: D, E
 
 Notes:
 1. There are three access modifiers: public, protected, and private.
 2. There are four access levels: public, protected, default, and private.
 3. Classes can have only public or default access.
 4. A class with default access can be seen only by classes within the same package.
 5. A class with public access can be seen by all classes from all packages.
 6. Class visibility revolves around whether code in one class can
 		a. Create an instance of another class
 		b. Extend (or subclass) another class
 		c. Access methods and variables of another class
 */

public class Baz {
	public static void main(String[] args) {
		Foo f = new Foo();	// Line 7
		// Default scope. Should be in the same package
		//System.out.print(" " + f.a); // Line 8
		
		// Protected scope. Until and unless it is sub-classed it is not visible 
		//System.out.print(" " + f.b); // Line 9
		
		// Public scope. Visible to anybody.
		System.out.println(" " + f.c); // Line 10
	}
}
