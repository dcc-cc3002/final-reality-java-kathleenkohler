package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippedWeapon;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
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
    private Enemy enemy;
    private Enemy enemy2;
    private Thief thief1;
    private Thief thief2;
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();

    @Before
    public void setUp() throws Exception{
        staff1 = new Staff("staff", 4, 7,7);
        staff2 = new Staff("staff", 4, 7,7);
        staff3 = new Staff("stafff", 6, 5,8);
        sword = new Sword("sword", 4 ,7);
        enemy = new Enemy("enemy", 10, 20, 5,25,queue);
        enemy2 = new Enemy("enemy", 10, 5, 5,20,queue);
        thief1 = new Thief("thief", 10, 10, queue);
        thief2 = new Thief("thief", 15, 10, queue);
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

    @Test
    public void testGetMagicDamage() {
        assertEquals(7, staff1.getMagicDamage());
        assertNotEquals(7, staff3.getMagicDamage());
    }

    @Test
    public void testWeaponCure() throws InvalidStatValueException {
        enemy.attack(thief1);
        staff1.weaponCure(thief1);
        assertEquals(0, thief1.getCurrentHp());
        staff1.weaponCure(thief2);
        assertEquals(15, thief2.getCurrentHp());
        enemy2.attack(thief2);
        assertEquals(5, thief2.getCurrentHp());
        staff1.weaponCure(thief2);
        assertEquals(9, thief2.getCurrentHp());


    }

    @Test
    public void testWeaponParalysis() throws InvalidStatValueException {
        staff1.weaponParalysis(enemy);
        assertTrue(enemy.isParalyzed());
    }

    @Test
    public void testWeaponPoison() throws InvalidStatValueException {
        staff1.weaponPoison(enemy);
        assertTrue(enemy.isPoisoned());

    }

    @Test
    public void testWeaponThunder() throws InvalidStatValueException {
        staff1.weaponThunder(enemy);
        assertEquals(13, enemy.getCurrentHp());
        staff1.weaponThunder(enemy2);
        assertEquals(0, enemy2.getCurrentHp());
    }

    @Test
    public void testWeaponFire() throws InvalidStatValueException {
        staff1.weaponFire(enemy);
        assertEquals(13,enemy.getCurrentHp());
        staff1.weaponFire(enemy2);
        assertEquals(0,enemy2.getCurrentHp());
    }
}
