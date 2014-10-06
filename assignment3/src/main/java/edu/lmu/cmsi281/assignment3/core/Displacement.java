package edu.lmu.cmsi281.assignment3.core;

public class Displacement {

  private int dX;
  private int dY;

  public Displacement(int dX, int dY) {
    this.dX = dX;
    this.dY = dY;
  }

  public int getXDisplacement() {
    return this.dX;
  }

  public int getYDisplacement() {
    return this.dY;
  }

  public void invert() {
    this.dX = this.dX * -1;
    this.dY = this.dY * -1;
  }

  public String toString() {
    return "(" + this.dX + ", " + this.dY + ")";
  }
}