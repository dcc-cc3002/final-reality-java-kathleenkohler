package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import java.util.Objects;

/**
 * An abstract class that holds all the information of a weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Kathleen Kohler~
 */
public abstract class Weapon implements EquipWeapon{

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

  /**
   * Returns the name of the weapon.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns weapon damage.
   */
  public int getDamage() {
    return damage;
  }

  /**
   * Returns the weight of the weapon.
   */
  public int getWeight() {
    return weight;
  }

}
