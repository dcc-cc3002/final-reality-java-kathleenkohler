package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class ThiefTest {

  private Thief thief1;
  private Thief thief2;
  private Thief thief3;
  private WhiteMage wmage;
  BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
  private Staff staff;
  private Staff staff2;

  @Before
  public void setUp() throws Exception {
    thief1 = new Thief("thief", 15, 10, queue);
    thief2 = new Thief("thief", 15, 10, queue);
    thief3 = new Thief("thieff", 10, 5, queue);
    wmage = new WhiteMage("wmage", 15, 10, 20, queue);
    staff = new Staff("staff", 4, 7);
    staff2 = new Staff("staff2", 4, 7);
  }

  /*
    @Test
    public void waitTurn() {
    }

    @Test
    public void equip() {
    }
  */
  @Test
  public void getEquippedWeapon() {
    //excepciones con armas que no pueden ser cargadas
    thief3.equip(staff);
    assertEquals("falla al cargar arma en clase thief", staff, thief3.getEquippedWeapon());
    thief3.equip(staff2);
    assertEquals("falla al cambiar arma cargada en clase thief", staff2, thief3.getEquippedWeapon());
  }

  /*
      @Test
      public void addToQueue() {
      }
  */
  @Test
  public void getName() {
    assertEquals("falla al obtener nombre en clase thief", "thief", thief1.getName());
    assertNotEquals("falla al obtener nombre en clase thief", thief2.getName(), thief3.getName());
  }

  @Test
  public void getCurrentHp() {
    assertEquals("falla al obtener currentHp en clase thief", 15, thief1.getCurrentHp());
    assertNotEquals("falla al obtener currentHp en clase thief", thief2.getCurrentHp(), thief3.getCurrentHp());
  }

  @Test
  public void getMaxHp() {
    assertEquals("falla al obtener maxHp en clase thief", 15, thief1.getMaxHp());
    assertNotEquals("falla al obtener maxHp en clase thief", thief2.getMaxHp(), thief3.getMaxHp());
  }

  @Test
  public void getDefense() {
    assertEquals("falla al obtener defensa en clase thief", 10, thief1.getDefense());
    assertNotEquals("falla al obtener defensa en clase thief", thief2.getDefense(), thief3.getDefense());
  }

  @Test
  public void setCurrentHp() throws InvalidStatValueException {
    thief1.setCurrentHp(10);
    assertEquals("falla al cambiar currentHp en clase thief", 10, thief1.getCurrentHp());
    assertEquals("falla al cambiar currentHp en clase thief", thief1.getCurrentHp(), thief3.getCurrentHp());
    thief3.setCurrentHp(5);
    assertNotEquals("falla al obtener currentHp en clase thief", thief1.getCurrentHp(), thief3.getCurrentHp());
  }

  @Test
  public void testHashCode() {
    assertEquals("falla hashcode para elementos iguales en thief", thief1.hashCode(), thief2.hashCode());
    assertNotEquals("falla hashcode para elementos distintos en thief", thief2.hashCode(), thief3.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue("falla equals con mismo objeto en thief", thief1.equals(thief1));
    assertTrue("falla equals con objetos iguales en thief", thief1.equals(thief2));
    assertFalse("falla equals con distintos objetos en thief", thief1.equals(thief3));
    assertFalse("falla equals con distintos tipos de personajes en thief", thief2.equals(wmage));
  }

  @Test
  public void testToString() {
    assertEquals("metodo ToString no funciona en clase thief",
          "Thief{maxHp=15, defense=10, name='thief'}", thief2.toString());
  }
}