package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippedWeapon;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import java.io.IOException;

public class GameDriver {

  public static void main(String args[]) throws InvalidStatValueException, IOException,
        InvalidEquippedWeapon {
    Game game = new Game();
    playGame(game);
  }

  public static void playGame(Game game) throws InvalidStatValueException, IOException,
        InvalidEquippedWeapon {
    game.startGame();
    game.loop();


  }


}
