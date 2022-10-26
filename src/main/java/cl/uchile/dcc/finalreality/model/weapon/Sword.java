package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a sword (type of weapon).
 */
public class Sword extends Weapon {

  public Sword(final @NotNull String name, final int damage, final int weight)
          throws InvalidStatValueException {
    super(name, damage, weight);
  }


  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof final Sword sword)) {
      return false;
    }

    return hashCode() == sword.hashCode() && damage == sword.damage && weight == sword.weight && Objects.equals(name, sword.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Sword.class, getName(), getDamage(), getWeight());
  }

  @Override
  public String toString() {
    return "Sword{name='%s', damage=%d, weight=%d}"
                .formatted(super.getName(), super.getDamage(), super.getWeight());
  }
}

