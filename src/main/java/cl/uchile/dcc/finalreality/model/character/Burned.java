package cl.uchile.dcc.finalreality.model.character;

public class Burned extends State{

  public Burned(int magiDam) {
    super(magiDam);
  }

  @Override
  public boolean isBurned() {
    return true;
  }
}
