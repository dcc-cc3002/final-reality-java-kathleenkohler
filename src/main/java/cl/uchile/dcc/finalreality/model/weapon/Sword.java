package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Sword extends Weapon{

    public Sword(final @NotNull String name, final int damage, final int weight)throws InvalidStatValueException {
        super(name, damage, weight);
    }


    @Override
    public boolean equals(final Object o){
        return super.equals(o) && o instanceof Sword;
    }

    @Override
    public int hashCode(){
        return Objects.hash(Sword.class, getName(), getDamage(), getWeight());
    }

    @Override
    public String toString() {
        return "Sword{name='%s', damage=%d, weight=%d}"
                .formatted(super.getName(), super.getDamage(), super.getWeight());
    }
}

