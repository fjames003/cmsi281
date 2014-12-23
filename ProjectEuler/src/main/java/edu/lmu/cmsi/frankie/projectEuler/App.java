package edu.lmu.cmsi.frankie.projectEuler;

import edu.lmu.cmsi.frankie.projectEuler.*;
import java.math.BigInteger;

public class App {
	public static void main(String[] args) {
		BigInteger threeTest = new BigInteger("600851475143"); 
		System.out.println("Problem 1: " + Problem1.threeFiveSummer(1000));
		System.out.println("Problem 2: " + Problem2.evenFibSum(4000000));
		System.out.println("Problem 3: " + Problem3.largestPrimeFactor(threeTest));
		System.out.println("Problem 4: " + Problem4.palindromeProduct());
		System.out.println("Problem 5: " + Problem5.largestMultiple(20));
		System.out.println("Problem 6: " + Problem6.sumSquareDiff(10));
		System.out.println("Problem 7: " + Problem7.nthPrime(10001));
	}
}