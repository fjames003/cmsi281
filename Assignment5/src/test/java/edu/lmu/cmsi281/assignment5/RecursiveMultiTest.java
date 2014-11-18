package edu.lmu.cmsi281.assignment5;

import static edu.lmu.cmsi281.assignment5.RecMult.recMult;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecursiveMultiTest {
   
   @Test
   public void timesZeroTest() {
    assertEquals("Does not work with zero", 0, recMult(0, 100));
   }

   @Test
   public void timesZeroOppossiteTest() {
    assertEquals("Does not work with zero", 0, recMult(100, 0));
   }

   @Test
   public void timesOneTest() {
    assertEquals("Does not work with one", 100, recMult(1, 100));
   }

   @Test
   public void timesOneOppossiteTest() {
    assertEquals("Does not work with one", 100, recMult(100, 1));
   }

   @Test
   public void timesHundredTest() {
    assertEquals("Does not work with a hundred", 10000, recMult(100, 100));
   }

   @Test(expected = IllegalArgumentException.class)
   public void negativetest() {
    recMult(-1, -1);
   }
}