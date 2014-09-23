package edu.lmu.cmsi281.Assignment2.shapes;

import edu.lmu.cmsi281.Assignment2.Point;
import edu.lmu.cmsi281.Assignment2.Line;
import edu.lmu.cmsi281.Assignment2.shapes.Circle;
import edu.lmu.cmsi281.Assignment2.shapes.Rectangle;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class CircleTest {
    private Point five;
    private Point zero;
    private Point isNull;

    @Before
    public void initialize() {
        this.zero = new Point(0,0);
        this.five = new Point(5,5);
        this.isNull = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void withNullCenter() {
        Circle c = new Circle(this.isNull, 5.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void radiusTooLongTest() {
        Circle c = new Circle(this.zero, 5.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeRadius() {
        Circle c = new Circle(this.five, -2.0);
    }

    @Test
    public void getRadiusTest() {
        Circle c = new Circle(this.five, 2.5);
        assertEquals(2.5, c.getRadius(), 0.0);
    }

    @Test
    public void getDiameterTest() {
        Circle c = new Circle(this.five, 2.5);
        assertEquals(5.0, c.getDiameter(), 0.0);
    }

    @Test
    public void getAreaTest() {
        Circle c = new Circle(this.five, 1.0);
        assertEquals(Math.PI, c.getArea(), 0.0);
    }

    @Test
    public void getCircumference() {
        Circle c = new Circle(this.five, 0.5);
        assertEquals(Math.PI, c.getCircumference(), 0.0);
    }

    @Test 
    public void containsPointTest() {
        Circle c = new Circle(this.five, 5.0);
        Point p = new Point(2,3);
        assertEquals("failure - did not think point was inside circle", true, c.containsPoint(p));
    }

    @Test 
    public void doesntContainsPointTest() {
        Circle c = new Circle(this.five, 5.0);
        assertEquals("failure - did not think point was inside circle", true, c.containsPoint(this.zero));
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotTranslateTest() {
        Circle c = new Circle(this.five, 5.0);
        c.translate(-1, -1);
    }

    // See if circle contains its old center after translating far away
    @Test
    public void translateTest() {
        Circle c = new Circle(this.five, 5.0);
        c.translate(100, 100);
        assertEquals("failure - contains point from original circle after translate", false, c.containsPoint(this.five));
    }

    
    @Test
    public void getBoundsTest() {
        Circle c = new Circle(this.five, 5.0);
        Point upper = new Point(0,10);
        Point upperR = new Point(10,10);
        Point lowerR = new Point(10,0);
        Rectangle test = new Rectangle(this.zero, upper, upperR, lowerR);
     
        assertEquals("failure - did not match rectangle", true, test.isEqualTo(c.getRectangle()));
    } 
}
   