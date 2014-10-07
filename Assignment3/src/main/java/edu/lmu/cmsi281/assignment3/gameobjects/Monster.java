package edu.lmu.cmsi281.assignment3.gameobjects;

import edu.lmu.cmsi281.assignment3.core.MovableObject;
import java.util.Random;

public class Monster extends MovableObject {

  public Monster(int x, int y, char c) {
    super(x, y, 0.5);
    if (c == 'z' || c == 'x') {
      this.setRenderedCharacter(c);
    } else if (c == 'a' || c == 's') {
      this.setHitPercent(0.6);
      this.setRenderedCharacter(c);
    } else {
      throw new IllegalArgumentException("Monsters are of types z,x,a,s only");
    }
  }

  // Only worried about colliding with Players. 
  // Will avoid other Monsters and Bosses (Everyone vs. the player)
  @Override 
  protected void newHit(MovableObject m) {
    if (m instanceof Player) {
      Random rand = new Random();
      if (rand.nextDouble() <= m.getHitPercent()) {
        this.newHit();
      } 
    }
  }
}