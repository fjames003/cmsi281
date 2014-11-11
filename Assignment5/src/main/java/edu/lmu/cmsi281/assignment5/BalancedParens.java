package edu.lmu.cmsi281.assignment5;
import java.util.Stack;
public class BalancedParens {
    public static boolean balancedParens(String str) {
		Stack<Character> stash = new Stack<Character>();
		char current;
		for (int i = 0; i < str.length(); i++) {
			current = str.charAt(i);
			if (current == '(' || current == '[') {
				stash.push(current);
			} else if (current == ')' || current == ']') {
				if (stash.empty()) {
					return false;
				} else {
					if (current == ')' && stash.peek() == '(') {
						stash.pop();
					} else if (current == ']' && stash.peek() == '[') {
						stash.pop();
					} else {
						return false;
					}
				}
			}
		}
		return stash.empty();
	}
}