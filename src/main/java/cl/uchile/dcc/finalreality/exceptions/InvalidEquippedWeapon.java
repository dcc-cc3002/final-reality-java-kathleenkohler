package cl.uchile.dcc.finalreality.exceptions;

/**
 * This error is used to represent an invalid equipped weapon
 */
public class InvalidEquippedWeapon extends Exception {

  public InvalidEquippedWeapon() {
    super("The provided weapon is not equippable by that character.");
  }

  /*

  public static void InvalidEquippedWeapon(String character, String weapon)


  public static void statValueAtLeast(int least, int actualStat, String statName)
      throws InvalidStatValueException {
    if (least > actualStat) {
      throw new InvalidStatValueException(
          "'%s'(%d) must be at least %d".formatted(statName, actualStat, least));
    }
  }
   */
}
