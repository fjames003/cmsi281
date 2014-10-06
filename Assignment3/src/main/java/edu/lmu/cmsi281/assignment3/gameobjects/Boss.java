package edu.lmu.cmsi281.assignment3.gameobjects;

import edu.lmu.cmsi281.assignment3.core.MovableObject;
import java.util.Random;

public class Boss extends MovableObject {
  private char renderedCharacter;

  public Boss(int x, int y, char c) {
    super(x, y, 0.7);
    if (c == 'o' || c == 'k') {
      this.renderedCharacter = c;
    } else {
      throw new IllegalArgumentException("Bosses are of types o and k only");
    }
  }

  @Override
  public char getRenderedCharacter() {
    return this.renderedCharacter;
  }

  //Being a Boss automatically lowers the colliders hit percent by 20%
  @Override 
  protected void newHit(double percent) {
    Random rand = new Random();
    if (rand.nextDouble() <= (percent - 0.2)) {
      this.newHit();
    } 
  }
}