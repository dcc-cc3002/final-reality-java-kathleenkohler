package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippedWeapon;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.*;

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

  void wCure(AbstractPlayerCharacter character) throws InvalidStatValueException;
  void wPoison(Enemy enemy) throws InvalidStatValueException;
  void wParalysis(Enemy enemy) throws InvalidStatValueException;
  void wThunder(Enemy enemy) throws InvalidStatValueException;
  void wFire(Enemy enemy) throws InvalidStatValueException;

}
