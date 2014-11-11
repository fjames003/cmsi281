package edu.lmu.cmsi281.assignment5;
public class StringIntConv {
    public static int stringIntConv(String num) {
		if (num.length() == 1) {
			return num.charAt(0) - '0';
		} else {
			return stringIntConv(num, 0);
		}
	}
	private static int stringIntConv(String num, int sum) {
		char currentChar = num.charAt(0);
		if (currentChar < '0' || currentChar > '9') {
			throw new IllegalArgumentException("Only non-negative integers");
		}
		if (num.length() == 1) {
			return sum + (currentChar - '0');
		} else {
			int multiplier = (int)Math.pow(10, num.length() - 1);
			return stringIntConv(num.substring(1), sum + ((currentChar - '0') * multiplier));

		}
	}
}
