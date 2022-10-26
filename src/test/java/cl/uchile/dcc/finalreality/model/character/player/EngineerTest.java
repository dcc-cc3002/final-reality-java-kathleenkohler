package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
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
  private Bow bow2;

  @Before
  public void setUp() throws Exception {
    queue = new LinkedBlockingQueue<>();
    engineer1 = new Engineer("engineer", 15, 10, queue);
    engineer2 = new Engineer("engineer", 15, 10, queue);
    engineer3 = new Engineer("engineerr", 10, 5, queue);
    bmage = new BlackMage("bmage", 15, 10, 20, queue);
    bow = new Bow("bow", 4, 7);
    bow2 = new Bow("bow2", 4, 7);
  }


  @Test
  public void waitTurn() throws InterruptedException {
    engineer1.equip(bow);
    engineer1.waitTurn();
    Thread.sleep(3000);
    assertEquals("falla sacar enemy de la queue", engineer1, queue.poll());
    assertNotEquals("saca algo de la cola cuando está vacía", engineer1, queue.poll());
    assertNull("devuelve algo distinto de null cuando queue está vacía", queue.poll());
  }

  @Test
  public void getEquippedWeaponAndEquip() {
    //excepciones con armas que no pueden ser cargadas
    engineer3.equip(bow);
    assertEquals("falla al cargar arma en clase engineer", bow, engineer3.getEquippedWeapon());
    engineer3.equip(bow2);
    assertEquals("falla al cambiar arma cargada en clase engineer", bow2, engineer3.getEquippedWeapon());
  }

  /*
      @Test
      public void addToQueue() {
      }
  */
  @Test
  public void getName() {
    assertEquals("falla al obtener nombre en clase engineer", "engineer", engineer1.getName());
    assertNotEquals("falla al obtener nombre en clase engineer", engineer2.getName(), engineer3.getName());
  }

  @Test
  public void getCurrentHp() {
    assertEquals("falla al obtener currentHp en clase engineer", 15, engineer1.getCurrentHp());
    assertNotEquals("falla al obtener currentHp en clase engineer", engineer2.getCurrentHp(), engineer3.getCurrentHp());
  }

  @Test
  public void getMaxHp() {
    assertEquals("falla al obtener maxHp en clase engineer", 15, engineer1.getMaxHp());
    assertNotEquals("falla al obtener maxHp en clase engineer", engineer2.getMaxHp(), engineer3.getMaxHp());
  }

  @Test
  public void getDefense() {
    assertEquals("falla al obtener defensa en clase engineer", 10, engineer1.getDefense());
    assertNotEquals("falla al obtener defensa en clase engineer", engineer2.getDefense(), engineer3.getDefense());
  }

  @Test
  public void setCurrentHp() throws InvalidStatValueException {
    engineer1.setCurrentHp(10);
    assertEquals("falla al cambiar currentHp en clase engineer", 10, engineer1.getCurrentHp());
    assertEquals("falla al cambiar currentHp en clase engineer", engineer1.getCurrentHp(), engineer3.getCurrentHp());
    engineer3.setCurrentHp(5);
    assertNotEquals("falla al obtener currentHp en clase thief", engineer1.getCurrentHp(), engineer3.getCurrentHp());
  }

  @Test
  public void testHashCode() {
    assertEquals("falla hashcode para elementos iguales en engineer", engineer1.hashCode(), engineer2.hashCode());
    assertNotEquals("falla hashcode para elementos distintos en engineer", engineer2.hashCode(), engineer3.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue("falla equals con mismo objeto en engineer", engineer1.equals(engineer1));
    assertTrue("falla equals con objetos iguales en engineer", engineer1.equals(engineer2));
    assertFalse("falla equals con distintos objetos en engineer", engineer1.equals(engineer3));
    assertFalse("falla equals con distintos tipos de personajes en engineer", engineer2.equals(bmage));
  }

  @Test
  public void testToString() {
    assertEquals("metodo ToString no funciona en clase engineer",
          "Engineer{maxHp=15, defense=10, name='engineer'}", engineer2.toString());
  }
}
