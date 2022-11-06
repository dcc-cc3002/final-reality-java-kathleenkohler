package cl.uchile.dcc.finalreality.exceptions;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class InvalidEquippedWeaponTest {

  private Knight knight;
  private Engineer engineer;
  private Thief thief;
  private BlackMage bmage;
  private WhiteMage wmage;
  BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
  private Axe axe;
  private Bow bow;
  private Knife knife;
  private Staff staff;
  private Sword sword;

  @Before
  public void setUp() throws Exception {
    knight = new Knight("knight", 15, 10, queue);
    engineer = new Engineer("engineer", 15, 10, queue);
    thief = new Thief("thief", 15, 10, queue);
    bmage = new BlackMage("bmage", 15, 10, 20, queue);
    wmage = new WhiteMage("wmage", 15, 10, 20, queue);
    axe = new Axe("axe", 4,7);
    bow = new Bow("bow", 4,7);
    knife = new Knife("knife", 4,7);
    staff = new Staff("staff", 6,8);
    sword = new Sword("sword", 4 ,7);
  }

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  @Test
  public void KnightWeaponException() throws InvalidEquippedWeapon {
    exceptionRule.expect(InvalidEquippedWeapon.class);
    exceptionRule.expectMessage("The provided weapon is not equippable by that character.");
    knight.equip(staff);

    exceptionRule.expect(InvalidEquippedWeapon.class);
    exceptionRule.expectMessage("The provided weapon is not equippable by that character.");
    knight.equip(bow);
  }

  @Test
  public void EngineerWeaponException() throws InvalidEquippedWeapon {
    exceptionRule.expect(InvalidEquippedWeapon.class);
    exceptionRule.expectMessage("The provided weapon is not equippable by that character.");
    engineer.equip(sword);

    exceptionRule.expect(InvalidEquippedWeapon.class);
    exceptionRule.expectMessage("The provided weapon is not equippable by that character.");
    engineer.equip(knife);

    exceptionRule.expect(InvalidEquippedWeapon.class);
    exceptionRule.expectMessage("The provided weapon is not equippable by that character.");
    engineer.equip(staff);
  }

  @Test
  public void ThiefWeaponException() throws InvalidEquippedWeapon {
    exceptionRule.expect(InvalidEquippedWeapon.class);
    exceptionRule.expectMessage("The provided weapon is not equippable by that character.");
    thief.equip(axe);

    exceptionRule.expect(InvalidEquippedWeapon.class);
    exceptionRule.expectMessage("The provided weapon is not equippable by that character.");
    thief.equip(staff);
  }

  @Test
  public void BlackMageWeaponException() throws InvalidEquippedWeapon {
    exceptionRule.expect(InvalidEquippedWeapon.class);
    exceptionRule.expectMessage("The provided weapon is not equippable by that character.");
    bmage.equip(sword);

    exceptionRule.expect(InvalidEquippedWeapon.class);
    exceptionRule.expectMessage("The provided weapon is not equippable by that character.");
    bmage.equip(axe);

    exceptionRule.expect(InvalidEquippedWeapon.class);
    exceptionRule.expectMessage("The provided weapon is not equippable by that character.");
    bmage.equip(bow);
  }

  @Test
  public void WhiteMageWeaponException() throws InvalidEquippedWeapon {
    exceptionRule.expect(InvalidEquippedWeapon.class);
    exceptionRule.expectMessage("The provided weapon is not equippable by that character.");
    wmage.equip(sword);

    exceptionRule.expect(InvalidEquippedWeapon.class);
    exceptionRule.expectMessage("The provided weapon is not equippable by that character.");
    wmage.equip(axe);

    exceptionRule.expect(InvalidEquippedWeapon.class);
    exceptionRule.expectMessage("The provided weapon is not equippable by that character.");
    wmage.equip(knife);

    exceptionRule.expect(InvalidEquippedWeapon.class);
    exceptionRule.expectMessage("The provided weapon is not equippable by that character.");
    wmage.equip(bow);
  }

}
