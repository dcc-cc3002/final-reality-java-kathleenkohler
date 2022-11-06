package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippedWeapon;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
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
        assertEquals("fail to get Name in Bow class","bow", bow1.getName());
        assertNotEquals("fail to get Name in Bow class",bow2.getName(), bow3.getName());
    }

    @Test
    public void testGetDamage() {
        assertEquals("fail to get Damage in Bow class",4, bow2.getDamage());
        assertNotEquals("fail to get Damage in Bow class",bow2.getDamage(), bow3.getDamage());
    }

    @Test
    public void testGetWeight() {
        assertEquals("fail to get Weight in Bow class",8, bow3.getWeight());
        assertNotEquals("fail to get Weight in Bow class",7, bow3.getWeight());
    }

    @Test
    public void testEquals() {
        assertTrue("equals fails with equal object in Bow", bow1.equals(bow1));
        assertFalse("equals fails with different objects in Bow", bow1.equals(bow3));
        assertFalse("equals fails with different types of weapon in Bow", bow2.equals(knife));
    }

    @Test
    public void testHashCode() {
        assertEquals("hashcode fails for equal elements in Bow", bow1.hashCode(), bow2.hashCode());
        assertNotEquals("hashcode fails for distinct elements in Bow", bow2.hashCode(), bow3.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("ToString method does not work in Bow class",
                "Bow{name='bow', damage=4, weight=7}", bow2.toString());
    }

    @Test
    public void testEquipEngineer() throws InvalidStatValueException, InvalidEquippedWeapon {
        BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
        Engineer engineer = new Engineer("engineer", 4, 7, queue);
        engineer.equip(bow1);
        assertEquals("weapon that should have been equipped was not equipped in Bow class",
              bow1, engineer.getEquippedWeapon());
        assertNotEquals("weapon that should have been equipped was not equipped in Bow class",
              null, engineer.getEquippedWeapon());
    }

    @Test
    public void testEquipThief() throws InvalidStatValueException, InvalidEquippedWeapon {
        BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
        Thief thief = new Thief("thief", 4, 7, queue);
        thief.equip(bow1);
        assertEquals("weapon that should have been equipped was not equipped in Bow class",
              bow1, thief.getEquippedWeapon());
        assertNotEquals("weapon that should have been equipped was not equipped in Bow class",
              null, thief.getEquippedWeapon());
    }
}
