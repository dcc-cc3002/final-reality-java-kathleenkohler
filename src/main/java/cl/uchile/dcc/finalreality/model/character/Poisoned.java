package cl.uchile.dcc.finalreality.model.character;

/**
 * A class that holds all the information of the poisoned state.
 */
public class Poisoned extends State {

  public Poisoned(int magiDam) {
    super(magiDam);
  }

  @Override
  public boolean isPoisoned() {
    return true;
  }
}
