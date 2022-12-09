package cl.uchile.dcc.finalreality.model;

import cl.uchile.dcc.finalreality.Player;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
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
  private Axe axe;
  private Sword sword;
  BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();

  @Before
  public void setUp() throws InvalidStatValueException {
    bmage = new BlackMage("bmage", 15, 10, 20, queue);
    wmage = new WhiteMage("wmage", 15, 10, 40, queue);
    knight = new Knight("knight", 15, 10, queue);
    thief = new Thief("thief", 15, 10, queue);
    axe = new Axe("Axe", 30, 30);
    sword = new Sword("Sword", 25, 30);
  }
  @Test
  public void testSetInventory() throws InvalidStatValueException {
    Player player = new Player(bmage, wmage, knight, thief);
    player.setInventory();
    assertEquals(axe, player.inventory.get(0));
    assertEquals(sword, player.inventory.get(5));
  }

}
