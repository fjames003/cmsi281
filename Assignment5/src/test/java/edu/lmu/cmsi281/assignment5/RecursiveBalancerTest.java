package edu.lmu.cmsi281.assignment5;

import static edu.lmu.cmsi281.assignment5.RecursiveBalancer.recursiveBalancer;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class RecursiveBalancerTest {
   
   @Test
   public void notbalnLeftWithParens() {
    assertFalse(recursiveBalancer("[((((()))]"));
   }

   @Test
   public void notbalnRightWithParens() {
    assertFalse(recursiveBalancer("[())]"));
   }

   @Test
   public void notbalnLeftWithBracket() {
    assertFalse(recursiveBalancer("[([())]"));
   }

   @Test
   public void notbalnRightWithBracket() {
    assertFalse(recursiveBalancer("[(()])]"));
   }

   @Test
   public void rightNumWrongOrder() {
    assertFalse(recursiveBalancer(")][("));
   }

   @Test
   public void intricitmess() {
    assertTrue(recursiveBalancer("([([]()[()])])"));
   }

   @Test
   public void webpageExample() {
    assertFalse(recursiveBalancer("[(])"));
   }

   @Test
   public void withLettersTest() {
    assertTrue(recursiveBalancer("[abdsf*(1+2)] - (4/5)[]"));
   }
}