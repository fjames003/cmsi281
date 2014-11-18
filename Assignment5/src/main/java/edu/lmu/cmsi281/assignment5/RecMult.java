package edu.lmu.cmsi281.assignment5;
public class RecMult {
    public static int recMult(int a, int b) {
    	if (a < 0 || b < 0) {
    		throw new IllegalArgumentException("Can only handle negative integers at this time");
    	} else {
            int myA = Math.min(a,b);
            int myB = Math.max(a,b);
            if (myA == 0) {
		      return 0;
            } else if (myA == 1) {
			  return myB;
            } else {
			  return recMult(myA, myB, 0);
		  }
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