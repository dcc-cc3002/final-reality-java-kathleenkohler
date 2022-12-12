package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

public class PoisonTest {
  Enemy enemy;
  Poisoned poisoned;
  BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();

  @Before
  public void setUp() throws InvalidStatValueException {
    enemy = new Enemy("enemy", 20, 20, 5, 10, queue);
    poisoned = new Poisoned(8);
  }

  @Test
  public void testIsBurned() {
    enemy.setState(poisoned);
    assertTrue(poisoned.isPoisoned());
    assertFalse(poisoned.isBurned());
    assertEquals(poisoned, enemy.getState());
  }
  @Test
  public void testGetMagiDam() {
    assertEquals(8,poisoned.getMagiDam());
  }
}
