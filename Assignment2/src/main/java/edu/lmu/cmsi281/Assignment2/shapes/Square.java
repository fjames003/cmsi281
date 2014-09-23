package edu.lmu.cmsi281.Assignment2.shapes;

import edu.lmu.cmsi281.Assignment2.Point;
import edu.lmu.cmsi281.Assignment2.Line;
import edu.lmu.cmsi281.Assignment2.shapes.Rectangle;

public class Square {
    private Point[] corners;
    private Line[] sides;

    public Square(Point p1, Point p2, Point p3, Point p4) {
        Rectangle temp = new Rectangle(p1, p2, p3, p4);
        checkSides(temp.getSides());

        this.corners = temp.getPoints();
        this.sides = temp.getSides();
    }

    public Square(Point[] points) {
        Rectangle temp = new Rectangle(points);
        checkSides(temp.getSides());

        this.corners = temp.getPoints();
        this.sides = temp.getSides();
    }

    public void checkSides(Line[] sides) {
        double sideLength = sides[0].length();
        for(int i = 1; i < sides.length; i++) {
            if (sides[i].length() != sideLength) {
                throw new IllegalArgumentException("Square must contain 4 equal sides");
            }
        }
    }

    public double area() {
        return this.sides[0].length() * this.sides[0].length();
    }

    public double perimeter() {
        return this.sides[0].length() * 4;
    }

    public boolean containsPoint(Point p) {
        Rectangle temp = new Rectangle(this.getPoints());

        return temp.containsPoint(p);
    }

    public void translate(double xDir, double yDir) {
        for (int i = 0; i < this.corners.length; i++) {
            if ((this.corners[i].getX() + xDir) < 0.0 || (this.corners[i].getY() + yDir) < 0.0) {
                throw new IllegalArgumentException("Cannont translate into negative values");
            } else {
                this.corners[i] = new Point(this.corners[i].getX() + xDir, this.corners[i].getY() + yDir);
            }
        }
    }

    public Rectangle getBoundingRectangle() {
        return new Rectangle(this.getPoints());
    }

    public Point[] getPoints() {
        return this.corners;
    }

}