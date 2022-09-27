package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

public class Staff extends Weapon{

    public Staff(final String name, final int damage, final int weight){
        super(name, damage, weight);
    }


    @Override
    public boolean equals(final Object o){
        return super.equals(o) && o instanceof Staff;
    }

    @Override
    public int hashCode(){
        return Objects.hash(Staff.class, getName(), getDamage(), getWeight());
    }

    @Override
    public String toString() {
        return "Staff{name='%s', damage=%d, weight=%d}"
                .formatted(super.getName(), super.getDamage(), super.getWeight());
    }
}

