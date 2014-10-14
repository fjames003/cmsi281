package edu.lmu.cmsi281.Assignment2.shapes;

import edu.lmu.cmsi281.Assignment2.Point;
import edu.lmu.cmsi281.Assignment2.Line;
import edu.lmu.cmsi281.Assignment2.shapes.Rectangle;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class RectangleTest {
    private Point one;
    private Point two;
    private Point three;
    private Point four;
    private Point five;
    private Point six;
    private Point seven;
    private Point[] good;
    private Point[] bad;
    private Point[] duplicate;
    private Point[] withNull;

    @Before
    public void initialize() {
        this.one = new Point(0,0);
        this.two = new Point(0,6);
        this.three = new Point(5,0);
        this.four = new Point(5,6);
        this.five = new Point(6,5);
        this.six = new Point(2,3);
        this.seven = null;

        this.good = new Point[] {this.one, this.two, this.three, this.four};
        this.bad = new Point[] {this.one, this.two, this.three, this.five};
        this.duplicate = new Point[] {this.two, this.two, this.three, this.seven};
        this.withNull = new Point[] {this.two, this.four, this.six, this.seven};

    }

    // Tests for Rectangle Constructor with individual points
    @Test(expected = IllegalArgumentException.class)
    public void samePointTest() {
        Rectangle r = new Rectangle(this.one, this.one, this.two, this.three);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notParallelTest() {
        Rectangle r = new Rectangle(this.one, this.two, this.three, this.five);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullPointTest() {
        Rectangle r = new Rectangle(this.one, this.two, this.three, this.seven);
    }

    @Test
    public void goodRectangleTest() {
        Rectangle r = new Rectangle(this.one, this.two, this.three, this.four);
    }

    // Tests for Rectangle Constructor with Point array
    @Test(expected = IllegalArgumentException.class)
    public void samePointArrayTest() {
        Rectangle r = new Rectangle(this.duplicate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notParallelArrayTest() {
        Rectangle r = new Rectangle(this.bad);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullPointArrayTest() {
        Rectangle r = new Rectangle(this.withNull);
    }

    @Test
    public void goodRectangleArrayTest() {
        Rectangle r = new Rectangle(this.good);
    }

    @Test
    public void areaTest() {
        Rectangle r = new Rectangle(this.good);
        assertEquals(30.0, r.area(), 0.0);
    }

    @Test
    public void perimeterTest() {
        Rectangle r = new Rectangle(this.good);
        assertEquals(22.0, r.perimeter(), 0.0);
    }

    @Test 
    public void containsPointTest() {
        Rectangle r = new Rectangle(this.good);
        assertEquals("failure - point does fall inside rectangle", true, r.containsPoint(this.six));
    }

    @Test
    public void doesntContainsPointTest() {
        Rectangle r = new Rectangle(this.good);
        assertEquals("failure - point does NOT fall inside rectangle", false, r.containsPoint(this.five));
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotTranslateTest() {
        Rectangle r = new Rectangle(this.good);
        r.translate(-2,-2);
    }

    @Test
    public void translateTest() {
        Rectangle r = new Rectangle(this.good);
        r.translate(10, 10);
        assertEquals("failure - still contains point it shouldn't", false, r.containsPoint(this.one));
    }

    @Test
    public void boundsTest() {
        Rectangle r = new Rectangle(this.good);
        assertEquals(22.0, r.getBoundingRectangle().perimeter(), 0.0);
        assertEquals(30.0, r.getBoundingRectangle().area(), 0.0);
    }

    @Test
    public void equalToTest() {
        Rectangle r = new Rectangle(this.good);
        Rectangle r1 = new Rectangle(this.good);
        assertEquals("failure - rectangles did not match", true, r.isEqualTo(r1));
    }

    @Test
    public void boundsTestUsingEqualTo() {
        Rectangle r = new Rectangle(this.good);
        Rectangle r1 = r.getBoundingRectangle();
        assertEquals("failure - did not match rectangles", true, r.isEqualTo(r1));
    }
}