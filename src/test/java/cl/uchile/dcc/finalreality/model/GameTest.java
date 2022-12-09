package cl.uchile.dcc.finalreality.model;

import cl.uchile.dcc.finalreality.Game;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.Assert.assertEquals;

public class GameTest {
  Game game = new Game();
  private BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
  @Test
  public void testSetCharacterInventory() throws InvalidStatValueException {
    game.setChracterInventory();
    BlackMage blackMage1 = new BlackMage("BlackMage1", 70, 15, 40, queue);
    WhiteMage whiteMage1 = new WhiteMage("WhiteMage1", 75, 18, 45, queue);
    Thief thief1 = new Thief("Thief1", 100, 10, queue);
    Knight knight1 = new Knight("Knight1", 85, 15, queue);
    assertEquals(blackMage1, game.characterInventory.get(0));
    assertEquals(whiteMage1, game.characterInventory.get(2));
    assertEquals(thief1, game.characterInventory.get(4));
    assertEquals(knight1, game.characterInventory.get(6));
  }
  @Test
  public void testEnemiess() throws InvalidStatValueException {
    game.enemiess(3);
    assertEquals(3, game.enemies.size());
  }
  //swap turn

  //game over
}
