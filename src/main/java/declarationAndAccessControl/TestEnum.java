package declarationAndAccessControl;

/*
What is the result?
A. woof burble
B. Multiple compilation errors
C. Compilation fails due to an error on line 2
D. Compilation fails due to an error on line 3
E. Compilation fails due to an error on line 4
F. Compilation fails due to an error on line 9

Answers: A, enum can have constructor and variables

Notes:
1. An enum specifies a list of constant values assigned to a type.
2. An enum is NOT a String or an int; an enum constant’s type is the enum type. For example, SUMMER and FALL are of the enum type Season.
3. An enum can be declared outside or inside a class, but NOT in a method. 
		When declared inside a method, it shows "The member enum Animals can only be defined inside a top-level class or interface or in a static context"
4. An enum declared outside a class must NOT be marked static, final, abstract, protected, or private.
5. enums can contain constructors, methods, variables, and constant-specific class bodies.
6. enum constants can send arguments to the enum constructor, using the syntax BIG(8), where the int literal 8 is passed to the enum constructor.
7. enum constructors can have arguments and can be overloaded.
8. enum constructors can NEVER be invoked directly in code. They are always called automatically when an enum is initialized.
		Very very important
9. The semicolon at the end of an enum declaration is optional. These are legal: enum Foo { ONE, TWO, THREE} enum Foo { ONE, TWO, THREE};
10. MyEnum.values() returns an array of MyEnum’s values.

*/

enum Animals {
	DOG("woof"), CAT("meow"), FISH("burble"); // Line 2
	String sound; // Line 3
	Animals(String s) {sound = s; } // Line 4
}
class TestEnum {
	static Animals a;
	public static void main(String[] args) {
		System.out.println(a.DOG.sound + " " + a.FISH.sound); // Line 9
	}
}