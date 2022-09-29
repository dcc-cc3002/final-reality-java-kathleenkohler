package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Bow extends Weapon{

    public Bow(final @NotNull String name, final int damage, final int weight) throws InvalidStatValueException {

        super(name, damage, weight);
    }


    @Override
    public boolean equals(final Object o){
        return super.equals(o) && o instanceof Bow;
    }

    @Override
    public int hashCode(){
        return Objects.hash(Bow.class, getName(), getDamage(), getWeight());
    }

    @Override
    public String toString() {
        return "Bow{name='%s', damage=%d, weight=%d}"
                .formatted(super.getName(), super.getDamage(), super.getWeight());
    }
}

