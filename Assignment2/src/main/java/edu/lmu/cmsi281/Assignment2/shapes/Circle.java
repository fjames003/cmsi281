package edu.lmu.cmsi281.Assignment2.shapes;

import edu.lmu.cmsi281.Assignment2.Point;
import edu.lmu.cmsi281.Assignment2.Line;
import edu.lmu.cmsi281.Assignment2.shapes.Rectangle;

public class Circle {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        if (center == null || radius <= 0) {
            throw new IllegalArgumentException("Circle must contain a center point and a positive radius");
        } else if ((center.getX() - radius) < 0 || (center.getY() - radius) < 0) {
            throw new IllegalArgumentException("Entire circle must be in positive quadrant");
        }
        this.center = center;
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }
    public double getDiameter() {
        return this.radius * 2;
    }
    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }
    public double getCircumference() {
        return Math.PI * 2 * this.radius;
    }

    // returns true if point is inside cirlce OR on the line of the circle
    // on the line == IN CIRCLE
    public boolean containsPoint(Point p) {
        if (p == null) {
            throw new IllegalArgumentException("Need a point to reference");
        }
        return p.getX() <= (this.center.getX() + this.radius) && p.getY() <= (this.center.getY() + this.radius);
    }
    public void translate(double xDir, double yDir) {
        if (((this.center.getX() + xDir) - radius) < 0 || ((this.center.getY() + yDir) - this.radius) < 0) {
            throw new IllegalArgumentException("Cannot translate circle into negative values");
        } else {
            this.center = new Point((this.center.getX() + xDir), (this.center.getY() + yDir));
        }
    }
   
    public Rectangle getRectangle() {
        Point one = new Point(this.center.getX() + this.radius, this.center.getY() + this.radius);
        Point two = new Point(this.center.getX() - this.radius, this.center.getY() + this.radius);
        Point three = new Point(this.center.getX() - this.radius, this.center.getY() - this.radius);
        Point four = new Point(this.center.getX() + this.radius, this. center.getY() - this.radius);

        return new Rectangle(one, two, three, four);
    }
}