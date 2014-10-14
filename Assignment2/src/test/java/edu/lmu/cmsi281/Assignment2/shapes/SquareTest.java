package edu.lmu.cmsi281.Assignment2.shapes;

import edu.lmu.cmsi281.Assignment2.Point;
import edu.lmu.cmsi281.Assignment2.Line;
import edu.lmu.cmsi281.Assignment2.shapes.Rectangle;
import edu.lmu.cmsi281.Assignment2.shapes.Square;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class SquareTest {
    private Point one;
    private Point two;
    private Point three;
    private Point four;
    private Point five;
    private Point six;
    private Point seven;

    @Before
    public void initialize() {
        this.one = new Point(0,0);
        this.two = new Point(0,6);
        this.three = new Point(5,0);
        this.four = new Point(5,6);
        this.five = new Point(6,0);
        this.six = new Point(6,6);
        this.seven = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void isntSquareTest() {
        Square s = new Square(this.one, this.two, this.three, this.four);
    }

    @Test
    public void isSquareTest() {
        Square s = new Square(this.one, this.two, this.five, this.six);
    }

    @Test
    public void areaTest() {
        Square s = new Square(this.one, this.two, this.five, this.six);
        assertEquals(36.0, s.area(), 0.0);        
    }

    @Test
    public void perimeterTest() {
        Square s = new Square(this.one, this.two, this.five, this.six);
        assertEquals(24.0, s.perimeter(), 0.0);        
    }

    @Test
    public void containsPointTest() {
        Square s = new Square(this.one, this.two, this.five, this.six);
        assertEquals("failure - did not contain point", true, s.containsPoint(this.one));
    }

    @Test
    public void doesntContainsPointTest() {
        Square s = new Square(this.one, this.two, this.five, this.six);
        Point far = new Point(100, 100);
        assertEquals("failure - did contain point", false, s.containsPoint(far));
    }

    @Test(expected = IllegalArgumentException.class)
    public void cantTranslate() {
        Square s = new Square(this.one, this.two, this.five, this.six);
        s.translate(-10, -10);
    }

    @Test
    public void translateTest() {
        Square s = new Square(this.one, this.two, this.five, this.six);
        s.translate(10,10);
        assertEquals("failure - did contain point", false, s.containsPoint(this.one));
    }

    @Test 
    public void getBounds() {
        Square s = new Square(this.one, this.two, this.five, this.six);
        Rectangle r = new Rectangle(this.one, this.two, this.five, this.six);
        assertEquals("failure - bounds did not match", true, r.isEqualTo(s.getBoundingRectangle()));
    }
}