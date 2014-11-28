package edu.lmu.cmsi.tree.exception;

public class DuplicateItemException extends RuntimeException {
  /**
   * Create this exception without a message
   */
  public DuplicateItemException() {
    super();
  }

  /**
   * Create this exception with a message
   *
   * @param value the value that caused this exception
   */
  public DuplicateItemException(int value) {
    super(value + " was duplicated");
  }

  /**
   * Create this exception with a message
   *
   * @param message the message for this exception
   */
  public DuplicateItemException(String message) {
    super(message);
  }
}
