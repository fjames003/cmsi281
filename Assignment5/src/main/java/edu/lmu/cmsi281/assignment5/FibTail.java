package edu.lmu.cmsi281.assignment5;
import java.math.BigInteger;
public class FibTail {

	public static BigInteger fibTail(int index) {
		if (index < 0) {
			throw new IllegalArgumentException("Must provide an index 0 or greater");
		}
		BigInteger a = new BigInteger("0");
		BigInteger b = new BigInteger("1");

		return fibTail(index, a, b);
	}
	private static BigInteger fibTail(int index, BigInteger a, BigInteger b) {
		if (index == 0) {
			return a;
		} else if (index == 1) {
			return b;
		} else {
			return fibTail(index - 1, b, a.add(b));
		}
	}
}