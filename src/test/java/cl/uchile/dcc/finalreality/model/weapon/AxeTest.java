package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippedWeapon;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
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
    assertEquals("falla getName en axe","axe", axe1.getName());
    assertNotEquals("falla getName en axe",axe2.getName(), axe3.getName());
  }

  @Test
  public void testGetDamage() {
    assertEquals("falla getDamage en axe",4, axe2.getDamage());
    assertNotEquals("falla getDamage en axe",axe2.getDamage(), axe3.getDamage());
  }

  @Test
  public void testGetWeight() {
    assertEquals("falla getWeight en axe", 8, axe3.getWeight());
    assertNotEquals("falla getWeight en axe",7, axe3.getWeight());
  }

  @Test
  public void testEquals() {
    assertTrue("falla equals con mismo objeto en axe", axe1.equals(axe1));
    assertFalse("falla equals con distintos objetos en axe", axe1.equals(axe3));
    assertFalse("falla equals con distintos tipos de arma en axe", axe2.equals(bow));
    assertFalse("falla equals con distintos objetos en axe", axe1.equals(null));
  }

  @Test
  public void testHashCode() {
    assertEquals("falla hashcode para elementos iguales en axe", axe1.hashCode(), axe2.hashCode());
    assertNotEquals("falla hashcode para elementos distintos en axe", axe2.hashCode(), axe3.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("metodo ToString no funciona en clase axe",
            "Axe{name='axe', damage=4, weight=7}", axe2.toString());
  }

  @Test
  public void testEquipEngineer() throws InvalidStatValueException, InvalidEquippedWeapon {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    Engineer engineer = new Engineer("engineer", 4, 7, queue);
    engineer.equip(axe1);
    assertEquals("no se equipó arma que debió ser equipada", axe1, engineer.getEquippedWeapon());
    assertNotEquals("no se equipó arma que debió ser equipada", null, engineer.getEquippedWeapon());
  }

  @Test
  public void testEquipKnight() throws InvalidStatValueException, InvalidEquippedWeapon {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    Knight knight = new Knight("knight", 4, 7, queue);
    knight.equip(axe1);
    assertEquals("no se equipó arma que debió ser equipada", axe1, knight.getEquippedWeapon());
    assertNotEquals("no se equipó arma que debió ser equipada", null, knight.getEquippedWeapon());
  }

}
