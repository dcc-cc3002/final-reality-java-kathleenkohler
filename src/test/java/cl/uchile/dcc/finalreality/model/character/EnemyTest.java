package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

public class EnemyTest {

  private Enemy enemy1;
  private Enemy enemy2;
  private Enemy enemy3;
  private Thief thief;
  private Thief thief2;
  private Burned burned;
  private Poisoned poisoned;
  private Paralyzed paralyzed;
  BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();


  @Before
  public void setUp() throws Exception {
    queue = new LinkedBlockingQueue<>();
    enemy1 = new Enemy("enemy", 20, 15, 10, 20,queue);
    enemy2 = new Enemy("enemy", 20, 15, 10, 20, queue);
    enemy3 = new Enemy("enemyy", 25, 10, 15, 20, queue);
    thief = new Thief("thief", 35, 10, queue);
    thief2 = new Thief("thief", 7, 10, queue);
    burned = new Burned(7);
    paralyzed = new Paralyzed(8);
    poisoned = new Poisoned(6);
  }

  @Test
  public void getName() {
    assertEquals("falla al obtener nombre en clase enemy", "enemy", enemy1.getName());
    assertNotEquals("falla al obtener nombre en clase enemy", enemy2.getName(), enemy3.getName());
  }

  @Test
  public void getCurrentHp() {
    assertEquals("falla al obtener currentHp en clase enemy", 15, enemy1.getCurrentHp());
    assertNotEquals("falla al obtener currentHp en clase enemy", enemy2.getCurrentHp(), enemy3.getCurrentHp());
  }

  @Test
  public void getMaxHp() {
    assertEquals("falla al obtener maxHp en clase enemy", 15, enemy1.getMaxHp());
    assertNotEquals("falla al obtener maxHp en clase enemy", enemy2.getMaxHp(), enemy3.getMaxHp());
  }

  @Test
  public void getDefense() {
    assertEquals("falla al obtener defensa en clase enemy", 10, enemy1.getDefense());
    assertNotEquals("falla al obtener defensa en clase enemy", enemy2.getDefense(), enemy3.getDefense());
  }

  @Test
  public void setCurrentHp() throws InvalidStatValueException {
    enemy1.setCurrentHp(10);
    assertEquals("falla al cambiar currentHp en clase enemy", 10, enemy1.getCurrentHp());
    assertEquals("falla al cambiar currentHp en clase enemy", enemy1.getCurrentHp(), enemy3.getCurrentHp());
    enemy3.setCurrentHp(5);
    assertNotEquals("falla al obtener currentHp en clase enemy", enemy1.getCurrentHp(), enemy3.getCurrentHp());
    //assertThrows("a",ThrowingRunnable, enemy1.setCurrentHp(30));
    //assertEquals("a", enemy1.setCurrentHp(30), InvalidStatValueException);
  }


  @Test
  public void waitTurn() throws InterruptedException {
    enemy1.waitTurn();
    Thread.sleep(3000);
    assertEquals("falla sacar enemy de la queue", enemy1, queue.poll());
    assertNotEquals("saca algo de la cola cuando está vacía", enemy1, queue.poll());
    assertNull("devuelve algo distinto de null cuando queue está vacía", queue.poll());
  }
  @Test
  public void getWeight() {
    assertEquals("falla al obtener peso en clase enemy", 20, enemy1.getWeight());
    assertNotEquals("falla al obtener peso en clase enemy", enemy2.getWeight(), enemy3.getWeight());
  }

  @Test
  public void testToString() {
    assertEquals("metodo ToString no funciona en clase enemy",
          "Enemy{name='enemy', weight=20, currentHp=15, defense=10, damage=20}", enemy2.toString());
  }

  @Test
  public void testEquals() {
    assertTrue("falla equals con mismo objeto en enemy", enemy1.equals(enemy1));
    assertTrue("falla equals con objetos iguales en wmage", enemy1.equals(enemy2));
    assertFalse("falla equals con distintos objetos en enemy", enemy1.equals(enemy3));
    assertFalse("falla equals con distintos tipos de personajes en enemy", enemy2.equals(thief));
  }

  @Test
  public void testHashCode() {
    assertEquals("falla hashcode para elementos iguales en enemy", enemy1.hashCode(), enemy2.hashCode());
    assertNotEquals("falla hashcode para elementos distintos en enemy", enemy2.hashCode(), enemy3.hashCode());
  }

  @Test
  public void testGetStateAndSetState() {
    enemy1.setState(burned);
    assertEquals(burned, enemy1.getState());
    assertNotEquals(poisoned, enemy1.getState());
  }

  @Test
  public void testIsPoisoned() {
    enemy1.setState(burned);
    assertFalse(enemy1.isPoisoned());
    enemy1.setState(poisoned);
    assertTrue(enemy1.isPoisoned());
  }
  @Test
  public void testIsBurned() {
    enemy1.setState(burned);
    assertTrue(enemy1.isBurned());
    enemy1.setState(poisoned);
    assertFalse(enemy1.isBurned());
  }
  @Test
  public void testIsParalyzed() {
    enemy1.setState(burned);
    assertFalse(enemy1.isParalyzed());
    enemy1.setState(paralyzed);
    assertTrue(enemy1.isParalyzed());
  }
  @Test
  public void testAttack() throws InvalidStatValueException {
    enemy1.attack(thief);
    assertEquals(25, thief.getCurrentHp());
    enemy1.attack(thief2);
    assertEquals(0, thief2.getCurrentHp());
  }

}