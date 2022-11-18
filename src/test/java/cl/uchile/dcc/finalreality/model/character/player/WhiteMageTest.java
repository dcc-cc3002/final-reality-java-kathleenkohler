package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippedWeapon;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

public class WhiteMageTest {

  private WhiteMage wmage1;
  private WhiteMage wmage2;
  private WhiteMage wmage3;
  private Thief thief;
  BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
  private Staff staff;
  private Staff staff2;

  @Before
  public void setUp() throws Exception {
    wmage1 = new WhiteMage("wmage", 15, 10, 20, queue);
    wmage2 = new WhiteMage("wmage", 15, 10, 20, queue);
    wmage3 = new WhiteMage("wmagee", 10, 5, 18, queue);
    thief = new Thief("thief", 15, 10, queue);
    staff2 = new Staff("staff2", 4, 7,7);
    staff = new Staff("staff", 4, 7, 7);
  }

  @Test
  public void getCurrentMp() {
    assertEquals("fail to get currentMp in WhiteMage class", 20, wmage1.getCurrentMp());
    assertNotEquals("fail to get currentMp in WhiteMage class", wmage2.getCurrentMp(), wmage3.getCurrentMp());
  }

  @Test
  public void setCurrentMp() throws InvalidStatValueException {
    wmage1.setCurrentMp(18);
    assertEquals("fail when changing currentMp in WhiteMage class", 18, wmage1.getCurrentMp());
    assertEquals("fail when changing currentMp in WhiteMage class", wmage1.getCurrentMp(), wmage3.getCurrentMp());
    wmage3.setCurrentMp(15);
    assertNotEquals("fail when changing currentMp in WhiteMage class", wmage1.getCurrentMp(), wmage3.getCurrentMp());
  }

  @Test
  public void getMaxMp() {
    assertEquals("fail to get MaxMp in WhiteMage class", 20, wmage1.getMaxMp());
    assertNotEquals("fail to get MaxMp in WhiteMage class", wmage2.getMaxMp(), wmage3.getMaxMp());
  }

  @Test
  public void waitTurn() throws InterruptedException, InvalidEquippedWeapon {
    wmage1.equip(staff);
    wmage1.waitTurn();
    Thread.sleep(3000);
    assertEquals("fail to remove WhiteMage from the queue", wmage1, queue.poll());
    assertNotEquals("pull something from the queue when it is empty", wmage1, queue.poll());
    assertNull("returns something other than null when queue is empty", queue.poll());
  }


  @Test
  public void getEquippedWeaponAndEquip() throws InvalidEquippedWeapon {
    wmage3.equip(staff);
    assertEquals("fail to equip weapon in WhiteMage class", staff, wmage3.getEquippedWeapon());
    wmage3.equip(staff2);
    assertEquals("fail to change equipped weapon in WhiteMage class", staff2, wmage3.getEquippedWeapon());
  }

  @Test
  public void getName() {
    assertEquals("fail to get Name in WhiteMage class", "wmage", wmage1.getName());
    assertNotEquals("fail to get Name in WhiteMage class", wmage2.getName(), wmage3.getName());
  }

  @Test
  public void getCurrentHp() {
    assertEquals("fail to get currentHp in WhiteMage class", 15, wmage1.getCurrentHp());
    assertNotEquals("fail to get currentHp in WhiteMage class", wmage2.getCurrentHp(), wmage3.getCurrentHp());
  }

  @Test
  public void getMaxHp() {
    assertEquals("fail to get MaxHp in WhiteMage class", 15, wmage1.getMaxHp());
    assertNotEquals("fail to get MaxHp in WhiteMage class", wmage2.getMaxHp(), wmage3.getMaxHp());
  }

  @Test
  public void getDefense() {
    assertEquals("fail to get Defense in WhiteMage class", 10, wmage1.getDefense());
    assertNotEquals("fail to get Defense in WhiteMage class", wmage2.getDefense(), wmage3.getDefense());
  }

  @Test
  public void setCurrentHp() throws InvalidStatValueException {
    wmage1.setCurrentHp(10);
    assertEquals("fail to change currentHp in WhiteMage class", 10, wmage1.getCurrentHp());
    assertEquals("fail to change currentHp in WhiteMage class", wmage1.getCurrentHp(), wmage3.getCurrentHp());
    wmage3.setCurrentHp(5);
    assertNotEquals("fail to change currentHp in WhiteMage class", wmage1.getCurrentHp(), wmage3.getCurrentHp());
  }

  @Test
  public void testEquals() {
    assertTrue("equals fails with same object in WhiteMage", wmage1.equals(wmage1));
    assertTrue("equals fails with equal object in WhiteMage", wmage1.equals(wmage2));
    assertFalse("equals fails with different objects in WhiteMage", wmage1.equals(wmage3));
    assertFalse("equals fails with different types of characters in WhiteMage", wmage2.equals(thief));
  }

  @Test
  public void testHashCode() {
    assertEquals("hashcode fails for equal elements in WhiteMage", wmage1.hashCode(), wmage2.hashCode());
    assertNotEquals("hashcode fails for distinct elements in WhiteMage", wmage2.hashCode(), wmage3.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("ToString method does not work in WhiteMage class",
          "WhiteMage{maxMp=20, maxHp=15, defense=10, name='wmage'}", wmage2.toString());
    //WhiteMage{maxMp=20, maxHp=20, defense=10, name='whitemage'}
  }
}