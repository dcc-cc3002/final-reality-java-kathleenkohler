package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

public class Sword extends Weapon{

    public Sword(final String name, final int damage, final int weight){
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

