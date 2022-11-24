package cl.uchile.dcc.finalreality.model.character;

public class Paralyzed extends State{


  public Paralyzed(int magiDam) {
    super(magiDam);
  }

  @Override
  public boolean isParalyzed() {
    return true;
  }
}
