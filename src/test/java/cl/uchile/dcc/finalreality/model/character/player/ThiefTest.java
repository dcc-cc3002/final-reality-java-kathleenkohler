package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippedWeapon;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

public class ThiefTest {

  private Thief thief1;
  private Thief thief2;
  private Thief thief3;
  private WhiteMage wmage;
  BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
  private Sword sword;
  private Bow bow;

  @Before
  public void setUp() throws Exception {
    thief1 = new Thief("thief", 15, 10, queue);
    thief2 = new Thief("thief", 15, 10, queue);
    thief3 = new Thief("thieff", 10, 5, queue);
    wmage = new WhiteMage("wmage", 15, 10, 20, queue);
    sword = new Sword("sword", 4, 7);
    bow = new Bow("bow", 4, 7);
  }

  @Test
  public void waitTurn() throws InterruptedException, InvalidEquippedWeapon {
    thief1.equip(sword);
    thief1.waitTurn();
    Thread.sleep(3000);
    assertEquals("fail to remove Thief from the queue", thief1, queue.poll());
    assertNotEquals("pull something from the queue when it is empty", thief1, queue.poll());
    assertNull("returns something other than null when queue is empty", queue.poll());
  }


  @Test
  public void getEquippedWeaponAndEquip() throws InvalidEquippedWeapon {
    thief3.equip(sword);
    assertEquals("fail to equip weapon in Thief class", sword, thief3.getEquippedWeapon());
    thief3.equip(bow);
    assertEquals("fail to change equipped weapon in Thief class", bow, thief3.getEquippedWeapon());
  }

  @Test
  public void getName() {
    assertEquals("fail to get Name in Thief class", "thief", thief1.getName());
    assertNotEquals("fail to get Name in Thief class", thief2.getName(), thief3.getName());
  }

  @Test
  public void getCurrentHp() {
    assertEquals("fail to get currentHp in Thief class", 15, thief1.getCurrentHp());
    assertNotEquals("fail to get currentHp in Thief class", thief2.getCurrentHp(), thief3.getCurrentHp());
  }

  @Test
  public void getMaxHp() {
    assertEquals("fail to get MaxHp in Thief class", 15, thief1.getMaxHp());
    assertNotEquals("fail to get MaxHp in Thief class", thief2.getMaxHp(), thief3.getMaxHp());
  }

  @Test
  public void getDefense() {
    assertEquals("fail to get Defense in Thief class", 10, thief1.getDefense());
    assertNotEquals("fail to get Defense in Thief class", thief2.getDefense(), thief3.getDefense());
  }

  @Test
  public void setCurrentHp() throws InvalidStatValueException {
    thief1.setCurrentHp(10);
    assertEquals("fail to change currentHp in Thief class", 10, thief1.getCurrentHp());
    assertEquals("fail to change currentHp in Thief class", thief1.getCurrentHp(), thief3.getCurrentHp());
    thief3.setCurrentHp(5);
    assertNotEquals("fail to change currentHp in Thief class", thief1.getCurrentHp(), thief3.getCurrentHp());
  }

  @Test
  public void testHashCode() {
    assertEquals("hashcode fails for equal elements in Thief", thief1.hashCode(), thief2.hashCode());
    assertNotEquals("hashcode fails for distinct elements in Thief", thief2.hashCode(), thief3.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue("equals fails with same object in Thief", thief1.equals(thief1));
    assertTrue("equals fails with equal object in Thief", thief1.equals(thief2));
    assertFalse("equals fails with different objects in Thief", thief1.equals(thief3));
    assertFalse("equals fails with different types of characters in Thief", thief2.equals(wmage));
  }

  @Test
  public void testToString() {
    assertEquals("ToString method does not work in Thief class",
          "Thief{maxHp=15, defense=10, name='thief'}", thief2.toString());
  }
}