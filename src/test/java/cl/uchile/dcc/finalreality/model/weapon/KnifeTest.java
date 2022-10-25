package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class KnifeTest {
    private Knife knife1;
    private Knife knife2;
    private Knife knife3;
    private Staff staff;

    @Before
    public void setUp() throws Exception{
        knife1 = new Knife("knife", 4,7);
        knife2 = new Knife("knife", 4,7);
        knife3 = new Knife("knifee", 6,8);
        staff = new Staff("staff", 4 ,7);
    }

    @Test
    public void testGetName() {
        assertEquals("falla getName en knife","knife", knife1.getName());
        assertNotEquals("falla getName en knife",knife2.getName(), knife3.getName());
    }

    @Test
    public void testGetDamage() {
        assertEquals("falla getDamage en knife",4, knife2.getDamage());
        assertNotEquals("falla getDamage en knife",knife2.getDamage(), knife3.getDamage());
    }

    @Test
    public void testGetWeight() {
        assertEquals("falla getWeight en knife",8, knife3.getWeight());
        assertNotEquals("falla getWeight en knife",7, knife3.getWeight());
    }

    @Test
    public void testEquals() {
        assertTrue("falla equals con mismo objeto en knife", knife1.equals(knife1));
        assertFalse("falla equals con distintos objetos en knife", knife1.equals(knife3));
        assertFalse("falla equals con distintos tipos de arma en knife", knife2.equals(staff));
    }

    @Test
    public void testHashCode() {
        assertEquals("falla hashcode para elementos iguales en knife", knife1.hashCode(), knife2.hashCode());
        assertNotEquals("falla hashcode para elementos distintos en knife", knife2.hashCode(), knife3.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("metodo ToString no funciona en clase knife",
                "Knife{name='knife', damage=4, weight=7}", knife2.toString());
    }
}
