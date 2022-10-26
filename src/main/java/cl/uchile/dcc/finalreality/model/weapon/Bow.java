package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
/**
 * A class that holds all the information of a bow (type of weapon).
 */

public class Bow extends Weapon {

  public Bow(final @NotNull String name, final int damage, final int weight)
          throws InvalidStatValueException {
    super(name, damage, weight);
  }


  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof final Bow bow)) {
      return false;
    }

    return hashCode() == bow.hashCode() && damage == bow.damage && weight == bow.weight && Objects.equals(name, bow.name);
  }
  @Override
  public int hashCode() {
    return Objects.hash(Bow.class, getName(), getDamage(), getWeight());
  }

  @Override
  public String toString() {
    return "Bow{name='%s', damage=%d, weight=%d}"
                .formatted(super.getName(), super.getDamage(), super.getWeight());
  }
}

