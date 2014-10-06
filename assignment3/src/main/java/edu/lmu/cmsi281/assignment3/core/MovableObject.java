package edu.lmu.cmsi281.assignment3.core;

import edu.lmu.cmsi281.assignment3.core.Displacement;
import edu.lmu.cmsi281.assignment3.core.GameObject;
import edu.lmu.cmsi281.assignment3.gameobjects.Wall;
import edu.lmu.cmsi281.assignment3.gameobjects.Rock;
import edu.lmu.cmsi281.assignment3.gameobjects.Tree;

import java.util.Random;



public abstract class MovableObject extends GameObject {

    private Displacement displacement;
    private int hits;
    private double hitPercentage;

    public MovableObject(int x, int y, double p) {
        super(x, y);
        this.displacementRandomizer();
        if ( p >= 1.0 || p <= 0.0 ) {
            throw new IllegalArgumentException("Movable pieces must contain a hit percentage between 0 and 1");
        }
        this.hitPercentage = p;
    }

    // Made so that if Moving object runs into a Wall the object will
    // Immedietly bounce back away from wall to original spot appearing "stunned"
    public void update(int size) {
        super.setX(super.getX() + this.displacement.getXDisplacement());
        super.setY(super.getY() + this.displacement.getYDisplacement());
        
        if (super.getX() <= 0 || super.getX() >= size - 1 || super.getY() <= 0 || super.getY() >= size - 1) {
            this.displacement.invert();
            this.update(size);
        } 
    }

    public void checkCollision(GameObject g) {
        if (this.getX() == g.getX() && this.getY() == g.getY()) {
            this.displacement.invert();

            if ( !(g instanceof MovableObject) && !(g instanceof Wall) ) {
                this.newHit();
            } else if (g instanceof MovableObject) {
                MovableObject test = (MovableObject)g;
                this.newHit(test.getHitPercent());
                System.out.println("Collision between: " + this.getRenderedCharacter() + " and " + test.getRenderedCharacter());
            }
        }
    }

    protected void newHit() {
        this.hits++;
    }

    protected void setHitPercent(double p) {
        if (p <= 0.0 || p >= 1.0) {
            throw new IllegalArgumentException("Movable pieces must contain a hit percentage between 0 and 1");
        }
        this.hitPercentage = p;
    }

    public String printHits() {
        String result = Character.toUpperCase(this.getRenderedCharacter()) + ": " + this.hits;
        return result;
    }

    public double getHitPercent() {
        return this.hitPercentage;
    }

    public void displacementRandomizer() {
        Random randomGenerator = new Random();
        this.displacement = new Displacement(randomGenerator.nextInt(2) - 1, randomGenerator.nextInt(2) - 1);
        while (this.displacement.getXDisplacement() == 0 && this.displacement.getYDisplacement() == 0) {
            this.displacement = new Displacement(randomGenerator.nextInt(2) - 1, randomGenerator.nextInt(2) - 1);
        }
    }

    public int getHits() {
        return this.hits;
    }

    protected abstract void newHit(double percent);
}