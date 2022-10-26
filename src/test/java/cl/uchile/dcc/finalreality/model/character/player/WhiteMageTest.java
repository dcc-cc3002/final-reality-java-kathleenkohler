package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
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
  private Sword sword;
  private Sword sword2;

  @Before
  public void setUp() throws Exception {
    wmage1 = new WhiteMage("wmage", 15, 10, 20, queue);
    wmage2 = new WhiteMage("wmage", 15, 10, 20, queue);
    wmage3 = new WhiteMage("wmagee", 10, 5, 18, queue);
    thief = new Thief("thief", 15, 10, queue);
    sword = new Sword("sword", 4, 7);
    sword2 = new Sword("sword2", 4, 7);
  }

  @Test
  public void getCurrentMp() {
    assertEquals("falla al obtener currentHp en clase wmage", 20, wmage1.getCurrentMp());
    assertNotEquals("falla al obtener currentHp en clase wmage", wmage2.getCurrentMp(), wmage3.getCurrentMp());
  }

  @Test
  public void setCurrentMp() throws InvalidStatValueException {
    wmage1.setCurrentMp(18);
    assertEquals("falla al cambiar currentMp en clase wmage", 18, wmage1.getCurrentMp());
    assertEquals("falla al cambiar currentMp en clase wmage", wmage1.getCurrentMp(), wmage3.getCurrentMp());
    wmage3.setCurrentMp(15);
    assertNotEquals("falla al obtener currentMp en clase wmage", wmage1.getCurrentMp(), wmage3.getCurrentMp());
  }

  @Test
  public void getMaxMp() {
    assertEquals("falla al obtener maxMp en clase wmage", 20, wmage1.getMaxMp());
    assertNotEquals("falla al obtener maxMp en clase wmage", wmage2.getMaxMp(), wmage3.getMaxMp());
  }

  @Test
  public void waitTurn() throws InterruptedException {
    wmage1.equip(sword);
    wmage1.waitTurn();
    Thread.sleep(3000);
    assertEquals("falla sacar enemy de la queue", wmage1, queue.poll());
    assertNotEquals("saca algo de la cola cuando está vacía", wmage1, queue.poll());
    assertNull("devuelve algo distinto de null cuando queue está vacía", queue.poll());
  }


  @Test
  public void getEquippedWeaponAndEquip() {
    wmage3.equip(sword);
    assertEquals("falla al cargar arma en clase wmage", sword, wmage3.getEquippedWeapon());
    wmage3.equip(sword2);
    assertEquals("falla al cambiar arma cargada en clase wmage", sword2, wmage3.getEquippedWeapon());
  }
/*
  @Test
  public void addToQueue() {
  }

 */

  @Test
  public void getName() {
    assertEquals("falla al obtener nombre en clase wmage", "wmage", wmage1.getName());
    assertNotEquals("falla al obtener nombre en clase wmage", wmage2.getName(), wmage3.getName());
  }

  @Test
  public void getCurrentHp() {
    assertEquals("falla al obtener currentHp en clase wmage", 15, wmage1.getCurrentHp());
    assertNotEquals("falla al obtener currentHp en clase wmage", wmage2.getCurrentHp(), wmage3.getCurrentHp());
  }

  @Test
  public void getMaxHp() {
    assertEquals("falla al obtener maxHp en clase wmage", 15, wmage1.getMaxHp());
    assertNotEquals("falla al obtener maxHp en clase wmage", wmage2.getMaxHp(), wmage3.getMaxHp());
  }

  @Test
  public void getDefense() {
    assertEquals("falla al obtener defensa en clase wmage", 10, wmage1.getDefense());
    assertNotEquals("falla al obtener defensa en clase wmage", wmage2.getDefense(), wmage3.getDefense());
  }

  @Test
  public void setCurrentHp() throws InvalidStatValueException {
    wmage1.setCurrentHp(10);
    assertEquals("falla al cambiar currentHp en clase wmage", 10, wmage1.getCurrentHp());
    assertEquals("falla al cambiar currentHp en clase wmage", wmage1.getCurrentHp(), wmage3.getCurrentHp());
    wmage3.setCurrentHp(5);
    assertNotEquals("falla al obtener currentHp en clase wmage", wmage1.getCurrentHp(), wmage3.getCurrentHp());
  }

  @Test
  public void testEquals() {
    assertTrue("falla equals con mismo objeto en wmage", wmage1.equals(wmage1));
    assertTrue("falla equals con objetos iguales en wmage", wmage1.equals(wmage2));
    assertFalse("falla equals con distintos objetos en wmage", wmage1.equals(wmage3));
    assertFalse("falla equals con distintos tipos de personajes en wmage", wmage2.equals(thief));
  }

  @Test
  public void testHashCode() {
    assertEquals("falla hashcode para elementos iguales en wmage", wmage1.hashCode(), wmage2.hashCode());
    assertNotEquals("falla hashcode para elementos distintos en wmage", wmage2.hashCode(), wmage3.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("metodo ToString no funciona en clase wmage",
          "WhiteMage{maxMp=20, maxHp=15, defense=10, name='wmage'}", wmage2.toString());
    //WhiteMage{maxMp=20, maxHp=20, defense=10, name='whitemage'}
  }
}