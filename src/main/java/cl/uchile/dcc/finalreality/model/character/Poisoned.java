package cl.uchile.dcc.finalreality.model.character;

public class Poisoned extends State{

  public Poisoned(int magiDam) {
    super(magiDam);
  }

  @Override
  public boolean isPoisoned() {
    return true;
  }
}
