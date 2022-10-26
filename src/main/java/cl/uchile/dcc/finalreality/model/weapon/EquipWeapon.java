package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.model.character.player.*;

public interface EquipWeapon {

  void equipEngineer(Engineer engineer);

  void equipKnight(Knight knight);

  void equipThief(Thief thief);

  void equipBlackMage(BlackMage blackmage);

  void equipWhiteMage(WhiteMage whitemage);

}
