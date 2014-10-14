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

  // Game Objects all held in 1d arrays
  private MovableObject[] allMovables;
  private GameObject[] allNonMovables;

  public GameEngine(int size) {
    if (size < 1) {
      throw new IllegalArgumentException("The world should exist");
    }
    this.frame = 0;
    this.size = size;

    // Create all objects in seperate methods
    // to keep constructor clean
    this.createWalls();
    this.createPieces();
  }

  private void createWalls() {
    // Let's create walls
    //for now, we only care about putting walls on the edges

    int wallCount = 0;
    // calculate the amount of walls and non-movables we'll need

    this.allNonMovables = new GameObject[(this.size * 4 - 4) + (this.size / 10) * 2];

    for (int x = 0; x < this.size; x++) {
      Wall x1 = new Wall(x, 0);
      this.allNonMovables[wallCount++] = x1;
      Wall x2 = new Wall(x, this.size - 1);
      this.allNonMovables[wallCount++] = x2;
    }

    for (int y = 1; y < size - 1; y++) {
      Wall y1 = new Wall(0, y);
      this.allNonMovables[wallCount++] = y1;
      Wall y2 = new Wall(this.size - 1, y);
      this.allNonMovables[wallCount++] = y2;
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
    for (int i = 0; i < this.allNonMovables.length; i++) {
      renderedWorld[this.allNonMovables[i].getY()][this.allNonMovables[i].getX()] =
      Character.toString(this.allNonMovables[i].getRenderedCharacter());    
    }

    //Movable Objects
    for (int i = 0; i < this.allMovables.length; i++) {
      renderedWorld[this.allMovables[i].getY()][this.allMovables[i].getX()] =
      Character.toString(this.allMovables[i].getRenderedCharacter());
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
    for (int i = 0; i < this.allMovables.length; i++) {
      System.out.println(this.allMovables[i].printHits());
    }
    System.out.println(this.NEW_LINE);
  }

  //Have all moving objects update themselves
  private void updateObjects() {
    for (int i = 0; i < this.allMovables.length; i++) {
      this.allMovables[i].update(this.size);
    }
  }

  //Check collisions between first Moving pieces and non moving pieces
  //then check between moving pieces and moving pieces.
  private void checkCollisions() {
    //Loop through every Movable Object
    for (int i = 0; i < this.allMovables.length; i++) {
      for (int j = 0; j < this.allNonMovables.length; j++) {
        this.allMovables[i].checkCollision(this.allNonMovables[j]); 
      }
      for (int k = 0; k < this.allMovables.length; k++) {
        if (!(k == i)) {
          this.allMovables[i].checkCollision(this.allMovables[k]);
        }
      }
    }
  }

  //Will Randomize all of the displacements for Moving objects
  public void randomize() {
    for (int i = 0; i < this.allMovables.length; i++) {
      this.allMovables[i].displacementRandomizer();
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

    this.allMovables = new MovableObject[(this.size / 15) + ((this.size / 15) * 4) + ((this.size / 15) * 2)];

    char[] monsterTypes = new char[] {'z', 'x', 'a', 's'};
    char[] bossTypes = new char[] {'o', 'k'};

    /* Set all Movable objects to x and y values
     * randomly generated only if x an y dont equal a
     * taken space on the board (must equal null)
     * If making monsters or Bosses increase the count
     * and then reset as to equally proportion characters
     */
    int monsterCount = 0;
    int bossCount = 0;
    int x, y;
    for (int i = 0; i < this.allMovables.length; i++) {
      x = rand.nextInt(this.size - 2) + 1;
      y = rand.nextInt(this.size - 2) + 1;
      while (board[x][y] != null) {
        x = rand.nextInt(this.size - 2) + 1;
        y = rand.nextInt(this.size - 2) + 1;
      }
      if (i < (this.size / 15)) {
        this.allMovables[i] = new Player(x, y);
        board[x][y] = this.allMovables[i];
      } else if (i > (this.size / 15) && i < (this.size / 15 + this.size / 15 * 4)) {
        this.allMovables[i] = new Monster(x, y, monsterTypes[monsterCount]);
        board[x][y] = this.allMovables[i];
        monsterCount = (monsterCount == monsterTypes.length - 1) ? 0 : monsterCount + 1;
      } else {
        this.allMovables[i] = new Boss(x, y, bossTypes[bossCount]);
        board[x][y] = this.allMovables[i];
        bossCount = (bossCount == bossTypes.length - 1) ? 0 : bossCount + 1;
      }
    }

    /* Set all non-Movable objects to x and y values
     * randomly generated only if x an y dont equal a
     * taken space on the board (must equal null)
     */
    for (int i = (this.size * 4 - 4); i < this.allNonMovables.length; i++) {
      x = rand.nextInt(this.size - 2) + 1;
      y = rand.nextInt(this.size - 2) + 1;
      while (board[x][y] != null) {
        x = rand.nextInt(this.size - 2) + 1;
        y = rand.nextInt(this.size - 2) + 1;
      }
      if (i < this.allNonMovables.length - (this.size / 10) ) {
        this.allNonMovables[i] = new Rock(x, y);
        board[x][y] = this.allNonMovables[i];
      } else {
        this.allNonMovables[i] = new Tree(x, y);
        board[x][y] = this.allNonMovables[i];
      }
    }
  }
}