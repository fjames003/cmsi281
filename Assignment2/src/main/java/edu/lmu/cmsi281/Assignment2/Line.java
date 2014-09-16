package edu.lmu.cmsi281.Assignment2;

public class Line {

    private Point endOne;
    private Point endTwo;

    public Line(Point one, Point two) {

        if ( one.isEqualTo(two) ) {
            throw new IllegalArgumentException("Lines must contain two DIFFERENT points");
        } 
              
        this.endOne = one;
        this.endTwo = two;

    }

    public double length() {
        return this.endOne.distance(this.endTwo);
    }

    public boolean isEqualTo(Line ln) {
        return (this.endOne.isEqualTo(ln.endOne) || this.endOne.isEqualTo(ln.endTwo)) && 
               (this.endTwo.isEqualTo(ln.endTwo) || this.endTwo.isEqualTo(ln.endOne));
    }
    public Point midPoint() {
        double midX = Math.abs((this.endOne.getX() - this.endTwo.getX()) / 2);
        double midY = Math.abs((this.endOne.getY() - this.endTwo.getY()) / 2);
        return new Point(midX, midY);
    }

    // (Fx - Ex)(Py - Fy) - (Fy - Ey)(Px - Fx)
    // (Fx - Ex)(Qy - Fy) - (Fy - Ey)(Qx - Fx)
    public boolean intersects(Line ln) {
        double crossProd1 = (this.endOne.getX() - this.endTwo.getX()) * (ln.endOne.getY() - this.endOne.getY()) - 
                            (this.endOne.getY() - this.endTwo.getY()) * (ln.endOne.getX() - this.endOne.getX());
        double crossProd2 = (this.endOne.getX() - this.endTwo.getX()) * (ln.endTwo.getY() - this.endOne.getY()) -
                            (this.endOne.getY() - this.endTwo.getY()) * (ln.endTwo.getX() - this.endOne.getX());

        // if both cross products are negative or both positive,  
        // both endpoints of 'ln' are on same sides of line 'this' i.e can't intersect
        if ( (crossProd1 > 0 && crossProd2 > 0) || (crossProd1 < 0 && crossProd2 < 0) ) {

            return false;
 
        } else {
            // if gets here, endpoints of 'ln' are on opposite sides of 'this', 
            // Now we check if endpoints of 'this' are on oppposite sides of 'ln'
            double crossProd3 = (ln.endOne.getX() - ln.endTwo.getX()) * (this.endOne.getY() - ln.endOne.getY()) -
                                (ln.endOne.getY() - ln.endTwo.getY()) * (this.endOne.getX() - ln.endOne.getX()); 
            double crossProd4 = (ln.endOne.getX() - ln.endTwo.getX()) * (this.endTwo.getY() - ln.endOne.getY()) -
                                (ln.endOne.getY() - ln.endTwo.getY()) * (this.endTwo.getX() - ln.endOne.getX()); 

            // if both cross products are positive or negative,
            // endpoints of 'this' are on same side of 'ln' i.e still can't intersect
            return !(crossProd3 > 0 && crossProd4 > 0) || !(crossProd3 < 0 && crossProd4 < 0);

        }
    }
}




