package edu.lmu.cmsi281.assignment3.core;

import edu.lmu.cmsi281.assignment3.core.Coordinate;

public abstract class GameObject {

    private Coordinate location;

    public GameObject(int x, int y) {
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

    public abstract char getRenderedCharacter(); 
  
}