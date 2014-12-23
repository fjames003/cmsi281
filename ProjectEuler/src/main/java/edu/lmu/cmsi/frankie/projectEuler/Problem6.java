package edu.lmu.cmsi.frankie.projectEuler;


public class Problem6 {
	public static long sumSquareDiff(int maxDigit) {
		int sum = 0, squareSum = 0;

		for ( int i = 1; i <= maxDigit; i++) {
			squareSum += Math.pow(i, 2);
			sum += i;
		}
		return (long)Math.pow(sum, 2) - squareSum;
	}
} 

