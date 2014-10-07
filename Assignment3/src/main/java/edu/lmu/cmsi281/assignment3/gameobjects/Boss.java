package edu.lmu.cmsi281.assignment3.gameobjects;

import edu.lmu.cmsi281.assignment3.core.MovableObject;
import java.util.Random;

public class Boss extends MovableObject {

  public Boss(int x, int y, char c) {
    super(x, y, 0.7);
    if (c == 'o' || c == 'k') {
      this.setRenderedCharacter(c);
    } else {
      throw new IllegalArgumentException("Bosses are of types o and k only");
    }
  }

  //Being a Boss automatically lowers the colliders hit percent by 20%
  //Only worried about Players not other Bosses or Monsters (Everyone vs. the Player)
  @Override 
  protected void newHit(MovableObject m) {
    if (m instanceof Player) {
      Random rand = new Random();
      if (rand.nextDouble() <= (m.getHitPercent() - 0.2)) {
        this.newHit();
      } 
    }
  }
}