package edu.lmu.cmsi281.assignment5;

import static edu.lmu.cmsi281.assignment5.FibTail.fibTail;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {
    @Test
    public void fibOneTest() {
        assertEquals("failure - fib(0) did not equal 0", 0, fibTail(0).longValue());
    }

    @Test
    public void fibTwoTest() {
        assertEquals("failure - fib(1) did not equal 1", 1, fibTail(1).longValue());
    }

    @Test
    public void fibTenTest() {
        assertEquals("failure - fib(10) did not equal 55", 55, fibTail(10).longValue());
    }

    @Test
    public void fibHundredTest() {
        assertEquals("failure - fib(40) did not equal 102334155", 102334155, fibTail(40).longValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void fibLessThanZeroTest() {
        long test = fibTail(-1).longValue();
    }

}