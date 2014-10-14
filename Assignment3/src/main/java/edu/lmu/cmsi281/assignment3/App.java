package edu.lmu.cmsi281.assignment3;

import java.util.Scanner;

import edu.lmu.cmsi281.assignment3.engine.GameEngine;

public class App {

  private Scanner keyboard = null;
  private GameEngine engine;

  public App() {
    System.out.println("\nWelcome to Frankie's Game");
    
    showCommands();

    System.out.println("How large of a game board? (15-100)");
    this.keyboard = new Scanner(System.in);
    int size = this.getSize();
    this.engine = new GameEngine(size);
    this.engine.update();
    
  }

  /*
   Returns the lower case String of the keyboard input
   */
  private String getInput() {
    return this.keyboard.next().toLowerCase();
  }

  // Size limited to 100 because it almost fits on a full screen 17" screen.
  // Size must be at least 15 to accomodate pieces.
  private int getSize() {
    try {
      int size = this.keyboard.nextInt();
      if (size > 100 || size < 15) {
        System.out.println("Input recieved was not a valid number - Default of 15 used");
        pressEnter();
        this.keyboard.nextLine();
        return 15;
      } else {
        return size;
      }
    } catch (Exception e) {
      System.out.println("ERROR: Input recieved was not a valid number - Default of 15 used");
      pressEnter();
      this.keyboard.nextLine();
      return 15;
    }
  }

  private int getNumber() {
    try {
      return this.keyboard.nextInt();
    } catch (Exception e) {
      System.out.println("ERROR: Number not recieved: Default of 1 frame used");
      pressEnter();
      this.keyboard.nextLine();
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
          // Default to one if not in the range of 1-100
          // Must be under 100 to avoid long wait time when size = 100
          if (frames > 100 || frames < 1) {
            System.out.println("ERROR: Number not between 1 and 100: Default of 1 frame used");
            pressEnter();
            theApp.engine.update();
          } else {
            for (int i = 0; i < frames; i++) {
              theApp.engine.update();
            }
          }
      } else if (input.equals("h")) {
        showCommands();
      }

      input = theApp.getInput();
    }
  }


  // Waits for user to press enter for error
  private static void pressEnter() {
    System.out.println("Press Enter to Continue");
      try {
        System.in.read();
      } catch (Exception e) {}
  }

  private static void showCommands() {
    System.out.println(
      "=========================" + 
      "\nCommands are:" +
      "\n[N]ext frame," + 
      "\n[Q]uit," + 
      "\n[D]isplacement Randomization," + 
      "\n[A]dvance given number of frames" +
      "\n[H]elp: Display commands" +
      "\n=========================");
  }
}
