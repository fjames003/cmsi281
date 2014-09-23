package edu.lmu.cmsi281.Assignment2;

import edu.lmu.cmsi281.Assignment2.Point;
import edu.lmu.cmsi281.Assignment2.Line;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class LineTest {

    private Point one;
    private Point two;
    private Point three;
    private Point four;
    private Point isNull;

    @Before
    public void initialize() {
        this.one = new Point(0,0);
        this.two = new Point(0,2);
        this.three = new Point(2,0);
        this.four = new Point(2,2);
        this.isNull = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullPointTest() {
        Line ln = new Line(this.one, this.isNull);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lineSamePointTest() {
        Line ln = new Line(this.one, this.one);
    }

    @Test
    public void lineLengthTest() {
        Line ln = new Line(this.one, this.two);
        assertEquals(2.0, ln.length(), 0.0);
    }

    @Test
    public void line2LengthTest() {
        Line ln = new Line(this.two, this.three);
        assertEquals(Math.sqrt(8), ln.length(), 0.0);
    } 

    @Test
    public void lineIsNotEqualToTest() {
        Line ln = new Line(this.one, this.two);
        Line ln1 = new Line(this.one, this.three);
        assertEquals("failure - thought lines were equal", false, ln.isEqualTo(ln1));
    }

    @Test
    public void lineIsEqualToTest() {
        Line ln = new Line(this.one, this.four);
        Line ln1 = new Line(this.four, this.one);
        assertEquals("failure - did not think lines were equal", true, ln.isEqualTo(ln1));
    }

    @Test
    public void lineMidPointXTest() {
        Line ln = new Line(this.one, this.two);
        assertEquals(0.0, ln.midPoint().getX(), 0.0);
    }

    @Test
    public void lineMidPointYTest() {
        Line ln = new Line(this.one, this.two);
        assertEquals(1.0, ln.midPoint().getY(), 0.0);
    }

    @Test
    public void lineNoIntersect() {
        Line ln = new Line(this.one, this.two);
        Line ln1 = new Line(this.three, this.four);
        assertEquals("failure - thought lines intersect", false, ln.intersects(ln1));
    }

    @Test
    public void lineDoIntersect() {
        Line ln = new Line(this.one, this.two);
        Line ln1 = new Line(this.two, this.four);
        assertEquals("failure - thought lines intersect", true, ln.intersects(ln1));
    }

   //test
}