package edu.lmu.cmsi281.assignment3;

import java.util.Scanner;

import edu.lmu.cmsi281.assignment3.engine.GameEngine;

public class App {

  private Scanner keyboard = null;
  private GameEngine engine;

  public App() {
    System.out.println("Welcome to Frankie's Game");
    System.out.println("Commands are: [N]ext frame, [Q]uit, [D]isplacement Randomization, [A]dvance given number of frames");
    this.keyboard = new Scanner(System.in);
    this.engine = new GameEngine(15);
  }

  /*
   Returns the lower case String of the keyboard input
   */
  private String getInput() {
    return this.keyboard.next().toLowerCase();
  }

  private int getNumber() {
    try {
      return this.keyboard.nextInt();
    } catch (Exception e) {
      return 1;
    }
  }

  public static void main(String[] args) {
    App theApp = new App();
    String input = theApp.getInput();

    while (!input.equals("q")) {
      if (input.equals("n")) {
        theApp.engine.update();
      } else if (input.equals("d")) {
        theApp.engine.randomize();
      } else if (input.equals("a")) {
          System.out.println("How many frames would you like to advance? (1-100) - Default: 1 frame");
          int frames = theApp.getNumber();
          //Default to one if not in the range of 1-100
          if (frames > 100 || frames < 1) {
            theApp.engine.update();
            System.out.println("ERROR: Number not between 1 and 100: Default of 1 frame used");
          } else {
            for (int i = 0; i < frames; i++) {
              theApp.engine.update();
            }
          }
      }

      input = theApp.getInput();
    }
  }
}
