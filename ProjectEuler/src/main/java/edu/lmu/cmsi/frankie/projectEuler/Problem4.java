package edu.lmu.cmsi.frankie.projectEuler;


public class Problem4 {
	public static long palindromeProduct() {
		int sum = 0;
		for(int i = 999; i > 900; i--) {
			for (int j = 999; j > 900; j--) {
				if (numberPalindrome(j * i)) {
					sum = i * j;
					System.out.println("[" + i + " * " + j + " = " + j*i + "]");
					return (long) j * i;
				}
			}
		}
		return -1;
	}
	private static boolean numberPalindrome(int num) {
		String newNum = "" + num;
		String result = "";
		for(int i = 0; i < newNum.length(); i++) {
			result += newNum.charAt((newNum.length() - 1) - i);
		}
		return newNum.equals(result);
	}
} 

