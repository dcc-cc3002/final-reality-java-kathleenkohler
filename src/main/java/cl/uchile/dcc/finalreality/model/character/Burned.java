package cl.uchile.dcc.finalreality.model.character;

/**
 * A class that holds all the information of the burned state.
 */
public class Burned extends State {

  public Burned(int magiDam) {
    super(magiDam);
  }

  @Override
  public boolean isBurned() {
    return true;
  }
}
