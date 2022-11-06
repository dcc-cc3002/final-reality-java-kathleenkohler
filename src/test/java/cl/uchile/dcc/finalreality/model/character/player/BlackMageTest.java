package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippedWeapon;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

public class BlackMageTest {
  private BlackMage bmage1;
  private BlackMage bmage2;
  private BlackMage bmage3;
  private Engineer engineer;
  BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
  private Staff staff;
  private Knife knife;

  @Before
  public void setUp() throws Exception {
    queue = new LinkedBlockingQueue<>();
    bmage1 = new BlackMage("bmage", 15, 10, 20, queue);
    bmage2 = new BlackMage("bmage", 15, 10, 20, queue);
    bmage3 = new BlackMage("bmagee", 10, 5, 18, queue);
    engineer = new Engineer("engineer", 15, 10, queue);
    staff = new Staff("staff", 4, 7);
    knife = new Knife("knife", 4, 7);
  }

  @Test
  public void getCurrentMp() {
    assertEquals("fail to get currentMp in BlackMage class", 20, bmage1.getCurrentMp());
    assertNotEquals("fail to get currentMp in BlackMage class", bmage2.getCurrentMp(), bmage3.getCurrentMp());
  }

  @Test
  public void setCurrentMp() throws InvalidStatValueException {
    bmage1.setCurrentMp(18);
    assertEquals("fail when changing currentMp in BlackMage class", 18, bmage1.getCurrentMp());
    assertEquals("fail when changing currentMp in BlackMage class", bmage1.getCurrentMp(), bmage3.getCurrentMp());
    bmage3.setCurrentMp(15);
    assertNotEquals("fail when changing currentMp in BlackMage class", bmage1.getCurrentMp(), bmage3.getCurrentMp());
  }

  @Test
  public void getMaxMp() {
    assertEquals("fail to get MaxMp in BlackMage class", 20, bmage1.getMaxMp());
    assertNotEquals("fail to get MaxMp in BlackMage class", bmage2.getMaxMp(), bmage3.getMaxMp());
  }

  @Test
  public void waitTurn() throws InterruptedException, InvalidEquippedWeapon {
    bmage1.equip(staff);
    bmage1.waitTurn();
    Thread.sleep(3000);
    assertEquals("fail to remove BlackMage from the queue", bmage1, queue.poll());
    assertNotEquals("pull something from the queue when it is empty", bmage1, queue.poll());
    assertNull("returns something other than null when queue is empty", queue.poll());
  }


  @Test
  public void getEquippedWeaponAndEquip() throws InvalidEquippedWeapon {
    bmage3.equip(staff);
    assertEquals("fail to equip weapon in BlackMage class", staff, bmage3.getEquippedWeapon());
    bmage3.equip(knife);
    assertEquals("fail to change equipped weapon in BlackMage class", knife, bmage3.getEquippedWeapon());
  }

  @Test
  public void getName() {
    assertEquals("fail to get Name in BlackMage class", "bmage", bmage1.getName());
    assertNotEquals("fail to get Name in BlackMage class", bmage2.getName(), bmage3.getName());
  }

  @Test
  public void getCurrentHp() {
    assertEquals("fail to get currentHp in BlackMage class", 15, bmage1.getCurrentHp());
    assertNotEquals("fail to get currentHp in BlackMage class", bmage2.getCurrentHp(), bmage3.getCurrentHp());
  }

  @Test
  public void getMaxHp() {
    assertEquals("fail to get MaxHp in BlackMage class", 15, bmage1.getMaxHp());
    assertNotEquals("fail to get MaxHp in BlackMage class", bmage2.getMaxHp(), bmage3.getMaxHp());
  }

  @Test
  public void getDefense() {
    assertEquals("fail to get Defense in BlackMage class", 10, bmage1.getDefense());
    assertNotEquals("fail to get Defense in BlackMage class", bmage2.getDefense(), bmage3.getDefense());
  }

  @Test
  public void setCurrentHp() throws InvalidStatValueException {
    bmage1.setCurrentHp(10);
    assertEquals("fail to change currentHp in BlackMage class", 10, bmage1.getCurrentHp());
    assertEquals("fail to change currentHp in BlackMage class", bmage1.getCurrentHp(), bmage3.getCurrentHp());
    bmage3.setCurrentHp(5);
    assertNotEquals("fail to change currentHp in BlackMage class", bmage1.getCurrentHp(), bmage3.getCurrentHp());
  }

  @Test
  public void testEquals() {
    assertTrue("equals fails with same object in BlackMage", bmage1.equals(bmage1));
    assertTrue("equals fails with equal objects in BlackMage", bmage1.equals(bmage2));
    assertFalse("equals fails with different objects in BlackMage", bmage1.equals(bmage3));
    assertFalse("equals fails with different types of characters in BlackMage", bmage2.equals(engineer));
    assertFalse("equals fails with different types of objects in BlackMage", bmage2.equals(knife));
  }

  @Test
  public void testHashCode() {
    assertEquals("hashcode fails for equal elements in BlackMage", bmage1.hashCode(), bmage2.hashCode());
    assertNotEquals("hashcode fails for distinct elements in BlackMage", bmage2.hashCode(), bmage3.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("ToString method does not work in BlackMage class",
          "BlackMage{maxMp=20, maxHp=15, defense=10, name='bmage'}", bmage2.toString());
  }
}
