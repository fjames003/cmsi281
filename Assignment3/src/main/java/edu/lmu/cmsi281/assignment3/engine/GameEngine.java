package edu.lmu.cmsi281.assignment3.engine;

import edu.lmu.cmsi281.assignment3.gameobjects.Wall;
import edu.lmu.cmsi281.assignment3.gameobjects.Rock;
import edu.lmu.cmsi281.assignment3.gameobjects.Tree;
import edu.lmu.cmsi281.assignment3.gameobjects.Player;
import edu.lmu.cmsi281.assignment3.gameobjects.Monster;
import edu.lmu.cmsi281.assignment3.gameobjects.Boss;

import edu.lmu.cmsi281.assignment3.core.GameObject;
import edu.lmu.cmsi281.assignment3.core.MovableObject;

import java.util.Random;

public class GameEngine {

  private int frame;
  private int size;

  private static final String NEW_LINE = "=========================";

  // Game Objects


  private MovableObject[][] movables = new MovableObject[3][];
  private GameObject[][] notMovables = new GameObject[3][];

  public GameEngine(int size) {
    if (size < 1) {
      throw new IllegalArgumentException("The world should exist");
    }
    this.frame = 0;
    this.size = size;

    // Do all objects in seperate methods
    // to keep constructor clean
    this.createWalls();
    this.createPieces();
  }

  private void createWalls() {
    // Let's create walls
    //for now, we only care about putting walls on the edges

    int wallCount = 0;
    // calculate the amount of walls we'll need
    this.notMovables[0] = new Wall[this.size * 4 - 4];

    for (int x = 0; x < this.size; x++) {
      Wall x1 = new Wall(x, 0);
      this.notMovables[0][wallCount++] = x1;
      Wall x2 = new Wall(x, this.size - 1);
      this.notMovables[0][wallCount++] = x2;
    }

    for (int y = 1; y < size - 1; y++) {
      Wall y1 = new Wall(0, y);
      this.notMovables[0][wallCount++] = y1;
      Wall y2 = new Wall(this.size - 1, y);
      this.notMovables[0][wallCount++] = y2;
    }
  }

  // the main update loop
  public void update() {
    this.frame++;
    this.render();
    this.updateObjects();
    this.checkCollisions();
    
  }

  private void render() {
    // Strings are a bit overkill here but easier to represent a String as a null than a character
    String[][] renderedWorld = new String[this.size][this.size];

    //Non-Movable Objects
    for (int i = 0; i < this.notMovables.length; i++) {
      for (int j = 0; j < this.notMovables[i].length; j++) {
        renderedWorld[this.notMovables[i][j].getY()][this.notMovables[i][j].getX()] =
        Character.toString(this.notMovables[i][j].getRenderedCharacter());
      }      
    }

    //Movable Objects
    for (int i = 0; i < this.movables.length; i++) {
      for(int j = 0; j < this.movables[i].length; j++) {
        renderedWorld[this.movables[i][j].getY()][this.movables[i][j].getX()] =
        Character.toString(this.movables[i][j].getRenderedCharacter());
      }
    }

    System.out.println(this.NEW_LINE);
    System.out.println("Frame: " + this.frame);  // book keeping

    for (int row = 0; row < renderedWorld.length; row++) {
      String[] rowOfWorld = renderedWorld[row];
      for (int col = 0; col < rowOfWorld.length; col++) {
        String w = rowOfWorld[col];
        // If our string is null
        if (w == null) {
          w = ".";
        }
        System.out.print(w + " ");
      }
      System.out.println(""); // print a new line between each scene
    }

    System.out.println(this.NEW_LINE);

    //Print Hits for Moving Objects
    System.out.println("Hits:");
    for (int i = 0; i < this.movables.length; i++) {
      for(int j = 0; j < this.movables[i].length; j++) {
        System.out.println(this.movables[i][j].printHits());
      }
    }
    System.out.println(this.NEW_LINE);
  }

  //Have all moving objects update themselves
  private void updateObjects() {
    for (int i = 0; i < this.movables.length; i++) {
      for(int j = 0; j < this.movables[i].length; j++) {

        this.movables[i][j].update(this.size);
      }
    }
  }

