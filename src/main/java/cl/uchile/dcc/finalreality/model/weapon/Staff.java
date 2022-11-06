package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a staff (type of weapon).
 */

public class Staff extends Weapon implements EquipWeapon {

  public Staff(final @NotNull String name, final int damage, final int weight)
          throws InvalidStatValueException {
    super(name, damage, weight);
  }


  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof final Staff staff)) {
      return false;
    }

    return hashCode() == staff.hashCode() && Objects.equals(name, staff.name)
         && damage == staff.damage && weight == staff.weight;
  }

  @Override
  public int hashCode() {
    return Objects.hash(Staff.class, getName(), getDamage(), getWeight());
  }

  @Override
  public String toString() {
    return "Staff{name='%s', damage=%d, weight=%d}"
                .formatted(super.getName(), super.getDamage(), super.getWeight());
  }

  @Override
  public void equipEngineer(Engineer engineer) {
    return;

  }

  @Override
  public void equipKnight(Knight knight) {
    return;

  }

  @Override
  public void equipThief(Thief thief) {
    return;

  }

  @Override
  public void equipBlackMage(BlackMage blackmage) {
    blackmage.equippedWeapon = this;
    return;

  }

  @Override
  public void equipWhiteMage(WhiteMage whitemage) {
    whitemage.equippedWeapon = this;
    return;

  }
}

