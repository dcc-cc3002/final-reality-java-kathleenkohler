package cl.uchile.dcc.finalreality.exceptions;

/**
 * This error is used to represent an invalid equipped weapon
 */
public class InvalidEquippedWeapon extends Exception {

  /**
   * Creates a new InvalidEquippedWeapon.
   */
  public InvalidEquippedWeapon() {
    super("The provided weapon is not equippable by that character.");
  }
}
