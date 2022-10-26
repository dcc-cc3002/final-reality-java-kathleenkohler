package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
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
  private Axe axe;
  private Axe axe2;

  @Before
  public void setUp() throws Exception {
    queue = new LinkedBlockingQueue<>();
    bmage1 = new BlackMage("bmage", 15, 10, 20, queue);
    bmage2 = new BlackMage("bmage", 15, 10, 20, queue);
    bmage3 = new BlackMage("bmagee", 10, 5, 18, queue);
    engineer = new Engineer("engineer", 15, 10, queue);
    axe = new Axe("axe", 4, 7);
    axe2 = new Axe("axe2", 4, 7);
  }

  @Test
  public void getCurrentMp() {
    assertEquals("falla al obtener currentHp en clase bmage", 20, bmage1.getCurrentMp());
    assertNotEquals("falla al obtener currentHp en clase bmage", bmage2.getCurrentMp(), bmage3.getCurrentMp());
  }

  @Test
  public void setCurrentMp() throws InvalidStatValueException {
    bmage1.setCurrentMp(18);
    assertEquals("falla al cambiar currentMp en clase bmage", 18, bmage1.getCurrentMp());
    assertEquals("falla al cambiar currentMp en clase bmage", bmage1.getCurrentMp(), bmage3.getCurrentMp());
    bmage3.setCurrentMp(15);
    assertNotEquals("falla al obtener currentMp en clase bmage", bmage1.getCurrentMp(), bmage3.getCurrentMp());
  }

  @Test
  public void getMaxMp() {
    assertEquals("falla al obtener maxMp en clase bmage", 20, bmage1.getMaxMp());
    assertNotEquals("falla al obtener maxMp en clase bmage", bmage2.getMaxMp(), bmage3.getMaxMp());
  }

  @Test
  public void waitTurn() throws InterruptedException {
    bmage1.equip(axe);
    bmage1.waitTurn();
    Thread.sleep(3000);
    assertEquals("falla sacar enemy de la queue", bmage1, queue.poll());
    assertNotEquals("saca algo de la cola cuando está vacía", bmage1, queue.poll());
    assertNull("devuelve algo distinto de null cuando queue está vacía", queue.poll());
  }


  @Test
  public void getEquippedWeaponAndEquip() {
    bmage3.equip(axe);
    assertEquals("falla al cargar arma en clase bmage", axe, bmage3.getEquippedWeapon());
    bmage3.equip(axe2);
    assertEquals("falla al cambiar arma cargada en clase bmage", axe2, bmage3.getEquippedWeapon());
  }
/*
  @Test
  public void addToQueue() {
  //excepcion
  }

 */

  @Test
  public void getName() {
    assertEquals("falla al obtener nombre en clase bmage", "bmage", bmage1.getName());
    assertNotEquals("falla al obtener nombre en clase bmage", bmage2.getName(), bmage3.getName());
  }

  @Test
  public void getCurrentHp() {
    assertEquals("falla al obtener currentHp en clase bmage", 15, bmage1.getCurrentHp());
    assertNotEquals("falla al obtener currentHp en clase bmage", bmage2.getCurrentHp(), bmage3.getCurrentHp());
  }

  @Test
  public void getMaxHp() {
    assertEquals("falla al obtener maxHp en clase bmage", 15, bmage1.getMaxHp());
    assertNotEquals("falla al obtener maxHp en clase bmage", bmage2.getMaxHp(), bmage3.getMaxHp());
  }

  @Test
  public void getDefense() {
    assertEquals("falla al obtener defensa en clase bmage", 10, bmage1.getDefense());
    assertNotEquals("falla al obtener defensa en clase bmage", bmage2.getDefense(), bmage3.getDefense());
  }

  @Test
  public void setCurrentHp() throws InvalidStatValueException {
    bmage1.setCurrentHp(10);
    assertEquals("falla al cambiar currentHp en clase bmage", 10, bmage1.getCurrentHp());
    assertEquals("falla al cambiar currentHp en clase bmage", bmage1.getCurrentHp(), bmage3.getCurrentHp());
    bmage3.setCurrentHp(5);
    assertNotEquals("falla al obtener currentHp en clase bmage", bmage1.getCurrentHp(), bmage3.getCurrentHp());
  }

  @Test
  public void testEquals() {
    assertTrue("falla equals con mismo objeto en bmage", bmage1.equals(bmage1));
    assertTrue("falla equals con objetos iguales en bmage", bmage1.equals(bmage2));
    assertFalse("falla equals con distintos objetos en bmage", bmage1.equals(bmage3));
    assertFalse("falla equals con distintos tipos de personajes en bmage", bmage2.equals(engineer));
    assertFalse("falla equals con distintos tipos de personajes en bmage", bmage2.equals(axe));
  }

  @Test
  public void testHashCode() {
    assertEquals("falla hashcode para elementos iguales en bmage", bmage1.hashCode(), bmage2.hashCode());
    assertNotEquals("falla hashcode para elementos distintos en bmage", bmage2.hashCode(), bmage3.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("metodo ToString no funciona en clase bmage",
          "BlackMage{maxMp=20, maxHp=15, defense=10, name='bmage'}", bmage2.toString());
  }
}
