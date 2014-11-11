package edu.lmu.cmsi281.assignment5;
public class StringIntConv {
    public int stringIntConv(String num) {
		if (num.length() == 1) {
			return num.charAt(0) - '0';
		} else {
			return stringIntConv(num, 0);
		}
	}
	private int stringIntConv(String num, int sum) {
		if (num.length() == 1) {
			return sum + (num.charAt(0) - '0');
		} else {
			int multiplier = (int)Math.pow(10, num.length() - 1);
			return stringIntConv(num.substring(1), sum + ((num.charAt(0) - '0') * multiplier));

		}
	}
}
