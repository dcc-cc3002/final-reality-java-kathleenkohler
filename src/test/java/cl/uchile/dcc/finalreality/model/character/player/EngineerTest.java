package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippedWeapon;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

public class EngineerTest {
  private Engineer engineer1;
  private Engineer engineer2;
  private Engineer engineer3;
  private BlackMage bmage;
  BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
  private Bow bow;
  private Axe axe;

  @Before
  public void setUp() throws Exception {
    queue = new LinkedBlockingQueue<>();
    engineer1 = new Engineer("engineer", 15, 10, queue);
    engineer2 = new Engineer("engineer", 15, 10, queue);
    engineer3 = new Engineer("engineerr", 10, 5, queue);
    bmage = new BlackMage("bmage", 15, 10, 20, queue);
    bow = new Bow("bow", 4, 7);
    axe = new Axe("axe", 4, 7);
  }


  @Test
  public void waitTurn() throws InterruptedException, InvalidEquippedWeapon {
    engineer1.equip(bow);
    engineer1.waitTurn();
    Thread.sleep(3000);
    assertEquals("fail to remove Engineer from the queue", engineer1, queue.poll());
    assertNotEquals("pull something from the queue when it is empty", engineer1, queue.poll());
    assertNull("returns something other than null when queue is empty", queue.poll());
  }

  @Test
  public void getEquippedWeaponAndEquip() throws InvalidEquippedWeapon {
    engineer3.equip(bow);
    assertEquals("fail to equip weapon in Engineer class", bow, engineer3.getEquippedWeapon());
    engineer3.equip(axe);
    assertEquals("fail to change equipped weapon in Engineer class", axe, engineer3.getEquippedWeapon());
  }

  @Test
  public void getName() {
    assertEquals("fail to get Name in Engineer class", "engineer", engineer1.getName());
    assertNotEquals("fail to get Name in Engineer class", engineer2.getName(), engineer3.getName());
  }

  @Test
  public void getCurrentHp() {
    assertEquals("fail to get currentHp in Engineer class", 15, engineer1.getCurrentHp());
    assertNotEquals("fail to get currentHp in Engineer class", engineer2.getCurrentHp(), engineer3.getCurrentHp());
  }

  @Test
  public void getMaxHp() {
    assertEquals("fail to get MaxHp in Engineer class", 15, engineer1.getMaxHp());
    assertNotEquals("fail to get MaxHp in Engineer class", engineer2.getMaxHp(), engineer3.getMaxHp());
  }

  @Test
  public void getDefense() {
    assertEquals("fail to get Defense in Engineer class", 10, engineer1.getDefense());
    assertNotEquals("fail to get Defense in Engineer class", engineer2.getDefense(), engineer3.getDefense());
  }

  @Test
  public void setCurrentHp() throws InvalidStatValueException {
    engineer1.setCurrentHp(10);
    assertEquals("fail to change currentHp in Engineer class", 10, engineer1.getCurrentHp());
    assertEquals("fail to change currentHp in Engineer class", engineer1.getCurrentHp(), engineer3.getCurrentHp());
    engineer3.setCurrentHp(5);
    assertNotEquals("fail to change currentHp in Engineer class", engineer1.getCurrentHp(), engineer3.getCurrentHp());
  }

  @Test
  public void testHashCode() {
    assertEquals("hashcode fails for equal elements in Engineer", engineer1.hashCode(), engineer2.hashCode());
    assertNotEquals("hashcode fails for distinct elements in Engineer", engineer2.hashCode(), engineer3.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue("equals fails with same object in Engineer", engineer1.equals(engineer1));
    assertTrue("equals fails with equal object in Engineer", engineer1.equals(engineer2));
    assertFalse("equals fails with different objects in Engineer", engineer1.equals(engineer3));
    assertFalse("equals fails with different types of characters in Engineer", engineer2.equals(bmage));
  }

  @Test
  public void testToString() {
    assertEquals("ToString method does not work in Engineer class",
          "Engineer{currentHp=15, defense=10, name='engineer'}", engineer2.toString());
  }
}
