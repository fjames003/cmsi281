package edu.lmu.cmsi281.assignment3.gameobjects;

import edu.lmu.cmsi281.assignment3.core.MovableObject;
import java.util.Random;

public class Monster extends MovableObject {
  private char renderedCharacter;

  public Monster(int x, int y, char c) {
    super(x, y, 0.5);
    if (c == 'z' || c == 'x') {
      this.renderedCharacter = c;
    } else if (c == 'a' || c == 's') {
      this.setHitPercent(0.6);
      this.renderedCharacter = c;
    } else {
      throw new IllegalArgumentException("Monsters are of types z,x,a,s only");
    }
  }

  @Override
  public char getRenderedCharacter() {
    return this.renderedCharacter;
  }

  @Override 
  protected void newHit(double percent) {
    Random rand = new Random();
    if (rand.nextDouble() <= percent) {
      this.newHit();
    } 
  }
}