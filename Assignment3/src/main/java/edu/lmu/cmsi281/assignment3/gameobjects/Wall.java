package edu.lmu.cmsi281.assignment3.gameobjects;

import edu.lmu.cmsi281.assignment3.core.GameObject;

public class Wall extends GameObject{

  private char renderedCharacter = 'w';

  public Wall(int x, int y) {
    super(x, y);
  }

  @Override
  public char getRenderedCharacter() {
    return this.renderedCharacter;
  }
}