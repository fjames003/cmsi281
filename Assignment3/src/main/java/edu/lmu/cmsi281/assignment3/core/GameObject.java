package edu.lmu.cmsi281.assignment3.core;

import edu.lmu.cmsi281.assignment3.core.Coordinate;

public abstract class GameObject {

    // Defined by having a location on the board  
    // as well as a character that represents it.
    // However each class that extends from this one
    // Must set the rendered character itself. NO DEFAULT CHARACTER.
    private Coordinate location;
    private char renderedCharacter;

    public GameObject(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("GameObjects must be in positive quadrant");
        }
        this.location = new Coordinate(x, y);
    }

    public int getX() {
        return this.location.getX();
    }

    public int getY() {
        return this.location.getY();
    }

    protected void setX(int x) {
        this.location.setX(x);
    }
    protected void setY(int y) {
        this.location.setY(y);
    }

    public char getRenderedCharacter() {
        return this.renderedCharacter;
    }

    // Protected so that only classes also in this package may use.
    protected void setRenderedCharacter(char c) {
        this.renderedCharacter = c;
    } 
  
}