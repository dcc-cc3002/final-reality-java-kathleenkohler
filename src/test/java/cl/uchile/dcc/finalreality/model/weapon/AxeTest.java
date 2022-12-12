package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippedWeapon;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class AxeTest {
  private Axe axe1;
  private Axe axe2;
  private Axe axe3;
  private Bow bow;

  @Before
  public void setUp() throws Exception{
    axe1 = new Axe("axe", 4,7);
    axe2 = new Axe("axe", 4,7);
    axe3 = new Axe("axee", 6,8);
    bow = new Bow("bow", 4 ,7);
  }

  @Test
  public void testGetName() {
    assertEquals("fail to get Name in Axe class","axe", axe1.getName());
    assertNotEquals("fail to get Name in Axe class",axe2.getName(), axe3.getName());
  }

  @Test
  public void testGetDamage() {
    assertEquals("fail to get Damage in Axe class",4, axe2.getDamage());
    assertNotEquals("fail to get Damage in Axe class",axe2.getDamage(), axe3.getDamage());
  }

  @Test
  public void testGetWeight() {
    assertEquals("fail to get Weight in Axe class", 8, axe3.getWeight());
    assertNotEquals("fail to get Weight in Axe class",7, axe3.getWeight());
  }

  @Test
  public void testEquals() {
    assertTrue("equals fails with equal object in Axe", axe1.equals(axe1));
    assertFalse("equals fails with different objects in Axe", axe1.equals(axe3));
    assertFalse("equals fails with different types of weapon in Axe", axe2.equals(bow));
    assertFalse("equals fails with different objects in Axe", axe1.equals(null));
  }

  @Test
  public void testHashCode() {
    assertEquals("hashcode fails for equal elements in Axe", axe1.hashCode(), axe2.hashCode());
    assertNotEquals("hashcode fails for distinct elements in Axe", axe2.hashCode(), axe3.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("ToString method does not work in Axe class",
            "Axe{name='axe', damage=4, weight=7}", axe2.toString());
  }

  @Test
  public void testEquipEngineer() throws InvalidStatValueException, InvalidEquippedWeapon {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    Engineer engineer = new Engineer("engineer", 4, 7, queue);
    engineer.equip(axe1);
    assertEquals("weapon that should have been equipped was not equipped in Axe class",
          axe1, engineer.getEquippedWeapon());
    assertNotEquals("weapon that should have been equipped was not equipped in Axe class",
          null, engineer.getEquippedWeapon());
  }

  @Test
  public void testEquipKnight() throws InvalidStatValueException, InvalidEquippedWeapon {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    Knight knight = new Knight("knight", 4, 7, queue);
    knight.equip(axe1);
    assertEquals("weapon that should have been equipped was not equipped in Axe class",
          axe1, knight.getEquippedWeapon());
    assertNotEquals("weapon that should have been equipped was not equipped in Axe class",
          null, knight.getEquippedWeapon());
  }
}
