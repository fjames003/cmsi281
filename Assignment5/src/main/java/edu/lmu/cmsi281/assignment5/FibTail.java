package edu.lmu.cmsi281.assignment5;
import java.math.BigInteger;
public class FibTail {

	public static BigInteger fibTail(int index) {
		if (index < 1) {
			throw new IllegalArgumentException("Must provide an index greater than 0");
		}
		BigInteger a = new BigInteger("0");
		BigInteger b = new BigInteger("1");

		return fibTail(index, a, b);
	}
	private static BigInteger fibTail(int index, BigInteger a, BigInteger b) {
		if (index == 1) {
			return a;
		} else if (index == 2) {
			return b;
		} else {
			return fibTail(index - 1, b, a.add(b));
		}
	}
}