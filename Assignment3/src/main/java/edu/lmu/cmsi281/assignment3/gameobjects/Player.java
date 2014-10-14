package edu.lmu.cmsi281.assignment3.gameobjects;

import edu.lmu.cmsi281.assignment3.core.MovableObject;
import java.util.Random;


public class Player extends MovableObject {
  private char renderedCharacter;

  public Player(int x, int y) {
    super(x, y, 0.5);
    this.setRenderedCharacter('p');
  }

  // Only worried about colliding with NON Players
  // Will not collide with other Players (Players vs. Everyone)
  @Override
  protected void newHit(MovableObject m) {
    //if (!(m instanceof Player)) {
      Random rand = new Random();
      if (rand.nextDouble() <= m.getHitPercent()) {
        this.newHit();
      }
    //}
  }
}