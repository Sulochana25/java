package com.maven.assignment.useutilsofoneprojectinanother.DefiningUtils;

import java.util.Stack;

public class DefineUtilities {
	public static Stack _push(Stack stack, String str) {
		stack.push(str);
		return stack;
	}

	public static Stack _pop(Stack stack) {
		stack.pop();
		return stack;
	}

	public static String _peek(Stack stack) {

		return (String) stack.peek();
	}
}
