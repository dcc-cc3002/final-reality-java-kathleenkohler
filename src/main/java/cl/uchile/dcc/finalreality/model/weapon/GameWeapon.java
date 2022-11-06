package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippedWeapon;
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

}
