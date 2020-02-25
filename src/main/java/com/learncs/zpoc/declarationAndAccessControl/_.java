package com.learncs.zpoc.declarationAndAccessControl;

import static java.lang.System.*;

/*

What is the result?
A. -A
B. A.
C. -A.
D. _A.
E. _-A.
F. Compilation fails
G. An exception is thrown at runtime 

Answer: B

 */

class _ {
	public static void main(String[] __A_V_) {
		// Run time arg
		__A_V_ = new String[] { "-", "A", "." };

		String $ = "";

		for (int x = 0; ++x < __A_V_.length;)
			$ += __A_V_[x];

		out.println($);

	}
}