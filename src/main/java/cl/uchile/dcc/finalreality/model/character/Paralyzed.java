package cl.uchile.dcc.finalreality.model.character;

/**
 * A class that holds all the information of the paralyzed state.
 */
public class Paralyzed extends State {


  public Paralyzed(int magiDam) {
    super(magiDam);
  }

  @Override
  public boolean isParalyzed() {
    return true;
  }
}
