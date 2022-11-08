package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippedWeapon;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

public class KnightTest {
  private Knight knight1;
  private Knight knight2;
  private Knight knight3;
  private WhiteMage wmage;
  BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
  private Knife knife;
  private Axe axe;

  @Before
  public void setUp() throws Exception {
    knight1 = new Knight("knight", 15, 10, queue);
    knight2 = new Knight("knight", 15, 10, queue);
    knight3 = new Knight("knightt", 10, 5, queue);
    wmage = new WhiteMage("wmage", 15, 10, 20, queue);
    knife = new Knife("knife", 4, 7);
    axe = new Axe("axe", 4, 7);
  }

  @Test
  public void waitTurn() throws InterruptedException, InvalidEquippedWeapon {
    knight1.equip(knife);
    knight1.waitTurn();
    Thread.sleep(3000);
    assertEquals("fail to remove Knight from the queue", knight1, queue.poll());
    assertNotEquals("pull something from the queue when it is empty", knight1, queue.poll());
    assertNull("returns something other than null when queue is empty", queue.poll());
  }

  @Test
  public void getEquippedWeaponAndEquip() throws InvalidEquippedWeapon {
    knight3.equip(knife);
    assertEquals("fail to equip weapon in Knight class", knife, knight3.getEquippedWeapon());
    knight3.equip(axe);
    assertEquals("fail to change equipped weapon in Knight class", axe, knight3.getEquippedWeapon());
  }

  @Test
  public void getName() {
    assertEquals("fail to get Name in Knight class", "knight", knight1.getName());
    assertNotEquals("fail to get Name in Knight class", knight2.getName(), knight3.getName());
  }

  @Test
  public void getCurrentHp() {
    assertEquals("fail to get currentHp in Knight class", 15, knight1.getCurrentHp());
    assertNotEquals("fail to get currentHp in Knight class", knight2.getCurrentHp(), knight3.getCurrentHp());
  }

  @Test
  public void getMaxHp() {
    assertEquals("fail to get MaxHp in Knight class", 15, knight1.getMaxHp());
    assertNotEquals("fail to get MaxHp in Knight class", knight2.getMaxHp(), knight3.getMaxHp());
  }

  @Test
  public void getDefense() {
    assertEquals("fail to get Defense in Knight class", 10, knight1.getDefense());
    assertNotEquals("fail to get Defense in Knight class", knight2.getDefense(), knight3.getDefense());
  }

  @Test
  public void setCurrentHp() throws InvalidStatValueException {
    knight1.setCurrentHp(10);
    assertEquals("fail to change currentHp in Knight class", 10, knight1.getCurrentHp());
    assertEquals("fail to change currentHp in Knight class", knight1.getCurrentHp(), knight3.getCurrentHp());
    knight3.setCurrentHp(5);
    assertNotEquals("fail to change currentHp in Knight class", knight1.getCurrentHp(), knight3.getCurrentHp());
  }

  @Test
  public void testHashCode() {
    assertEquals("hashcode fails for equal elements in Knight", knight1.hashCode(), knight2.hashCode());
    assertNotEquals("hashcode fails for distinct elements in Knight", knight2.hashCode(), knight3.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue("equals fails with same object in Knight", knight1.equals(knight1));
    assertTrue("equals fails with equal object in Knight", knight1.equals(knight2));
    assertFalse("equals fails with different objects in Knight", knight1.equals(knight3));
    assertFalse("equals fails with different types of characters in Knight", knight2.equals(wmage));
  }

  @Test
  public void testToString() {
    assertEquals("ToString method does not work in Knight class",
          "Knight{maxHp=15, defense=10, name='knight'}", knight2.toString());
  }
}
