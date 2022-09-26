package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

public class Knife extends Weapon{

    public Knife(final String name, final int damage, final int weight){
        super(name, damage, weight);
    }

    public String getName() {
        return super.getName();
    }

    public int getDamage() {
        return super.getDamage();
    }

    /**
     * Returns the weight of the weapon.
     */
    public int getWeight() {
        return super.getWeight();
    }



    @Override
    public boolean equals(final Object o){
        return super.equals(o) && o instanceof Knife;
    }

    @Override
    public int hashCode(){
        return Objects.hash(Knife.class, getName(), getDamage(), getWeight());
    }

    @Override
    public String toString() {
        return "Knife{name='%s', damage=%d, weight=%d}"
                .formatted(super.getName(), super.getDamage(), super.getWeight());
    }
}
