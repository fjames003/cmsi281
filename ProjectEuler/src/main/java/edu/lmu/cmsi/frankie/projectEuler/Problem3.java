package edu.lmu.cmsi.frankie.projectEuler;

import java.math.BigInteger;

public class Problem3 {
	public static BigInteger largestPrimeFactor(BigInteger num) {
		BigInteger two = new BigInteger("2");
		return largestPrimeFactor(num, two);
		
	}
	private static BigInteger largestPrimeFactor(BigInteger num, BigInteger factor) {
		BigInteger one = new BigInteger("1");
		BigInteger zero = new BigInteger("0");
		if (num.equals(one)) {
			return factor;
		} else if(factor.compareTo(num) > -1) {
			return num;
		} else  {
			if (num.remainder(factor).equals(zero)) {
				return largestPrimeFactor(num.divide(factor), factor);
			} else {
				return largestPrimeFactor(num, factor.add(one));
			}
		}
	}
} 