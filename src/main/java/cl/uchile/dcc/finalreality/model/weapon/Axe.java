package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import java.util.Objects;

import cl.uchile.dcc.finalreality.model.character.player.*;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a axe (type of weapon).
 */
public class Axe extends Weapon implements EquipWeapon {

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

    return hashCode() == axe.hashCode() && damage == axe.damage && weight == axe.weight
          && Objects.equals(name, axe.name);

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

  }

  @Override
  public void equipKnight(Knight knight) {

  }

  @Override
  public void equipThief(Thief thief) {

  }

  @Override
  public void equipBlackMage(BlackMage blackmage) {

  }

  @Override
  public void equipWhiteMage(WhiteMage whitemage) {

  }
}

