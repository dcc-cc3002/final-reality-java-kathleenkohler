package cl.uchile.dcc.finalreality.model.character;

public abstract class State {
  protected int magiDam;

  public State(int magiDam) {
    this.magiDam = magiDam;
  }

  public int getMagiDam() {
    return magiDam;
  }

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
