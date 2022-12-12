package cl.uchile.dcc.finalreality.exceptions;

import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class InvalidSpellTest {

  private BlackMage bmage;
  private WhiteMage wmage;
  BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
  private Staff staff;
  private Enemy enemy;



  @Before
  public void setUp () throws InvalidStatValueException {
    bmage = new BlackMage("bmage", 15, 10, 40, queue);
    wmage = new WhiteMage("wmage", 15, 10, 40, queue);
    staff = new Staff("staff", 6, 7,8);
    enemy = new Enemy("enemy", 20, 15, 10, 20,queue);
  }

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  @Test
  public void BlackMageCure() throws InvalidEquippedWeapon, InvalidStatValueException, InvalidSpell {
    bmage.equip(staff);
    exceptionRule.expect(InvalidSpell.class);
    exceptionRule.expectMessage("The provided spell is not castable by that mage character.");
    bmage.cure(wmage);

  }

  @Test
  public void BlackMageParalyzed() throws InvalidEquippedWeapon, InvalidStatValueException, InvalidSpell {
    bmage.equip(staff);
    exceptionRule.expect(InvalidSpell.class);
    exceptionRule.expectMessage("The provided spell is not castable by that mage character.");
    bmage.paralysis(enemy);
  }

  @Test
  public void BlackMagePoison() throws InvalidEquippedWeapon, InvalidStatValueException, InvalidSpell {
    bmage.equip(staff);
    exceptionRule.expect(InvalidSpell.class);
    exceptionRule.expectMessage("The provided spell is not castable by that mage character.");
    bmage.poison(enemy);
  }

  @Test
  public void WhiteMageThunder() throws InvalidEquippedWeapon, InvalidStatValueException, InvalidSpell {
    wmage.equip(staff);
    exceptionRule.expect(InvalidSpell.class);
    exceptionRule.expectMessage("The provided spell is not castable by that mage character.");
    wmage.thunder(enemy);
  }

  @Test
  public void WhiteMageFire() throws InvalidEquippedWeapon, InvalidStatValueException, InvalidSpell {
    wmage.equip(staff);
    exceptionRule.expect(InvalidSpell.class);
    exceptionRule.expectMessage("The provided spell is not castable by that mage character.");
    wmage.fire(enemy);
  }
}
