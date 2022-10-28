package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;

/**
* This represents equipping a weopon to a character.
 */
public interface EquipWeapon {
  /**
   * Equip a weapon to an Engineer.
   */
  void equipEngineer(Engineer engineer);

  /**
   * Equip a weapon to a Knight.
   */
  void equipKnight(Knight knight);

  /**
   * Equip a weapon to a Thief.
   */
  void equipThief(Thief thief);

  /**
   * Equip a weapon to a BlackMage.
   */
  void equipBlackMage(BlackMage blackmage);

  /**
   * Equip a weapon to a WhiteMage.
   */
  void equipWhiteMage(WhiteMage whitemage);

}
