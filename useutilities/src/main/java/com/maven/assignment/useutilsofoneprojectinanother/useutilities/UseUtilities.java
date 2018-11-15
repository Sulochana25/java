package com.maven.assignment.useutilsofoneprojectinanother.useutilities;

import java.util.Stack;

import com.maven.assignment.useutilsofoneprojectinanother.DefiningUtils.DefineUtilities;

public class UseUtilities {
	public static void main(String args[]) {
		Stack<String> stack = new Stack<String>();
		DefineUtilities._push(stack, "one");
		DefineUtilities._push(stack, "two");
		DefineUtilities._push(stack, "three");

		System.out.println("Stack after adding elements:" + stack);

		DefineUtilities._pop(stack);
		DefineUtilities._pop(stack);

		System.out.println("Stack after removing top 2 elements:" + stack);
		DefineUtilities._push(stack, "two");
		DefineUtilities._push(stack, "three");

		System.out.println("Element at top of stack: " + DefineUtilities._peek(stack));

	}
}
