package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a axe (type of weapon).
 */
public class Axe extends Weapon implements GameWeapon {

  public Axe(@NotNull final String name, final int damage, final int weight)
          throws InvalidStatValueException {
    super(name, damage, weight);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof final Axe axe)) {
      return false;
    }

    return hashCode() == axe.hashCode() && damage == axe.damage && Objects.equals(name, axe.name)
          && weight == axe.weight;

  }

  @Override
  public int hashCode() {
    return Objects.hash(Axe.class, getName(), getDamage(), getWeight());
  }

  @Override
  public String toString() {
    return "Axe{name='%s', damage=%d, weight=%d}"
             .formatted(super.getName(), super.getDamage(), super.getWeight());
  }

  @Override
  public void equipEngineer(Engineer engineer) {
    engineer.equippedWeapon = this;
    return;
  }

  @Override
  public void equipKnight(Knight knight) {
    knight.equippedWeapon = this;
    return;
  }

}

