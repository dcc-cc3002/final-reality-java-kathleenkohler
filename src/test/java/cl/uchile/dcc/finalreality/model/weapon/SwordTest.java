package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippedWeapon;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
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

public class SwordTest {
    private Sword  sword1;
    private Sword sword2;
    private Sword sword3;
    private Axe axe;

    @Before
    public void setUp() throws Exception{
        sword1 = new Sword("sword", 4,7);
        sword2 = new Sword("sword", 4,7);
        sword3 = new Sword("swordd", 6,8);
        axe = new Axe("axe", 4 ,7);
    }

    @Test
    public void testGetName() {
        assertEquals("fail to get Name in Sword class","sword", sword1.getName());
        assertNotEquals("fail to get Name in Sword class",sword2.getName(), sword3.getName());
    }

    @Test
    public void testGetDamage() {
        assertEquals("fail to get Damage in Sword class",4, sword2.getDamage());
        assertNotEquals("fail to get Damage in Sword class",sword2.getDamage(), sword3.getDamage());
    }

    @Test
    public void testGetWeight() {
        assertEquals("fail to get Weight in Sword class", 8, sword3.getWeight());
        assertNotEquals("fail to get Weight in Sword class",7, sword3.getWeight());
    }

    @Test
    public void testEquals() {
        assertTrue("equals fails with equal object in Sword", sword1.equals(sword1));
        assertFalse("equals fails with different objects in Sword", sword1.equals(sword3));
        assertFalse("equals fails with different types of weapon in Sword", sword2.equals(axe));
    }

    @Test
    public void testHashCode() {
        assertEquals("hashcode fails for equal elements in Sword", sword1.hashCode(), sword2.hashCode());
        assertNotEquals("hashcode fails for distinct elements in Sword", sword2.hashCode(), sword3.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("ToString method does not work in Sword class",
                "Sword{name='sword', damage=4, weight=7}", sword2.toString());
    }

    @Test
    public void testEquipKnight() throws InvalidStatValueException, InvalidEquippedWeapon {
        BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
        Knight knight = new Knight("knight", 4, 7, queue);
        knight.equip(sword1);
        assertEquals("weapon that should have been equipped was not equipped in Sword class",
              sword1, knight.getEquippedWeapon());
        assertNotEquals("weapon that should have been equipped was not equipped in Sword class",
              null, knight.getEquippedWeapon());
    }

    @Test
    public void testEquipThief() throws InvalidStatValueException, InvalidEquippedWeapon {
        BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
        Thief thief = new Thief("thief", 4, 7, queue);
        thief.equip(sword1);
        assertEquals("weapon that should have been equipped was not equipped in Sword class",
              sword1, thief.getEquippedWeapon());
        assertNotEquals("weapon that should have been equipped was not equipped in Sword class",
              null, thief.getEquippedWeapon());
    }
}
