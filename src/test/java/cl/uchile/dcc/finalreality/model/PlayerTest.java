package cl.uchile.dcc.finalreality.model;

import cl.uchile.dcc.finalreality.Player;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.Assert.assertEquals;

public class PlayerTest {
  private BlackMage bmage;
  private WhiteMage wmage;
  private Knight knight;
  private Thief thief;
  BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();

  @Before
  public void setUp() throws InvalidStatValueException {
    bmage = new BlackMage("bmage", 15, 10, 20, queue);
    wmage = new WhiteMage("wmage", 15, 10, 40, queue);
    knight = new Knight("knight", 15, 10, queue);
    thief = new Thief("thief", 15, 10, queue);
  }
  @Test
  public void testSetInventory() throws InvalidStatValueException {
    Player player = new Player(bmage, wmage, knight, thief);
    player.setInventory();
    assertEquals()
  }

}
