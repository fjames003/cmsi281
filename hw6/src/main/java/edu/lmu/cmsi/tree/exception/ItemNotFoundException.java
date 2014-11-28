package edu.lmu.cmsi.tree.exception;

public class ItemNotFoundException extends RuntimeException {
  /**
   * Create this exception without a message
   */
  public ItemNotFoundException() {
    super();
  }


  /**
   * Create this exception with a message
   *
   * @param value the value that caused this exception
   */
  public ItemNotFoundException(int value) {
    super(value + " was not found");
  }

  /**
   * Create this exception with a message
   *
   * @param message the message for this exception
   */
  public ItemNotFoundException(String message) {
    super(message);
  }
}
