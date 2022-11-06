package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

public class KnightTest {
  private Knight knight1;
  private Knight knight2;
  private Knight knight3;
  private WhiteMage wmage;
  BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
  private Knife knife;
  private Staff staff;

  @Before
  public void setUp() throws Exception {
    knight1 = new Knight("knight", 15, 10, queue);
    knight2 = new Knight("knight", 15, 10, queue);
    knight3 = new Knight("knightt", 10, 5, queue);
    wmage = new WhiteMage("wmage", 15, 10, 20, queue);
    knife = new Knife("knife", 4, 7);
    staff = new Staff("staff", 4, 7);
  }

  @Test
  public void waitTurn() throws InterruptedException {
    knight1.equip(knife);
    knight1.waitTurn();
    Thread.sleep(3000);
    assertEquals("falla sacar enemy de la queue", knight1, queue.poll());
    assertNotEquals("saca algo de la cola cuando está vacía", knight1, queue.poll());
    assertNull("devuelve algo distinto de null cuando queue está vacía", queue.poll());
  }

  @Test
  public void getEquippedWeaponAndEquip() {
    //excepciones con armas que no pueden ser cargadas
    knight3.equip(knife);
    assertEquals("falla al cargar arma en clase knight", knife, knight3.getEquippedWeapon());
    knight3.equip(staff);
    assertNotEquals("falla al cambiar arma cargada en clase knight", staff, knight3.getEquippedWeapon());
  }

  @Test
  public void getName() {
    assertEquals("falla al obtener nombre en clase knight", "knight", knight1.getName());
    assertNotEquals("falla al obtener nombre en clase knight", knight2.getName(), knight3.getName());
  }

  @Test
  public void getCurrentHp() {
    assertEquals("falla al obtener currentHp en clase knight", 15, knight1.getCurrentHp());
    assertNotEquals("falla al obtener currentHp en clase knight", knight2.getCurrentHp(), knight3.getCurrentHp());
  }

  @Test
  public void getMaxHp() {
    assertEquals("falla al obtener maxHp en clase knight", 15, knight1.getMaxHp());
    assertNotEquals("falla al obtener maxHp en clase knight", knight2.getMaxHp(), knight3.getMaxHp());
  }

  @Test
  public void getDefense() {
    assertEquals("falla al obtener defensa en clase knight", 10, knight1.getDefense());
    assertNotEquals("falla al obtener defensa en clase knight", knight2.getDefense(), knight3.getDefense());
  }

  @Test
  public void setCurrentHp() throws InvalidStatValueException {
    knight1.setCurrentHp(10);
    assertEquals("falla al cambiar currentHp en clase knight", 10, knight1.getCurrentHp());
    assertEquals("falla al cambiar currentHp en clase knight", knight1.getCurrentHp(), knight3.getCurrentHp());
    knight3.setCurrentHp(5);
    assertNotEquals("falla al obtener currentHp en clase knight", knight1.getCurrentHp(), knight3.getCurrentHp());
  }

  @Test
  public void testHashCode() {
    assertEquals("falla hashcode para elementos iguales en knight", knight1.hashCode(), knight2.hashCode());
    assertNotEquals("falla hashcode para elementos distintos en knight", knight2.hashCode(), knight3.hashCode());
  }

  @Test
  public void testEquals() {
    assertTrue("falla equals con mismo objeto en knight", knight1.equals(knight1));
    assertTrue("falla equals con objetos iguales en knight", knight1.equals(knight2));
    assertFalse("falla equals con distintos objetos en knight", knight1.equals(knight3));
    assertFalse("falla equals con distintos tipos de personajes en knight", knight2.equals(wmage));
  }

  @Test
  public void testToString() {
    assertEquals("metodo ToString no funciona en clase knight",
          "Knight{maxHp=15, defense=10, name='knight'}", knight2.toString());
  }
}
