package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.model.character.Enemy;

public class State {

  protected Enemy enemy;

  public boolean isPoisoned() {
    return false;
  }

  public boolean isBurned() {
    return false;
  }

  public boolean isParalyzed() {
    return false;
  }

}
