package edu.lmu.cmsi281.Assignment2;

import edu.lmu.cmsi281.Assignment2.Point;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

    @Test
    public void pointStringTest() {
        Point p = new Point(0,0);
        assertEquals("failure - Did not print correct string", "Point: (0.0, 0.0)", p.toString());
    }

    @Test
    public void pointGetXTest() {
        Point p = new Point(100,101);
        assertEquals(100.0, p.getX(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pointNegativeX() {
        Point p = new Point(-1,0);
    }

    @Test
    public void pointGetYTest() {
        Point p = new Point(100,101);
        assertEquals(101.0, p.getY(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pointNegativeY() {
        Point p = new Point(0,-1);
    }

    @Test
    public void pointDistanceTest() {
        Point p = new Point(0,0);
        Point p1 = new Point(3,4);
        assertEquals(5.0, p.distance(p1), 0.0);
    }
    
    //Switch which point has distance() called
    @Test
    public void pointDistanceReversedTest() {
        Point p = new Point(0,0);
        Point p1 = new Point(3,4);
        assertEquals(5.0, p1.distance(p), 0.0);
    }

    @Test
    public void pointIsNotEqualToTest() {
        Point p = new Point(0,0);
        Point p1 = new Point(5,5);
        assertEquals("failure - thought points were equal", false, p.isEqualTo(p1));
    }

    //Reverse calling of Test above
    @Test
    public void pointIsNotEqualToReversedTest() {
        Point p = new Point(0,0);
        Point p1 = new Point(5,5);
        assertEquals("failure - thought points were equal", false, p1.isEqualTo(p));
    }

    @Test
    public void pointIsEqualToTest() {
        Point p = new Point(37.4567,89.0987);
        Point p1 = new Point(37.4567,89.0987);
        assertEquals("failure - should've thought points were equal", true, p.isEqualTo(p1));
    }

    //Reverse calling of Test above
    @Test
    public void pointIsEqualToReversedTest() {
        Point p = new Point(37.4567,89.0987);
        Point p1 = new Point(37.4567,89.0987);
        assertEquals("failure - should've thought points were equal", true, p1.isEqualTo(p));
    }
}