package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import java.util.Objects;

import cl.uchile.dcc.finalreality.model.character.player.*;
import org.jetbrains.annotations.NotNull;
/**
 * A class that holds all the information of a bow (type of weapon).
 */

public class Bow extends Weapon implements EquipWeapon {

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

    return hashCode() == bow.hashCode() && damage == bow.damage && weight == bow.weight
          && Objects.equals(name, bow.name);
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

  @Override
  public void equipEngineer(Engineer engineer) {
    engineer.equippedWeapon = this;
    return;

  }

  @Override
  public void equipKnight(Knight knight) {
    return;

  }

  @Override
  public void equipThief(Thief thief) {
    thief.equippedWeapon = this;
    return;

  }

  @Override
  public void equipBlackMage(BlackMage blackmage) {
    return;

  }

  @Override
  public void equipWhiteMage(WhiteMage whitemage) {
    return;

  }
}

