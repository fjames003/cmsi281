package edu.lmu.cmsi281.assignment5;

import static edu.lmu.cmsi281.assignment5.BalancedParens.balancedParens;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ParenBalancerTest {
   
   @Test
   public void notbalnLeftWithParens() {
    assertFalse(balancedParens("[((((()))]"));
   }

   @Test
   public void notbalnRightWithParens() {
    assertFalse(balancedParens("[())]"));
   }

   @Test
   public void notbalnLeftWithBracket() {
    assertFalse(balancedParens("[([())]"));
   }

   @Test
   public void notbalnRightWithBracket() {
    assertFalse(balancedParens("[(()])]"));
   }

   @Test
   public void rightNumWrongOrder() {
    assertFalse(balancedParens(")][("));
   }

   @Test
   public void intricitmess() {
    assertTrue(balancedParens("([([]()[()])])"));
   }

   @Test
   public void webpageExample() {
    assertFalse(balancedParens("[(])"));
   }
}