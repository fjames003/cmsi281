package edu.lmu.cmsi281.assignment3.core;

import edu.lmu.cmsi281.assignment3.core.MovableObject;
import edu.lmu.cmsi281.assignment3.core.GameObject;
import edu.lmu.cmsi281.assignment3.gameobjects.Player;
import edu.lmu.cmsi281.assignment3.gameobjects.Boss;
import edu.lmu.cmsi281.assignment3.gameobjects.Monster;

import edu.lmu.cmsi281.assignment3.gameobjects.Wall;
import edu.lmu.cmsi281.assignment3.gameobjects.Rock;
import edu.lmu.cmsi281.assignment3.gameobjects.Tree;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovableObjectTest {

    // Expected hit values for all combinations of collisions
    // between moving players. Numbers are for 1000 collisions as in check1000()
    public static final double PLAYER_MONSTER_EXPECTED = 500.0;
    public static final double PLAYER_BOSS_EXPECTED = 300.0;
    public static final double BOSS_EXPECTED = 700.0;
    public static final double MONSTER_ZX_EXPECTED = 500.0;
    public static final double MONSTER_AS_EXPECTED = 600.0;

    // Represents 5% of 1000 meaning objects are being hit
    // when expected AT LEAST 95% of the time.
    public static final double DELTA = 50.0;

    // Movable objects to be used in tests
    private MovableObject player;
    private MovableObject boss;
    private MovableObject monsterZX;
    private MovableObject monsterAS;

    // Non-Movable objects to be used in tests
    private GameObject rock;
    private GameObject tree;
    private GameObject wall;


    @Before
    public void intialize() {
        this.player = new Player(5, 5);
        this.boss = new Boss(5, 5, 'o');
        this.monsterZX = new Monster(5, 5, 'z');
        this.monsterAS = new Monster(5, 5, 'a');

        this.rock = new Rock(5, 5);
        this.tree = new Tree(5, 5);
        this.wall = new Wall(5, 5);
    }

    // Make sure GameObject is in positive quadrant
    @Test(expected = IllegalArgumentException.class)
    public void badLocation() {
        MovableObject m = new Player(-1, 1);
    }

    // New Moving Object should have 0 hits to begin.
    @Test
    public void testHits() {
        assertEquals(0.0, (double)this.player.getHits(), 0.0);
    } 

    // Can get correct rendered character for Player
    // and have zero hits to begin -> combined with printHits()
    @Test
    public void printHitsTest() {
        boolean matchStrings = this.player.printHits().equals("P: 0");
        assertTrue(matchStrings);
    }


    // Tests being run for 1000 collisions with a delta of 50 (5%)

    // Test when a Player collides with Boss
    // Should be hit 700 +/- 50 times
    @Test
    public void checkPlayerBossCollision() {
        check1000(this.player, this.boss);
        double actual = this.player.getHits();
        // Within 10% for only 1000 trials...
        assertEquals(BOSS_EXPECTED, actual, DELTA);
    }
    // Test when a Player collides with Monsters Z or X
    // Should be hit 500 +/- 50 times
    @Test
    public void checkPlayerMonster_ZX_Collision() {
        check1000(this.player, this.monsterZX);
        double actual = this.player.getHits();
        assertEquals(MONSTER_ZX_EXPECTED, actual, DELTA);
    }

    // Test when a Player collides with Monsters A or S
    // Should be hit 600 +/- 50 times
    @Test
    public void checkPlayerMonster_AS_Collision() {
        check1000(this.player, this.monsterAS);
        double actual = this.player.getHits();
        assertEquals(MONSTER_AS_EXPECTED, actual, DELTA);
    }

    // Test when Monsters A or S collides with a Player
    // Should be hit 500 +/- 50 times
    @Test
    public void checkMonster_AS_PlayerCollision() {
        check1000(this.monsterAS, this.player);
        double actual = this.monsterAS.getHits();
        assertEquals(PLAYER_MONSTER_EXPECTED, actual, DELTA);
    }

    // Test when Monsters Z or X collides with a Player
    // Should be hit 500 +/- 50 times
    @Test
    public void checkMonster_ZX_PlayerCollision() {
        check1000(this.monsterZX, this.player);
        double actual = this.monsterZX.getHits();
        assertEquals(PLAYER_MONSTER_EXPECTED, actual, DELTA);
    }

    // Test when Boss collides with a Player
    // Should be hit 300 +/- 50 times
    @Test
    public void checkBossPlayerCollision() {
        check1000(this.boss, this.player);
        double actual = this.boss.getHits();
        assertEquals(PLAYER_BOSS_EXPECTED, actual, DELTA);
    }

    // Test when Monsters Z or X collides with a Boss
    // Should be hit 0 times [the two antagonists do not hit each other]
    @Test
    public void checkMonster_ZX_BossCollision() {
        check1000(this.monsterZX, this.boss);
        double actual = this.monsterAS.getHits();
        assertEquals(0.0, actual, 0.0);
    }

    // Test when Monsters A or S collides with a Boss
    // Should be hit 0 times [the two antagonists do not hit each other]
    @Test
    public void checkMonster_AS_BossCollision() {
        check1000(this.monsterAS, this.boss);
        double actual = this.monsterAS.getHits();
        assertEquals(0.0, actual, 0.0);
    }

    // Test if a Movable GameObject can update itself
    // and that it is not in the same place
    @Test
    public void movableGameObjectMovement() {
        // Puts player in middle of board...
        this.player.update(10);
        boolean didMove = this.player.getX() != 5 || this.player.getY() != 5;
        assertTrue(didMove);
    }

    // Make sure after hitting a Rock 1000 times getHits() returns 1000
    @Test
    public void checkPlayerRockCollision() {
        check1000(this.player, this.rock);
        assertEquals(1000.0, this.player.getHits(), 0.0);
    }

    // Make sure after hitting a Tree 1000 times getHits() returns 1000
    @Test
    public void checkPlayerTreeCollision() {
        check1000(this.player, this.tree);
        assertEquals(1000.0, this.player.getHits(), 0.0);
    }

    // Make sure after hitting a Wall 1000 times getHits() returns 0
    @Test
    public void checkPlayerWallCollision() {
        check1000(this.player, this.wall);
        assertEquals(0.0, this.player.getHits(), 0.0);
    }

    // Private method to check if a movable object collides with a
    // Gameobject of any kind 1000 times (to establish a probability)
    private void check1000(MovableObject a, GameObject b) {
        for (int i = 0; i < 1000; i++) {
            a.checkCollision(b);
        }
    }
}