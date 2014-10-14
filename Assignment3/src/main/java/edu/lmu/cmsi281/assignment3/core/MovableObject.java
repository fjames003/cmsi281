package edu.lmu.cmsi281.assignment3.core;

import edu.lmu.cmsi281.assignment3.core.Displacement;
import edu.lmu.cmsi281.assignment3.core.GameObject;
import edu.lmu.cmsi281.assignment3.gameobjects.Wall;

import java.util.Random;


// Movable Objects need a displacement as well as a way 
// of keeping track of hits and the hit percentage it possesses. 
public abstract class MovableObject extends GameObject {

    private Displacement displacement = new Displacement(0,0);
    private int hits;
    private double hitPercentage;

    // Essentially a GameObject but with the addition of a 
    // Randomized displacement (x and y displacements cannot both
    // be equal to 0). Also takes in the hit percentage as a decimal.
    // Hit percent must be between 0 and 1.
    public MovableObject(int x, int y, double p) {
        super(x, y);
        this.displacementRandomizer();
        if ( p >= 1.0 || p <= 0.0 ) {
            throw new IllegalArgumentException("Movable pieces must contain a hit percentage between 0 and 1");
        }
        this.hitPercentage = p;
    }

    // Made so that if Moving object runs into a Wall the object will
    // Immediately bounce back away from wall to original spot appearing "stunned"
    public void update(int size) {
        super.setX(super.getX() + this.displacement.getXDisplacement());
        super.setY(super.getY() + this.displacement.getYDisplacement());
        
        if (super.getX() <= 0 || super.getX() >= size - 1 || super.getY() <= 0 || super.getY() >= size - 1) {
            this.displacement.invert();
            this.update(size);
        } 
    }

    // Check collision of a GameObject
    // If it has collided into anything flip direction.
    // If the object it's colliding into is not another 
    // Movable object or Wall it should increase a hit.
    // If it is a Movable Object then it must check hit %.
    public void checkCollision(GameObject g) {
        if (this.getX() == g.getX() && this.getY() == g.getY()) {
            this.displacement.invert();

            if ( !(g instanceof MovableObject) && !(g instanceof Wall) ) {
                this.newHit();
            } else if (g instanceof MovableObject) {
                MovableObject test = (MovableObject)g;
                this.newHit(test);

                //Used to test collisions
                //System.out.println("Collision between: " + this.getRenderedCharacter() + " and " + test.getRenderedCharacter());
            }
        }
    }

    protected void newHit() {
        this.hits++;
    }

    // Provide the rendered char as well as total hits on that char
    public String printHits() {
        String result = Character.toUpperCase(this.getRenderedCharacter()) + ": " + this.hits;
        return result;
    }

    public double getHitPercent() {
        return this.hitPercentage;
    }

    protected void setHitPercent(double percent) {
        this.hitPercentage = percent;
    }

    // Randomize the displacement for the moving object
    // In order to be sure object is moving, both x and y
    // displacement must not be 0.
    public void displacementRandomizer() {
        Random randomGenerator = new Random();
        Displacement tester = new Displacement(this.displacement.getXDisplacement(), this.displacement.getYDisplacement());
        this.displacement = new Displacement(randomGenerator.nextInt(2) - 1, randomGenerator.nextInt(2) - 1);
        while (this.displacement.getXDisplacement() == 0 && this.displacement.getYDisplacement() == 0) {
            this.displacement = new Displacement(randomGenerator.nextInt(2) - 1, randomGenerator.nextInt(2) - 1);
        }
        if (this.displacement.getXDisplacement() == tester.getXDisplacement() &&
            this.displacement.getYDisplacement() == tester.getYDisplacement()) {
                this.displacementRandomizer();
        }
    }

    public int getHits() {
        return this.hits;
    }

    // Each Movable Object must define its own way of checking
    // if another moving object has "hit" it based on the hit %
    protected abstract void newHit(MovableObject m);
}