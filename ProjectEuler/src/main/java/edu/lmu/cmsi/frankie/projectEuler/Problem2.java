package edu.lmu.cmsi.frankie.projectEuler;

public class Problem2 {
	public static long evenFibSum(long index) {
		long sum = 0,
		counterA = 1,
		counterB = 2,
		counterTemp;
		while(counterB < index) {
			if (counterB % 2 == 0) {
				sum += counterB;
			}
			counterTemp = counterB;
			counterB += counterA;
			counterA = counterTemp;
		}
		return sum;
	}
}