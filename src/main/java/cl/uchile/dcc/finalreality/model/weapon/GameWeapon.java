package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippedWeapon;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;

/**
* This represents a weapon from the game.
 */
public interface GameWeapon {

  /**
   * Returns the name of the weapon.
   */
  String getName();

  /**
   * Returns weapon damage.
   */
  int getDamage();

  /**
   * Returns the weight of the weapon.
   */
  int getWeight();

  /**
   * Equip a weapon to an Engineer.
   */
  void equipEngineer(Engineer engineer) throws InvalidEquippedWeapon;

  /**
   * Equip a weapon to a Knight.
   */
  void equipKnight(Knight knight) throws InvalidEquippedWeapon;

  /**
   * Equip a weapon to a Thief.
   */
  void equipThief(Thief thief) throws InvalidEquippedWeapon;

  /**
   * Equip a weapon to a BlackMage.
   */
  void equipBlackMage(BlackMage blackmage) throws InvalidEquippedWeapon;

  /**
   * Equip a weapon to a WhiteMage.
   */
  void equipWhiteMage(WhiteMage whitemage) throws InvalidEquippedWeapon;

  /**
   * Spell used to heal an ally for 30% of their maximum hit points.
   */
  void weaponCure(AbstractPlayerCharacter character) throws InvalidStatValueException;

  /**
   * Spell used to poison an enemy.
   */
  void weaponPoison(Enemy enemy) throws InvalidStatValueException;

  /**
   * Spell used to paralyze an enemy.
   */
  void weaponParalysis(Enemy enemy) throws InvalidStatValueException;

  /**
   * Spell used to reduce the opponent's life by magicDamage and has a 30% chance
   * to paralyze him.
   */
  void weaponThunder(Enemy enemy) throws InvalidStatValueException;

  /**
   * Spell used to reduce the opponent's life by magicDamage and has a 20% chance
   * to burn it.
   */
  void weaponFire(Enemy enemy) throws InvalidStatValueException;

}
