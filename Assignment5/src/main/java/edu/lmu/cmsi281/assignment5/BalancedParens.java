package edu.lmu.cmsi281.assignment5;
import java.util.Stack;
public class BalancedParens {
    public boolean balancedParens(String str) {
		Stack stash = new Stack();
		char current;
		for (int i = 0; i < str.length(); i++) {
			current = str.charAt(i);
			if (current == '(' || current == '[') {
				stash.push(current);
			} else if (current == ')' || current == ']') {
				if (stash.empty()) {
					return false;
				} else {
					stash.pop();
				}
			}
		}
		return stash.empty();
	}
}