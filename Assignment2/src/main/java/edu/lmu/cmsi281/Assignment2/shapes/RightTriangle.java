package edu.lmu.cmsi281.Assignment2.shapes;

import edu.lmu.cmsi281.Assignment2.Point;
import edu.lmu.cmsi281.Assignment2.Line;
import edu.lmu.cmsi281.Assignment2.shapes.Rectangle;

public class RightTriangle {
    private Point[] corners;
    private Line[] sides;

    public RightTriangle(Point p1, Point p2, Point p3) {
        Point[] temp = {p1, p2, p3};

        checkPoints(temp);
        checkRight(temp);

        this.corners = temp;
        createLines(this.corners);
    }

    public RightTriangle(Point[] points) {
        checkPoints(points);
        checkRight(points);

        this.corners = points;
        createLines(this.corners);
    }

    private void checkPoints(Point[] points) {
        if (points[0] == null || points[1] == null || points[2] == null) {
            throw new IllegalArgumentException("RightTrangles must contain four points");
        }
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].isEqualTo(points[j])) {
                    throw new IllegalArgumentException("RightTriangles must contain 4 DIFFERENT points");
                }
            }
        }
    }

    private void checkRight(Point[] points) {
        double side1 = points[0].distance(points[1]);
        double side2 = points[1].distance(points[2]);
        double side3 = points[2].distance(points[0]);
        double maxLength = maxSideLength(points);

        if (side1 == maxLength) {
            if ( Math.round((Math.pow(side2,2) + Math.pow(side3,2))) != Math.round((Math.pow(side1,2))) ) {
                throw new IllegalArgumentException((Math.pow(side2,2) + Math.pow(side3,2)) + "and " + (Math.pow(side1,2)) + " and " + maxLength);
            }
        } else if (side2 == maxLength) {
            if ( Math.round((Math.pow(side1,2) + Math.pow(side3,2))) != Math.round((Math.pow(side2,2))) ) {
                throw new IllegalArgumentException((Math.pow(side1,2) + Math.pow(side3,2)) + "and " + (Math.pow(side2,2)) + " and " + maxLength);
            }
        } else {
            if ( Math.round((Math.pow(side1,2) + Math.pow(side2,2))) != Math.round((Math.pow(side3,2))) ) {
                throw new IllegalArgumentException((Math.pow(side1,2) + Math.pow(side2,2)) + "and " + (Math.pow(side3,2)) + " and " + maxLength);
            }
        }
    }

    private void createLines(Point[] points) {
        Line one = new Line(points[0], points[1]);
        Line two = new Line(points[1], points[2]);
        Line three = new Line(points[2], points[0]);

        Line[] result = {one, two, three};
        this.sides = result;
    }

    private double maxSideLength(Point[] points) {
        double side1 = points[0].distance(points[1]);
        double side2 = points[1].distance(points[2]);
        double side3 = points[2].distance(points[0]);
        double maxLength = side1;
        maxLength = (maxLength > side2) ? maxLength : side2;
        maxLength = (maxLength > side3) ? maxLength : side3;

        return maxLength;
    }

    public double perimeter() {
        return this.sides[0].length() + this.sides[1].length() + this.sides[2].length();
    }

    public double area() {
        double maxLength = maxSideLength(this.corners);

        if (this.sides[0].length() == maxLength) {
            return this.sides[1].length() * this.sides[2].length() * 0.5;
        } else if (this.sides[1].length() == maxLength) {
            return this.sides[0].length() * this.sides[2].length() * 0.5;
        } else {
            return this.sides[0].length() * this.sides[1].length() * 0.5;
        }
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

    /* Can been found using crossproducts however
     * I need more time to figure out how.

    public boolean containsPoint(Point p) {

    }

    public Rectangle getBoundingRectangle() {

    } */
}