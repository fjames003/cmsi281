package edu.lmu.cmsi281.assignment4;

import edu.lmu.cmsi281.assignment4.ArrayNmostRecent;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayNmostRecentTest {

    ArrayNmostRecent<Integer> list;

    private Integer one   = 1, 
                    two   = 2, 
                    three = 3, 
                    four  = 4, 
                    five  = 5, 
                    six   = 6;


    @Before
    public void intialize() {
        this.list = new ArrayNmostRecent<Integer>(4);
    }

    @Test
    public void testOldestLessN() {
        this.list.add(one);
        this.list.add(two);
        this.list.add(three);
        assertEquals(this.list.getOldest(), this.one);
    }

    @Test
    public void testNewestLessN() {
        this.list.add(one);
        this.list.add(two);
        this.list.add(three);
        assertEquals(this.list.getRecent(), this.three);
    }

    @Test
    public void testOldestMoreN() {
        this.list.add(one);
        this.list.add(two);
        this.list.add(three);
        this.list.add(four);
        this.list.add(five);
        this.list.add(six);
        assertEquals(this.list.getOldest(), this.three);
    }

    @Test
    public void testNewestMoreN() {
        this.list.add(one);
        this.list.add(two);
        this.list.add(three);
        this.list.add(four);
        this.list.add(five);
        this.list.add(six);
        assertEquals(this.list.getRecent(), this.six);
    }

    @Test
    public void testSizeLessN() {
        this.list.add(one);
        this.list.add(two);
        assertEquals(this.list.getSize(), 2);
    }

    @Test
    public void testSizeMoreN() {
        this.list.add(one);
        this.list.add(two);
        this.list.add(three);
        this.list.add(four);
        this.list.add(five);
        this.list.add(six);
        assertEquals(this.list.getSize(), 4);
    }

    @Test
    public void testSizePostReset() {
        this.list.add(one);
        this.list.add(two);
        this.list.add(three);
        this.list.add(four);
        this.list.reset();
        assertEquals(this.list.getSize(), 0);
    }

    //Tests both the iterator as well as the order recieved.
    @Test
    public void testIterator() {
        this.list.add(one);
        this.list.add(two);
        this.list.add(three);
        this.list.add(four);
        Integer[] nums = new Integer[] {this.one, this.two, this.three, this.four};
        int onNum = 0; 
        boolean b;
        for(Integer i: this.list) {
            b = (i == nums[onNum]);
            onNum++;
            assertTrue(b);
        }  
    } 

    @Test(expected = IllegalArgumentException.class)
    public void testNullAdd() {
        this.list.add(null);
    }

    @Test(expected = IllegalStateException.class)
    public void testEmptyGetOldest() {
        this.list.getOldest();
    }

    @Test(expected = IllegalStateException.class)
    public void testEmptyGetRecent() {
        this.list.getRecent();
    }
}