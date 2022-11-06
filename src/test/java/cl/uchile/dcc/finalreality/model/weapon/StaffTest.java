package cl.uchile.dcc.finalreality.model.weapon;

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

    @Test
    public void testEquipEngineer() throws InvalidStatValueException {
        BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
        Engineer engineer = new Engineer("engineer", 4, 7, queue);
        engineer.equip(staff1);
        assertNotEquals("se equipó arma que no debió ser equipada", staff1, engineer.getEquippedWeapon());
        assertEquals("se equipó arma que no debió ser equipada", null, engineer.getEquippedWeapon());
    }

    @Test
    public void testEquipKnight() throws InvalidStatValueException {
        BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
        Knight knight = new Knight("knight", 4, 7, queue);
        knight.equip(staff1);
        assertNotEquals("se equipó arma que no debió ser equipada", staff1, knight.getEquippedWeapon());
        assertEquals("se equipó arma que no debió ser equipada", null, knight.getEquippedWeapon());
    }

    @Test
    public void testEquipThief() throws InvalidStatValueException {
        BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
        Thief thief = new Thief("thief", 4, 7, queue);
        thief.equip(staff1);
        assertNotEquals("se equipó arma que no debió ser equipada", staff1, thief.getEquippedWeapon());
        assertEquals("se equipó arma que no debió ser equipada", null, thief.getEquippedWeapon());
    }

    @Test
    public void testEquipBlackMage() throws InvalidStatValueException {
        BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
        BlackMage bmage = new BlackMage("bmage",  15, 10, 20, queue);
        bmage.equip(staff1);
        assertEquals("no se equipó arma que debió ser equipada", staff1, bmage.getEquippedWeapon());
        assertNotEquals("no se equipó arma que debió ser equipada", null, bmage.getEquippedWeapon());
    }

    @Test
    public void testEquipWhiteMage() throws InvalidStatValueException {
        BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
        WhiteMage wmage = new WhiteMage("wmage",  15, 10, 20, queue);
        wmage.equip(staff1);
        assertEquals("no se equipó arma que debió ser equipada", staff1, wmage.getEquippedWeapon());
        assertNotEquals("no se equipó arma que debió ser equipada", null, wmage.getEquippedWeapon());
    }
}
