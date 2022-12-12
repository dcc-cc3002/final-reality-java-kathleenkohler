package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ParalyzedTest {
  Enemy enemy;
  Paralyzed paralyzed;
  BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();

  @Before
  public void setUp() throws InvalidStatValueException {
    enemy = new Enemy("enemy", 20, 20, 5, 10, queue);
    paralyzed = new Paralyzed(8);
  }

  @Test
  public void testIsParalyzed() {
    enemy.setState(paralyzed);
    assertTrue(paralyzed.isParalyzed());
    assertFalse(paralyzed.isBurned());
    assertEquals(paralyzed, enemy.getState());
  }
  @Test
  public void testGetMagiDam() {
    assertEquals(8,paralyzed.getMagiDam());
  }
}
