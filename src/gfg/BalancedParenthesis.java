package gfg;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
Given a string str containing characters ‘(‘, ‘)’, ‘{‘, ‘}’, ‘[‘ and ‘]’, 
the task is to determine if brackets are balanced or not.

Brackets are balanced if:

	1. Open brackets must be closed by the same type of brackets.
	2. Open brackets must be closed in the correct order.
*/

public class BalancedParenthesis {

	private static Map<Character, Character> balancePair = new HashMap<>();
	static {
		balancePair.put('(', ')');
		balancePair.put('{', '}');
		balancePair.put('[', ']');
	}

	private static boolean isBalancedExpression(String exp) {
		boolean flag = false;
		boolean isStackError = false;
		Stack<Character> stack = new Stack<>();

		char[] expArr = exp.toCharArray();
		for (char ch : expArr) {
			if (balancePair.containsKey(ch)) {
				stack.push(ch);
			}
			if (balancePair.containsValue(ch)) {
				if (stack.isEmpty()) {
					isStackError = true;
					break;
				} else {
					char lastChar = stack.pop();
					if (ch != balancePair.get(lastChar)) {
						isStackError = true;
						break;
					}
				}
			}
		}
		if (!isStackError && stack.size() == 0) {
			flag = true;
		}
		return flag;
	}

	public static void main(String[] args) {
		String exp = "){[]}{}()";
		System.out.println(isBalancedExpression(exp));
	}
}
