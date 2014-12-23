package edu.lmu.cmsi.frankie.projectEuler;

import java.util.ArrayList;

public class Problem7 {
	public static long nthPrime(int index) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		return nthPrime(index, primes);
	}

	private static long nthPrime(int index, ArrayList<Integer> primes) {
		if (primes.size() == index) {
			return primes.get(primes.size() - 1).longValue();
		} else {
			int currentNum = (primes.size() == 1) ? 3 : primes.get(primes.size() - 1).intValue();
			int primesPassed = 0;
			while(primesPassed < primes.size()) {
				currentNum += 2;
				primesPassed = 0;
				for (Integer i : primes) {
					if(currentNum % i.intValue() != 0) {
						primesPassed++;
					}
				}
			}
			primes.add(currentNum);
			return nthPrime(index, primes);
		}
	}
}