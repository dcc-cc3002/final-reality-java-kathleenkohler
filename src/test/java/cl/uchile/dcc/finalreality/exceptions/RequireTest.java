package cl.uchile.dcc.finalreality.exceptions;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

public class RequireTest {
  private Knight knight1;
  BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();

  @Before
  public void setUp() throws Exception {
    knight1 = new Knight("knight", 15, 10, queue);
  }

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  @Test
  public void statValueAtLeast() throws InvalidStatValueException {
    exceptionRule.expect(InvalidStatValueException.class);
    exceptionRule.expectMessage("The provided value is not a valid stat value. 'Current HP'(-2) must be at least 0");
    knight1.setCurrentHp(-2);
  }

  @Test
  public void statValueAtMost() throws InvalidStatValueException {
    exceptionRule.expect(InvalidStatValueException.class);
    exceptionRule.expectMessage("The provided value is not a valid stat value. 'Current HP'(20) must be at most 15");
    knight1.setCurrentHp(20);
  }
}