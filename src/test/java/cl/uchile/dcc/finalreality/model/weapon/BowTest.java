package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippedWeapon;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class BowTest {
    private Bow bow1;
    private Bow bow2;
    private Bow bow3;
    private Knife knife;

    @Before
    public void setUp() throws Exception{
        bow1 = new Bow("bow", 4,7);
        bow2 = new Bow("bow", 4,7);
        bow3 = new Bow("boww", 6,8);
        knife = new Knife("knife", 4 ,7);
    }

    @Test
    public void testGetName() {
        assertEquals("falla getName en bow","bow", bow1.getName());
        assertNotEquals("falla getName en bow",bow2.getName(), bow3.getName());
    }

    @Test
    public void testGetDamage() {
        assertEquals("falla getDamage en bow",4, bow2.getDamage());
        assertNotEquals("falla getDamage en bow",bow2.getDamage(), bow3.getDamage());
    }

    @Test
    public void testGetWeight() {
        assertEquals("falla getWeight en bow",8, bow3.getWeight());
        assertNotEquals("falla getWeight en bow",7, bow3.getWeight());
    }

    @Test
    public void testEquals() {
        assertTrue("falla equals con mismo objeto en bow", bow1.equals(bow1));
        assertFalse("falla equals con distintos objetos en bow", bow1.equals(bow3));
        assertFalse("falla equals con distintos tipos de arma en bow", bow2.equals(knife));
    }

    @Test
    public void testHashCode() {
        assertEquals("falla hashcode para elementos iguales en bow", bow1.hashCode(), bow2.hashCode());
        assertNotEquals("falla hashcode para elementos distintos en bow", bow2.hashCode(), bow3.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("metodo ToString no funciona en clase bow",
                "Bow{name='bow', damage=4, weight=7}", bow2.toString());
    }

    @Test
    public void testEquipEngineer() throws InvalidStatValueException, InvalidEquippedWeapon {
        BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
        Engineer engineer = new Engineer("engineer", 4, 7, queue);
        engineer.equip(bow1);
        assertEquals("no se equipó arma que debió ser equipada", bow1, engineer.getEquippedWeapon());
        assertNotEquals("no se equipó arma que debió ser equipada", null, engineer.getEquippedWeapon());
    }

    @Test
    public void testEquipThief() throws InvalidStatValueException, InvalidEquippedWeapon {
        BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
        Thief thief = new Thief("thief", 4, 7, queue);
        thief.equip(bow1);
        assertEquals("no se equipó arma que debió ser equipada", bow1, thief.getEquippedWeapon());
        assertNotEquals(" no se equipó arma que debió ser equipada", null, thief.getEquippedWeapon());
    }
}
