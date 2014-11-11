package edu.lmu.cmsi281.assignment5;

import static edu.lmu.cmsi281.assignment5.StringIntConv.stringIntConv;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StringIntTest {
   
   @Test
   public void zeroTest() {
    assertEquals("Does not work with zero", 0, stringIntConv("0"));
   }

   @Test
   public void oneTest() {
    assertEquals("Does not work with zero", 1, stringIntConv("1"));
   }

   @Test
   public void hundredTest() {
    assertEquals("Does not work with one", 100, stringIntConv("100"));
   }

   @Test(expected = IllegalArgumentException.class)
   public void negativeTest() {
    stringIntConv("-1");
   }

   @Test(expected = IllegalArgumentException.class)
   public void withLetterTest() {
    stringIntConv("123a321");
   }
}