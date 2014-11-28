package edu.lmu.cmsi.tree;

import edu.lmu.cmsi.tree.exception.DuplicateItemException;
import edu.lmu.cmsi.tree.exception.ItemNotFoundException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerBinarySearchTreeTest {
  private IntegerBinarySearchTree tree;

  @Before
  public void constructTree() {
    // recreate the tree between every test
    this.tree = new IntegerBinarySearchTree();
  }

  // insert tests
  @Test
  public void basicInsertTest() {
    this.tree.insert(10);
  }

  @Test(expected = DuplicateItemException.class)
  public void insertDuplicateTest() {
    this.tree.insert(10);
    this.tree.insert(10);
  }
  // end insert tests

  // find smallest test
  @Test
  public void findSmallestValueTest() {
    int[] valuesToInsert = {912, 4992, 10, 20, 1, 102, 582, 285, 143, 12, 2, 3, 4482, 18, 471};
    for (int i : valuesToInsert) {
      this.tree.insert(i);
    }

    int smallest = this.tree.findSmallestValue();
    assertEquals("failure - didn't find the correct smallest value", 1, smallest);
  }

  @Test(expected = ItemNotFoundException.class)
  public void findSmallestValueNotFoundTest() {
    int smallest = this.tree.findSmallestValue();
  }
  // end find smallest test

  // find largest test
  @Test
  public void findLargestValueTest() {
    Integer[] valuesToInsert = {912, 4992, 10, 20, 1, 102, 582, 285, 143, 12, 2, 3, 4482, 18, 471};
    for (int i : valuesToInsert) {
      this.tree.insert(i);
    }

    int largest = this.tree.findLargestValue();
  }

  @Test(expected = ItemNotFoundException.class)
  public void findLargestValueNotFoundTest() {
    int largest = this.tree.findLargestValue();
  }
  // find largest test

  // contains test
  @Test
  public void containsFoundTest() {
    Integer[] valuesToInsert = {912, 4992, 10, 20, 1, 102, 582, 285, 143, 12, 2, 3, 4482, 18, 471};
    for (int i : valuesToInsert) {
      this.tree.insert(i);
    }

    boolean found = this.tree.contains(10);
    assertTrue("Not found but it should have been", found);
  }

  @Test
  public void containsNotFoundTest() {
    int[] valuesToInsert = {912, 4992, 10, 20, 1, 102, 582, 285, 143, 12, 2, 3, 4482, 18, 471};
    for (int i : valuesToInsert) {
      this.tree.insert(i);
    }

    boolean found = this.tree.contains(1111110);
    assertFalse("Found but it should have been", found);
  }
  // end contains test

  // preorder traversal test
  @Test
  public void preOrderTest() {
    Integer[] valuesToInsert = {912, 4992, 10, 20, 1, 102, 582, 285, 143, 12, 2, 3, 4482, 18, 471};
    Integer[] expected = {912, 10, 1, 2, 3, 20, 12, 18, 102, 582, 285, 143, 471, 4992, 4482};
    for (int i : valuesToInsert) {
      this.tree.insert(i);
    }

    Integer[] preOrder = this.tree.toPreOrder();

    assertArrayEquals("preorder traversal not correct", expected, preOrder);
  }

  @Test
  public void preOrderEmptyTest() {
    Integer[] expected = {};
    Integer[] preOrder = this.tree.toPreOrder();

    assertArrayEquals("empty preorder traversal not correct", expected, preOrder);
  }
  // end preorder traversal test

  // inorder traversal test
  @Test
  public void inOrderTest() {
    Integer[] valuesToInsert = {912, 4992, 10, 20, 1, 102, 582, 285, 143, 12, 2, 3, 4482, 18, 471};
    Integer[] expected = {1, 2, 3, 10, 12, 18, 20, 102, 143, 285, 471, 582, 912, 4482, 4992};
    for (int i : valuesToInsert) {
      this.tree.insert(i);
    }

    Integer[] preOrder = this.tree.toInOrder();

    assertArrayEquals("inorder traversal not correct", expected, preOrder);
  }

  @Test
  public void inOrderEmptyTest() {
    Integer[] expected = {};
    Integer[] preOrder = this.tree.toInOrder();

    assertArrayEquals("empty inorder traversal not correct", expected, preOrder);
  }
  // end inorder traversal test
  
  // postorder traversal test
  @Test
  public void postOrderTest() {
    Integer[] valuesToInsert = {912, 4992, 10, 20, 1, 102, 582, 285, 143, 12, 2, 3, 4482, 18, 471};
    Integer[] expected = {3, 2, 1, 18, 12, 143, 471, 285, 582, 102, 20, 10, 4482, 4992, 912};
    for (int i : valuesToInsert) {
      this.tree.insert(i);
    }

    Integer[] postOrder = this.tree.toPostOrder();

    assertArrayEquals("postorder traversal not correct", expected, postOrder);
  }

  @Test
  public void postOrderEmptyTest() {
    Integer[] expected = {};
    Integer[] postOrder = this.tree.toPostOrder();

    assertArrayEquals("empty postorder traversal not correct", expected, postOrder);
  }
  // end postorder traversal test

  // breadth-first traversal test
  @Test
  public void breadthFirstOrderTest() {
    Integer[] valuesToInsert = {912, 4992, 10, 20, 1, 102, 582, 285, 143, 12, 2, 3, 4482, 18, 471};
    Integer[] expected = {912, 10, 4992, 1, 20, 4482, 2, 12, 102, 3, 18, 582, 285, 143, 471};
    for (int i : valuesToInsert) {
      this.tree.insert(i);
    }

    Integer[] breadthFirst = this.tree.toBreadthFirstOrder();

    assertArrayEquals("breadth-first not correct", expected, breadthFirst);
  }

  @Test
  public void breadthFirstOrderEmptyTest() {
    Integer[] expected = {};
    Integer[] breadthFirst = this.tree.toBreadthFirstOrder();

    assertArrayEquals("empty breadth-first traversal not correct", expected, breadthFirst);
  }
  // end breadth-first traversal test
  
}