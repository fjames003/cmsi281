package edu.lmu.cmsi281.assignment3.gameobjects;

import edu.lmu.cmsi281.assignment3.core.GameObject;

public class Rock extends GameObject{
    
  public Rock(int x, int y) {
    super(x, y);
    this.setRenderedCharacter('r');
  }
}