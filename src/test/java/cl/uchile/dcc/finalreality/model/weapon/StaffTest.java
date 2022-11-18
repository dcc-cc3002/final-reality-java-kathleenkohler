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

public class StaffTest {
    private Staff staff1;
    private Staff staff2;
    private Staff staff3;
    private Sword sword;

    @Before
    public void setUp() throws Exception{
        staff1 = new Staff("staff", 4, 7,7);
        staff2 = new Staff("staff", 4, 7,7);
        staff3 = new Staff("stafff", 6, 7,8);
        sword = new Sword("sword", 4 ,7);
    }

    @Test
    public void testGetName() {
        assertEquals("fail to get Name in Staff class","staff", staff1.getName());
        assertNotEquals("fail to get Name in Staff class",staff2.getName(), staff3.getName());
    }

    @Test
    public void testGetDamage() {
        assertEquals("fail to get Damage in Staff class",4, staff2.getDamage());
        assertNotEquals("fail to get Damage in Staff class",staff2.getDamage(), staff3.getDamage());
    }

    @Test
    public void testGetWeight() {
        assertEquals("fail to get Weight in Staff class", 8, staff3.getWeight());
        assertNotEquals("fail to get Weight in Staff class",7, staff3.getWeight());
    }

    @Test
    public void testEquals() {
        assertTrue("equals fails with equal object in Staff", staff1.equals(staff1));
        assertFalse("equals fails with different objects in Staff", staff1.equals(staff3));
        assertFalse("equals fails with different types of weapon in Staff", staff2.equals(sword));
    }

    @Test
    public void testHashCode() {
        assertEquals("hashcode fails for equal elements in Staff", staff1.hashCode(), staff2.hashCode());
        assertNotEquals("hashcode fails for distinct elements in Staff", staff2.hashCode(), staff3.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("ToString method does not work in Staff class",
                "Staff{name='staff', damage=4, magicDamage=7, weight=7}", staff2.toString());
    }

    @Test
    public void testEquipBlackMage() throws InvalidStatValueException, InvalidEquippedWeapon {
        BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
        BlackMage bmage = new BlackMage("bmage",  15, 10, 20, queue);
        bmage.equip(staff1);
        assertEquals("weapon that should have been equipped was not equipped in Staff class",
              staff1, bmage.getEquippedWeapon());
        assertNotEquals("weapon that should have been equipped was not equipped in Staff class",
              null, bmage.getEquippedWeapon());
    }

    @Test
    public void testEquipWhiteMage() throws InvalidStatValueException, InvalidEquippedWeapon {
        BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
        WhiteMage wmage = new WhiteMage("wmage",  15, 10, 20, queue);
        wmage.equip(staff1);
        assertEquals("weapon that should have been equipped was not equipped in Staff class",
              staff1, wmage.getEquippedWeapon());
        assertNotEquals("weapon that should have been equipped was not equipped in Staff class",
              null, wmage.getEquippedWeapon());
    }

    //AGREGAR MAGICDAMAGE
}
