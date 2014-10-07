package edu.lmu.cmsi281.assignment3;

import java.util.Scanner;

import edu.lmu.cmsi281.assignment3.engine.GameEngine;

public class App {

  private Scanner keyboard = null;
  private GameEngine engine;

  public App() {
    System.out.println("\nWelcome to Frankie's Game" + "\n=========================");
    System.out.println("How large of a game board? (15-100)");
    this.keyboard = new Scanner(System.in);
    int size = this.getSize();
    this.engine = new GameEngine(size);

    System.out.println("=========================" + 
      "\nCommands are:" +
      "\n[N]ext frame," + 
      "\n[Q]uit," + 
      "\n[D]isplacement Randomization," + 
      "\n[A]dvance given number of frames");

    
    
  }

  /*
   Returns the lower case String of the keyboard input
   */
  private String getInput() {
    return this.keyboard.next().toLowerCase();
  }

  private int getSize() {
    try {
      int size = this.keyboard.nextInt();
      if (size > 100 || size < 15) {
        System.out.println("Input recieved was not a valid number - Default of 15 used");
        return 15;
      } else {
        return size;
      }
    } catch (Exception e) {
      System.out.println("Input recieved was not a valid number - Default of 15 used");
      return 15;
    }
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
