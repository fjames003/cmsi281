package edu.lmu.cmsi.frankie.projectEuler;


public class Problem5 {
	public static long largestMultiple(int maxDigit) {
		long count = maxDigit;
		int test;
		boolean numFound = true;
		while (numFound) {
			count+=maxDigit;
			test = 10;
			for(int i = maxDigit; i > 10; i--) {
				if(count % i == 0) {
					test++;
				}
			}
			if (test == maxDigit) {
				numFound = false;
			}
		}
		return count;
	}
} 

