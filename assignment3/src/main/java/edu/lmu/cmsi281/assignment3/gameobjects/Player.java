package edu.lmu.cmsi281.assignment3.gameobjects;

import edu.lmu.cmsi281.assignment3.core.MovableObject;
import java.util.Random;


public class Player extends MovableObject {
  private char renderedCharacter;

  public Player(int x, int y) {
    super(x, y, 0.5);
    this.renderedCharacter = 'p';
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