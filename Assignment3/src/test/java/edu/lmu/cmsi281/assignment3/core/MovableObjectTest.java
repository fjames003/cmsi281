package edu.lmu.cmsi281.assignment3.core;

import edu.lmu.cmsi281.assignment3.core.MovableObject;
import edu.lmu.cmsi281.assignment3.gameobjects.Player;
import edu.lmu.cmsi281.assignment3.gameobjects.Boss;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class MovableObjectTest {
    private MovableObject good;
    private MovableObject good1;

    @Before
    public void intialize() {
        this.good = new Player(1, 1);
        this.good1 = new Boss(1, 1, 'o');
    }
    /*
    @Test(expected = IllegalArgumentException.class)
    public void badHitPercent() {
        MovableObject m = new Player(1, 1);
    } */

    @Test(expected = IllegalArgumentException.class)
    public void badLocation() {
        MovableObject m = new Player(-1, 1);
    }

    @Test
    public void checkCollisionTest() {
        for (int i = 0; i < 10000; i++) {
            this.good1.checkCollision(this.good);
        }
        assertEquals(3000, this.good1.getHits());
    }


}