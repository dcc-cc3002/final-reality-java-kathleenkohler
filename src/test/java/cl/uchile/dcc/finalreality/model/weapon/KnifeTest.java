package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippedWeapon;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

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
        assertEquals("fail to get Name in Knife class","knife", knife1.getName());
        assertNotEquals("fail to get Name in Knife class",knife2.getName(), knife3.getName());
    }

    @Test
    public void testGetDamage() {
        assertEquals("fail to get Damage in Knife class",4, knife2.getDamage());
        assertNotEquals("fail to get Damage in Knife class",knife2.getDamage(), knife3.getDamage());
    }

    @Test
    public void testGetWeight() {
        assertEquals("fail to get Weight in Knife class",8, knife3.getWeight());
        assertNotEquals("fail to get Weight in Knife class",7, knife3.getWeight());
    }

    @Test
    public void testEquals() {
        assertTrue("equals fails with equal object in Knife", knife1.equals(knife1));
        assertFalse("equals fails with different objects in Knife", knife1.equals(knife3));
        assertFalse("equals fails with different types of weapon in Knife", knife2.equals(staff));
    }

    @Test
    public void testHashCode() {
        assertEquals("hashcode fails for equal elements in Knife", knife1.hashCode(), knife2.hashCode());
        assertNotEquals("hashcode fails for distinct elements in Knife", knife2.hashCode(), knife3.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("ToString method does not work in Knife class",
                "Knife{name='knife', damage=4, weight=7}", knife2.toString());
    }

    @Test
    public void testEquipKnight() throws InvalidStatValueException, InvalidEquippedWeapon {
        BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
        Knight knight = new Knight("knight", 4, 7, queue);
        knight.equip(knife1);
        assertEquals("weapon that should have been equipped was not equipped in Knife class",
              knife1, knight.getEquippedWeapon());
        assertNotEquals("weapon that should have been equipped was not equipped in Knife class",
              null, knight.getEquippedWeapon());
    }

    @Test
    public void testEquipThief() throws InvalidStatValueException, InvalidEquippedWeapon {
        BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
        Thief thief = new Thief("thief", 4, 7, queue);
        thief.equip(knife1);
        assertEquals("weapon that should have been equipped was not equipped in Knife class",
              knife1, thief.getEquippedWeapon());
        assertNotEquals("weapon that should have been equipped was not equipped in Knife class",
              null, thief.getEquippedWeapon());
    }

    @Test
    public void testEquipBlackMage() throws InvalidStatValueException, InvalidEquippedWeapon {
        BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
        BlackMage bmage = new BlackMage("bmage",  15, 10, 20, queue);
        bmage.equip(knife1);
        assertEquals("weapon that should have been equipped was not equipped in Knife class",
              knife1, bmage.getEquippedWeapon());
        assertNotEquals("weapon that should have been equipped was not equipped in Knife class",
              null, bmage.getEquippedWeapon());
    }
}
