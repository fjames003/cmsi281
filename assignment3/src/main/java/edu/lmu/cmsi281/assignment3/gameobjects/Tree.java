package edu.lmu.cmsi281.assignment3.gameobjects;

import edu.lmu.cmsi281.assignment3.core.GameObject;

public class Tree extends GameObject{

  private char renderedCharacter = 't';

  public Tree(int x, int y) {
    super(x, y);
  }

  @Override
  public char getRenderedCharacter() {
    return this.renderedCharacter;
  }
}