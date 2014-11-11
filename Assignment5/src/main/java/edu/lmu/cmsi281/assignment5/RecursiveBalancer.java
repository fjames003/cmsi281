package edu.lmu.cmsi281.assignment5;
import java.util.Stack;
public class RecursiveBalancer {
	public static boolean recursiveBalancer(String str) {
		Stack<Character> stash = new Stack<Character>();
		return recursiveBalancer(str, stash);
	}
	private static boolean recursiveBalancer(String str, Stack<Character> stack) {
		// If string is empty check to make sure stack is empty...
		if (str.length() == 0) {
			return stack.empty();
		// If the first letter is an open parens Push it...
		} else if (str.charAt(0) == '(' || str.charAt(0) == '[') {
			stack.push(str.charAt(0));
			return recursiveBalancer(str.substring(1), stack);
		// If its a closed parens peek the stack to see if the top item matches or if the stack is empty...
		} else if (str.charAt(0) == ')' || str.charAt(0) == ']') {
			if (stack.empty() 
				|| (str.charAt(0) == ')' && stack.peek() != '(')
		    	|| (str.charAt(0) == ']' && stack.peek() != '[')) {
				return false;
			// If its not empty and does match Pop it off
			} else {
				stack.pop();
				return recursiveBalancer(str.substring(1), stack);
			}
			// If this far the first character is not a parens, continue....
		} else {
			return recursiveBalancer(str.substring(1), stack);
		}
	}
}