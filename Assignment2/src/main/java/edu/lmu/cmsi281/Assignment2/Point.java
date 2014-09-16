package edu.lmu.cmsi281.Assignment2;

public class Point {
	private double xValue;
	private double yValue;

	public Point(double x, double y) {
        if ( !(x >= 0) || !(y >= 0) ) {
            throw new IllegalArgumentException("Both X and Y values must be positive.");
        }

		this.xValue = x;
		this.yValue = y;
	}
    public String toString() {
        String result = "Point: (" + this.xValue + ", " + this.yValue + ")";
        return result;
    }
    public double getX() {
        return this.xValue;
    }
    public double getY() {
        return this.yValue;
    }
    public double distance(Point p) {
        double result = Math.sqrt(Math.pow( p.getX() - this.getX(), 2) + Math.pow( p.getY() - this.getY(), 2));
        return result;
    }
    public boolean isEqualTo(Point p) {
        return this.getX() == p.getX() && this.getY() == p.getY();
    }
}