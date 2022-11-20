package cl.uchile.dcc.finalreality.exceptions;

/**
 * This error is used to represent an invalid spell for a mage.
 */
public class InvalidSpell  extends Exception {

  /**
   * Creates a new InvalidSpell.
   */
  public InvalidSpell() {
    super("The provided spell is not castable by that mage character.");
  }
}