  //Check collisions between first Moving pieces and non mving pieces
  //then check between moving pieces and moving pieces.
  private void checkCollisions() {
    //Loop through every "Flavor" of Movable Object
    for (int i = 0; i < this.movables.length; i++) {
      //Loop through each "Flavor's" length
      for (int j = 0; j < this.movables[i].length; j++) {
        //Compare all Movables to not movable "Flavors" except wall
        for (int k = 0; k < this.notMovables.length; k++) {
          //For each "Flavor's" length compare Movables to Not Movables
          for (int l = 0; l < this.notMovables[k].length; l++) {
            this.movables[i][j].checkCollision(this.notMovables[k][l]);
          }
        }
        for (int x = 0; x < this.movables.length; x++) {
          for (int y = 0; y < this.movables[x].length; y++) {
              if (!(x == i && y == j)) {
                this.movables[i][j].checkCollision(this.movables[x][y]);
              }
          }
        }
      }
    }
  }

  //Will Randomize all of the displacements for Moving objects
  public void randomize() {
    for (int i = 0; i < this.movables.length; i++) {
      for(int j = 0; j < this.movables[i].length; j++) {
        this.movables[i][j].displacementRandomizer();
      }
    }
    
    System.out.println("\nDisplacements have been Randomized\n" +NEW_LINE);
  }

  /* Create a Gameobject 2-dimensional array to
   * to proxy the real board but with dimensions one
   * less to avoid problems with walls. All types of
   * characters are in equal distribution (i.e. there can
   * on be 4, 8, 12 monsters on the board)
   */
  private void createPieces() {
    GameObject[][] board = new GameObject[this.size - 1][this.size - 1];
    Random rand = new Random();
    // One Player every 15 squares, and 4 monsters per player
    // as well as 2 bosses per player. [all types in equal proportions]
    this.movables[0] = new Player[this.size / 15];
    this.movables[1] = new Monster[4 * this.movables[0].length];
    this.movables[2] = new Boss[2 * this.movables[0].length];

    char[] monsterTypes = new char[] {'z', 'x', 'a', 's'};
    char[] bossTypes = new char[] {'o', 'k'};

    

    // 2 Rocks and 2 Trees per 10 game squares
    this.notMovables[1] = new Rock[(this.size / 10) + 1];
    this.notMovables[2] = new Tree[(this.size / 10) + 1];

    // Set all Movable objects to x and y values
    // randomly generated only if x an y dont equal a
    // taken space on the board (must equal null)
    // If making monsters or Bosses increase the count
    // and then reset as to equally proportion characters
    int monsterCount = 0;
    int bossCount = 0;
    int x, y;
    for (int i = 0; i < this.movables.length; i++) {
      for (int j = 0; j < this.movables[i].length; j++) {
        x = rand.nextInt(this.size - 2) + 1;
        y = rand.nextInt(this.size - 2) + 1;
        while (board[x][y] != null) {
          x = rand.nextInt(this.size - 2) + 1;
          y = rand.nextInt(this.size - 2) + 1;
        }
        if (i == 0) {
          this.movables[i][j] = new Player(x, y);
          board[x][j] = this.movables[i][j];
        } else if (i == 1) {
          this.movables[i][j] = new Monster(x, y, monsterTypes[monsterCount]);
          board[x][j] = this.movables[i][j];
          monsterCount = (monsterCount == monsterTypes.length - 1) ? 0 : monsterCount + 1;
        } else {
          this.movables[i][j] = new Boss(x, y, bossTypes[bossCount]);
          board[x][j] = this.movables[i][j];
          bossCount = (bossCount == bossTypes.length - 1) ? 0 : bossCount + 1;
        }
      }
    }

    // Set all non-Movable objects to x and y values
    // randomly generated only if x an y dont equal a
    // taken space on the board (must equal null)
    for (int i = 1; i < this.notMovables.length; i++) {
      for (int j = 0; j < this.notMovables[i].length; j++) {
        x = rand.nextInt(this.size - 2) + 1;
        y = rand.nextInt(this.size - 2) + 1;
        while (board[x][i] != null) {
          x = rand.nextInt(this.size - 2) + 1;
          y = rand.nextInt(this.size - 2) + 1;
        }
        if (i == 1) {
          this.notMovables[i][j] = new Rock(x, y);
          board[x][j] = this.movables[i][j];
        } else {
          this.notMovables[i][j] = new Tree(x, y);
          board[x][j] = this.movables[i][j];
        }
      }
    }
  }
}