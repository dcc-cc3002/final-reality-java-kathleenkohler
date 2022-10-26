package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class StaffTest {
    private Staff staff1;
    private Staff staff2;
    private Staff staff3;
    private Sword sword;

    @Before
    public void setUp() throws Exception{
        staff1 = new Staff("staff", 4,7);
        staff2 = new Staff("staff", 4,7);
        staff3 = new Staff("stafff", 6,8);
        sword = new Sword("sword", 4 ,7);
    }

    @Test
    public void testGetName() {
        assertEquals("falla getName en staff","staff", staff1.getName());
        assertNotEquals("falla getName en staff",staff2.getName(), staff3.getName());
    }

    @Test
    public void testGetDamage() {
        assertEquals("falla getDamage en staff",4, staff2.getDamage());
        assertNotEquals("falla getDamage en staff",staff2.getDamage(), staff3.getDamage());
    }

    @Test
    public void testGetWeight() {
        assertEquals("falla getWeight en staff", 8, staff3.getWeight());
        assertNotEquals("falla getWeight en staff",7, staff3.getWeight());
    }

    @Test
    public void testEquals() {
        assertTrue("falla equals con mismo objeto en staff", staff1.equals(staff1));
        assertFalse("falla equals con distintos objetos en staff", staff1.equals(staff3));
        assertFalse("falla equals con distintos tipos de arma en staff", staff2.equals(sword));
    }

    @Test
    public void testHashCode() {
        assertEquals("falla hashcode para elementos iguales en staff", staff1.hashCode(), staff2.hashCode());
        assertNotEquals("falla hashcode para elementos distintos en staff", staff2.hashCode(), staff3.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("metodo ToString no funciona en clase staff",
                "Staff{name='staff', damage=4, weight=7}", staff2.toString());
    }
}
