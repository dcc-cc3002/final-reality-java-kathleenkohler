package cl.uchile.dcc.finalreality.model.character.player;


import cl.uchile.dcc.finalreality.exceptions.InvalidSpell;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;

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

  /**
   * Spell used to poison an enemy.
   */
  void poison(Enemy enemy) throws InvalidSpell, InvalidStatValueException;

  /**
   *
   */
  void thunder(Enemy enemy) throws InvalidSpell, InvalidStatValueException;

  /**
   *
   */
  void fire(Enemy enemy) throws InvalidSpell, InvalidStatValueException;

  /**
   * Spell used to paralyze an enemy.
   */
  void paralysis(Enemy enemy) throws InvalidSpell, InvalidStatValueException;

  /**
   * Spell used to heal an ally for 30% of their maximum hit points.
   */
  void cure(AbstractPlayerCharacter character) throws InvalidSpell, InvalidStatValueException;

}
