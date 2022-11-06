package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippedWeapon;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.player.*;

/**
 * An abstract class that holds all the information of a weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Kathleen Kohler~
 */
public abstract class Weapon implements GameWeapon {

  protected final String name;
  protected final int damage;
  protected final int weight;

  /**
   * Creates a weapon with a name, a base damage, speed, and it's type.
   */
  public Weapon(final String name, final int damage, final int weight)
          throws InvalidStatValueException {
    Require.statValueAtLeast(0, damage, "Damage");
    Require.statValueAtLeast(1, weight, "Weight");
    this.name = name;
    this.damage = damage;
    this.weight = weight;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getDamage() {
    return damage;
  }

  @Override
  public int getWeight() {
    return weight;
  }

  @Override
  public void equipEngineer(Engineer engineer) throws InvalidEquippedWeapon {
    throw new InvalidEquippedWeapon();
  }

  @Override
  public void equipKnight(Knight knight) throws InvalidEquippedWeapon {
    throw new InvalidEquippedWeapon();
  }

  @Override
  public void equipThief(Thief thief) throws InvalidEquippedWeapon {
    throw new InvalidEquippedWeapon();
  }

  @Override
  public void equipBlackMage(BlackMage blackmage) throws InvalidEquippedWeapon {
    throw new InvalidEquippedWeapon();
  }

  @Override
  public void equipWhiteMage(WhiteMage whitemage) throws InvalidEquippedWeapon {
    throw new InvalidEquippedWeapon();
  }

}
