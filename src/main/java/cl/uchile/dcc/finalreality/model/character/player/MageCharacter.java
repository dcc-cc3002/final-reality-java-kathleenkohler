package cl.uchile.dcc.finalreality.model.character.player;


import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;

/**
 * A PlayerChracter that can cast spells.
 */
public interface MageCharacter {

  /**
   * Returns the character's current MP.
   */
  int getCurrentMp();

  /**
   * Returns the character's max MP.
   */
  int getMaxMp();

  /**
   * Sets the character's current MP.
   */
  void setCurrentMp(int currentMp) throws InvalidStatValueException;
}
