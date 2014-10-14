package edu.lmu.cmsi281.Assignment2.shapes;

import edu.lmu.cmsi281.Assignment2.Point;
import edu.lmu.cmsi281.Assignment2.Line;

public class Rectangle {

    private Point[] corners;
    private Line[] sides;

    public Rectangle(Point[] points) {
        checkPoints(points);

        this.corners = points;
        createLines(this.corners);
    }

    public Rectangle(Point p, Point p2, Point p3, Point p4) {
        Point[] temp = {p, p2, p3, p4};
        checkPoints(temp);

        this.corners = temp;
        createLines(this.corners);
    }

    private void checkPoints(Point[] points) {
        if (points[0] == null || points[1] == null || points[2] == null || points[3] == null) {
            throw new IllegalArgumentException("Rectangle must contain four points");
        }
        for (int i = 0; i < points.length -1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].isEqualTo(points[j])) {
                    throw new IllegalArgumentException("Rectangles must contain 4 DIFFERENT points");
                }
            }
        }
        if ( ! (points[0].distance(points[1]) == points[2].distance(points[3]) &&
            points[0].distance(points[2]) == points[1].distance(points[3]) &&
            points[0].distance(points[3]) == points[1].distance(points[2])) ) {
            throw new IllegalArgumentException("Rectangles must contain two sets of parallel lines");
        }
    }

    private void createLines(Point[] points) {
        // Find Diagonal distance of Rectangle
        double maxLength = points[0].distance(points[1]);
        maxLength = (maxLength > points[0].distance(points[2])) ? maxLength : points[0].distance(points[2]);
        maxLength = (maxLength > points[0].distance(points[3])) ? maxLength : points[0].distance(points[3]);

        Line one, two, three, four;

        if (points[0].distance(points[2]) == maxLength) {
            one = new Line(points[0], points[1]);
            two = new Line(points[0], points[3]);
            three = new Line(points[1], points[2]);
            four = new Line(points[2], points[3]);
        } else if (points[0].distance(points[3]) == maxLength) {
            one = new Line(points[0], points[1]);
            two = new Line(points[0], points[2]);
            three = new Line(points[1], points[3]);
            four = new Line(points[2], points[3]);
        } else { // distance from point 0 to point 1 is the diagonal (therefore not a line)
            one = new Line(points[0], points[2]);
            two = new Line(points[0], points[3]);
            three = new Line(points[1], points[2]);
            four = new Line(points[1], points[3]);
        }

        // Set up so that Line[0] and Line[1] are adjacent sides (can be multiplied for area)
        Line[] sides = {one, two, three, four};

        this.sides = sides;
    }

    // Multiply adjacent sides
    public double area() {
        return this.sides[0].length() * this.sides[1].length();
    }

    public double perimeter() {
        double result = 0;
        for (int i = 0; i < this.sides.length; i++) {
            result += this.sides[i].length();
        }
        return result;
    }

    public boolean containsPoint(Point p) {
        double minX = 0;
        double minY = 0;
        double maxX = 0;
        double maxY = 0;
        for (int i = 0; i < this.corners.length; i++) {
            minX = (minX > this.corners[i].getX()) ? this.corners[i].getX() : minX;
            maxX = (maxX < this.corners[i].getX()) ? this.corners[i].getX() : maxX;
            minY = (minY > this.corners[i].getY()) ? this.corners[i].getY() : minY;
            maxY = (maxY < this.corners[i].getY()) ? this.corners[i].getY() : maxY;
        }

        return (p.getX() >= minX && p.getX() <= maxX) && (p.getY() >= minY && p.getY() <= maxY);
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
        return this;
    }

    public Point[] getPoints() {
        return this.corners;
    }

    public Line[] getSides() {
        return this.sides;
    }

    public boolean isEqualTo(Rectangle r) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.corners[i].isEqualTo(r.corners[j])) {
                    count++;
                }
            }
        }
        return count == 4;
    }
}