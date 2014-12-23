package edu.lmu.cmsi.frankie.projectEuler;

public class Problem1 {
	public static int threeFiveSummer(int index) {
		int sum = 0,
		count = 1;
		while (count < index) {
			if(count % 3 == 0 || count % 5 == 0) {
				sum += count;
			}
			count++;
		}
		return sum;
	}
}