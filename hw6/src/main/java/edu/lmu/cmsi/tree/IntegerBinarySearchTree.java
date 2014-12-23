package edu.lmu.cmsi.tree;

import edu.lmu.cmsi.tree.node.BinaryTreeNode;
import edu.lmu.cmsi.tree.exception.DuplicateItemException;
import edu.lmu.cmsi.tree.exception.ItemNotFoundException;

import java.util.ArrayList;
import java.util.ArrayDeque;

public class IntegerBinarySearchTree {

  protected BinaryTreeNode root;

  public IntegerBinarySearchTree() {
    this.root = null;
  }

  /**
   * Insert into the tree.
   *
   * @param x the item to insert.
   * @throws edu.lmu.cmsi.tree.exception.DuplicateItemException if x exists.
   */
  public void insert(int x) {
    if (this.root == null) {
      this.root = new BinaryTreeNode(x);
    } else {
      if (x < this.root.getValue()) {
        addLeftSubtree(this.root, x);
      } else if (x > this.root.getValue()) {
        addRightSubtree(this.root, x);
      } else {
        throw new DuplicateItemException();
      }
    }
  }

  /**
   * Find the smallest item in the tree.
   *
   * @return smallest item or throws an exception if the tree is empty.
   * @throws edu.lmu.cmsi.tree.exception.ItemNotFoundException
   *
   */
  public int findSmallestValue() {
    if (this.root == null) {
      throw new ItemNotFoundException();
    } else {
      return farthestLeft(this.root);
    }
  }

  private int farthestLeft(BinaryTreeNode root) {
    if (root.getLeft() == null) {
      return root.getValue();
    } else {
      return farthestLeft(root.getLeft());
    }
  }

  /**
   * Find the largest item in the tree.
   *
   * @return the largest item or throws an exception if the tree is empty.
   * @throws edu.lmu.cmsi.tree.exception.ItemNotFoundException
   *
   */
  public int findLargestValue() {
    if (this.root == null) {
      throw new ItemNotFoundException();
    } else {
      return farthestRight(this.root);
    }
  }

  private int farthestRight(BinaryTreeNode root) {
    if (root.getRight() == null) {
      return root.getValue();
    } else {
      return farthestRight(root.getRight());
    }
  }

  /**
   * Returns whether or not the value exists in the tree
   *
   * @return true if the value exists, false otherwise
   */
  public boolean contains(int value) {
    if (this.root != null) {
      return contains(this.root, value);
    } else {
      return false;
    }
  }

  private boolean contains(BinaryTreeNode root, int value) {
    if (root.getValue() == value) {
      return true;
    } else {
      if (root.getLeft() == null && root.getRight() != null) {
        return contains(root.getRight(), value);
      } else if (root.getLeft() != null && root.getRight() == null) {
        return contains(root.getLeft(), value);
      } else if (root.getLeft() != null && root.getRight() != null) {
        return contains(root.getLeft(), value) || contains(root.getRight(), value);
      } else {
        return false;
      }
    }
  }

  /**
   * Returns an preorder-traversed array
   *
   * @return an array of Integers, or empty if the tree is empty.
   */
  public Integer[] toPreOrder() {
    if (this.root == null) {
      Integer[] empty = new Integer[0];
      return empty;
    } else {
      ArrayList<Integer> nums = new ArrayList<Integer>();
      ArrayList<Integer> preOrder = toPreOrder(this.root, nums);
      return preOrder.toArray(new Integer[preOrder.size()]);
    }
  }

  private ArrayList toPreOrder(BinaryTreeNode root, ArrayList nums) {
    if (root != null) {
      nums.add(root.getValue());
      toPreOrder(root.getLeft(), nums);
      toPreOrder(root.getRight(), nums);
    }
    return nums;
  }

  /**
   * Returns an inorder-traversed array
   *
   * @return an array of Integers, or empty if the tree is empty.
   */
  public Integer[] toInOrder() {
    if (this.root == null) {
      Integer[] empty = new Integer[0];
      return empty;
    } else {
      ArrayList<Integer> nums = new ArrayList<Integer>();
      ArrayList<Integer> inOrder = toInOrder(this.root, nums);
      return inOrder.toArray(new Integer[inOrder.size()]);
    }
  }

  private ArrayList toInOrder(BinaryTreeNode root, ArrayList nums) {
    if (root != null) {
      toInOrder(root.getLeft(), nums);
      nums.add(root.getValue());
      toInOrder(root.getRight(), nums);
    }
    return nums;
  }

  /**
   * Returns an postorder-traversed array
   *
   * @return an array of Integers, or empty if the tree is empty.
   */
  public Integer[] toPostOrder() {
    if (this.root == null) {
      Integer[] empty = new Integer[0];
      return empty;
    } else {
      ArrayList<Integer> nums = new ArrayList<Integer>();
      ArrayList<Integer> postOrder = toPostOrder(this.root, nums);
      return postOrder.toArray(new Integer[postOrder.size()]);
    }
  }

  private ArrayList toPostOrder(BinaryTreeNode root, ArrayList nums) {
    if (root != null) {
      toPostOrder(root.getLeft(), nums);
      toPostOrder(root.getRight(), nums);
      nums.add(root.getValue());
    }
    return nums;
  }

  /**
   * Returns an Breadth First-traversed array
   *
   * @return an array of Integers, or empty if the tree is empty.
   */
  public Integer[] toBreadthFirstOrder() {
    if (this.root == null) {
      Integer[] empty = new Integer[0];
      return empty;
    } else {
      ArrayList<Integer> nums = new ArrayList<Integer>();
      ArrayDeque<BinaryTreeNode> breadth = new ArrayDeque<BinaryTreeNode>();
      breadth.add(this.root);
      while (! breadth.isEmpty()) {
        BinaryTreeNode node = breadth.removeFirst();
        nums.add(node.getValue());
        if (node.getLeft() != null) {
          breadth.add(node.getLeft());
        } 
        if (node.getRight() != null) {
          breadth.add(node.getRight());
        }
      }
      return nums.toArray(new Integer[nums.size()]);
    }
  }

  private void addLeftSubtree(BinaryTreeNode root, int x) {
    if (root.getLeft() == null) {
      BinaryTreeNode left = new BinaryTreeNode(x);
      root.setLeft(left);
    } else {
      if (x < root.getLeft().getValue()) {
        addLeftSubtree(root.getLeft(), x);
      } else if (x > root.getLeft().getValue()) {
        addRightSubtree(root.getLeft(), x);
      } else {
        throw new DuplicateItemException();
      }
    }
  }

  private void addRightSubtree(BinaryTreeNode root, int x) {
    if (root.getRight() == null) {
      BinaryTreeNode right = new BinaryTreeNode(x);
      root.setRight(right);
    } else {
      if (x < root.getRight().getValue()) {
        addLeftSubtree(root.getRight(), x);
      } else if (x > root.getRight().getValue()) {
        addRightSubtree(root.getRight(), x);
      } else {
        throw new DuplicateItemException();
      }
    }
  }
}