package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.AbstractMage;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a staff (type of weapon).
 */

public class Staff extends Weapon implements GameWeapon {

  private final int magicDamage;

  public Staff(final @NotNull String name, final int damage, final int magicDamage, int weight)
          throws InvalidStatValueException {
    super(name, damage, weight);
    this.magicDamage =  magicDamage;
  }

  public int getMagicDamage() {
    return magicDamage;
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
         && damage == staff.damage && weight == staff.weight && magicDamage == staff.magicDamage;
  }

  @Override
  public int hashCode() {
    return Objects.hash(Staff.class, getName(), getDamage(), getMagicDamage(),
          getWeight());
  }

  @Override
  public String toString() {
    return "Staff{name='%s', damage=%d, magicDamage=%d, weight=%d}"
                .formatted(super.getName(), super.getDamage(), magicDamage, super.getWeight());
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

  @Override
  public void wCure(AbstractPlayerCharacter character) throws InvalidStatValueException {
    if(character.getCurrentHp()+(int)(0.3*character.getMaxHp())>=character.getMaxHp()) {
      character.setCurrentHp(character.getMaxHp());
    }
    else {
      character.setCurrentHp(character.getCurrentHp()+(int)(0.3*character.getMaxHp()));
    }
  }

  @Override
  public void wPoison(Enemy enemy) throws InvalidStatValueException {

  }

  @Override
  public void wParalysis(Enemy enemy) throws InvalidStatValueException {

  }

  @Override
  public void wThunder(Enemy enemy) throws InvalidStatValueException {
    if(enemy.getCurrentHp()-this.magicDamage<=0) {
      enemy.setCurrentHp(0);
    }
    else {
      enemy.setCurrentHp(enemy.getCurrentHp()-this.magicDamage);
    }
  }

  @Override
  public void wFire(Enemy enemy) throws InvalidStatValueException {
    if(enemy.getCurrentHp()-this.magicDamage<=0) {
      enemy.setCurrentHp(0);
    }
    else {
      enemy.setCurrentHp(enemy.getCurrentHp()-this.magicDamage);
    }
  }
}

