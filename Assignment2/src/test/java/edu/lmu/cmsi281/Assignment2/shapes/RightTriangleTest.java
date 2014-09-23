package edu.lmu.cmsi281.Assignment2.shapes;

import edu.lmu.cmsi281.Assignment2.Point;
import edu.lmu.cmsi281.Assignment2.Line;
import edu.lmu.cmsi281.Assignment2.shapes.Rectangle;
import edu.lmu.cmsi281.Assignment2.shapes.RightTriangle;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class RightTriangleTest {

    private Point one;
    private Point two;
    private Point three;
    private Point four;
    private Point five;
    private Point six;
    private Point seven;
    private Point[] good;

    @Before
    public void initialize() {
        this.one = new Point(0,0);
        this.two = new Point(0,6);
        this.three = new Point(5,0);
        this.four = new Point(1,6);
        this.five = new Point(6,1);
        this.six = null;
        this.good = new Point[] {this.one, this.two, this.three};
    }

    @Test
    public void goodTriangle() {
        RightTriangle t = new RightTriangle(this.one, this.two, this.three);
    }

    @Test
    public void goodArrayTest() {
        RightTriangle t = new RightTriangle(this.good);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isNullTest() {
        RightTriangle t = new RightTriangle(this.one, this.two, this.six);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isNotRightTest() {
        RightTriangle t = new RightTriangle(this.one, this.four, this.five);
    }

    @Test(expected = IllegalArgumentException.class)
    public void samePointTest() {
        RightTriangle t = new RightTriangle(this.one, this.one, this.three);
    }

    @Test
    public void areaTest() {
        RightTriangle t = new RightTriangle(this.one, this.two, this.three);
        assertEquals(15.0, t.area(), 0.0);
    }

    @Test
    public void perimeterTest() {
        RightTriangle t = new RightTriangle(this.one, this.two, this.three);
        assertEquals(Math.sqrt(61) + 5 + 6, t.perimeter(), 0.0);
    }

    /* Cannot test until contains point is working.
    @Test
    public void translateTest() {
        RightTriangle t = new RightTriangle(this.one, this.two, this.three);
        t.translate(10,10);
        assertEquals("failure - still contains point it shouldnt", false, t.)
    }

    @Test
    public void containPointTest() {
        RightTriangle t = new RightTriangle(this.one, this.two, this.three);
        assertEquals("failure - doenst contain point", true, t.containsPoint(this.one));
    }

    @Test
    public void doesntContainPointTest() {
        RightTriangle t = new RightTriangle(this.one, this.two, this.three);
        assertEquals("failure - doenst contain point", true, t.containsPoint(this.five));
    } */
}

