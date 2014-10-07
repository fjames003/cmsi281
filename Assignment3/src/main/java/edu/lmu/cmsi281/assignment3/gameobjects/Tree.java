package edu.lmu.cmsi281.assignment3.gameobjects;

import edu.lmu.cmsi281.assignment3.core.GameObject;

public class Tree extends GameObject{
    
  public Tree(int x, int y) {
    super(x, y);
    this.setRenderedCharacter('t');
  }
}