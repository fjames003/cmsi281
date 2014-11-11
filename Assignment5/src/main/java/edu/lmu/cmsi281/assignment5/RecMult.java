package edu.lmu.cmsi281.assignment5;
public class RecMult {
    public static int recMult(int a, int b) {
    	if (a > b) {
    		int temp = b;
    		b = a;
    		a = temp;
    	}
		if (a == 0) {
			return 0;
		} else if (a == 1) {
			return b;
		} else {
			return recMult(a, b, 0);
		}
	}
    private static int recMult(int a, int b, int sum) {
        if (a == 1) {
            return sum + b;
        } else {
            return recMult(a - 1, b, sum + b);
        }
    }
}