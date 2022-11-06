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
        assertEquals("falla getName en sword","sword", sword1.getName());
        assertNotEquals("falla getName en sword",sword2.getName(), sword3.getName());
    }

    @Test
    public void testGetDamage() {
        assertEquals("falla getDamage en sword",4, sword2.getDamage());
        assertNotEquals("falla getDamage en sword",sword2.getDamage(), sword3.getDamage());
    }

    @Test
    public void testGetWeight() {
        assertEquals("falla getWeight en sword", 8, sword3.getWeight());
        assertNotEquals("falla getWeight en sword",7, sword3.getWeight());
    }

    @Test
    public void testEquals() {
        assertTrue("falla equals con mismo objeto en sword", sword1.equals(sword1));
        assertFalse("falla equals con distintos objetos en sword", sword1.equals(sword3));
        assertFalse("falla equals con distintos tipos de arma en sword", sword2.equals(axe));
    }

    @Test
    public void testHashCode() {
        assertEquals("falla hashcode para elementos iguales en sword", sword1.hashCode(), sword2.hashCode());
        assertNotEquals("falla hashcode para elementos distintos en sword", sword2.hashCode(), sword3.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("metodo ToString no funciona en clase sword",
                "Sword{name='sword', damage=4, weight=7}", sword2.toString());
    }

    @Test
    public void testEquipKnight() throws InvalidStatValueException, InvalidEquippedWeapon {
        BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
        Knight knight = new Knight("knight", 4, 7, queue);
        knight.equip(sword1);
        assertEquals("no se equipó arma que debió ser equipada", sword1, knight.getEquippedWeapon());
        assertNotEquals("no se equipó arma que debió ser equipada", null, knight.getEquippedWeapon());
    }

    @Test
    public void testEquipThief() throws InvalidStatValueException, InvalidEquippedWeapon {
        BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
        Thief thief = new Thief("thief", 4, 7, queue);
        thief.equip(sword1);
        assertEquals("no se equipó arma que debió ser equipada", sword1, thief.getEquippedWeapon());
        assertNotEquals(" no se equipó arma que debió ser equipada", null, thief.getEquippedWeapon());
    }
}
