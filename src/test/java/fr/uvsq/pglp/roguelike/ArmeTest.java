package fr.uvsq.pglp.roguelike;

import fr.uvsq.pglp.roguelike.elements.Arme;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ArmeTest {

    @Test
    public void testGetDmg() {
        Arme arme = new Arme("Test Arme", 10, 50);
        assertEquals(10, arme.getDmg());
    }

    @Test
    public void testGetName() {
        Arme arme = new Arme("Test Arme", 10, 50);
        assertEquals("Test Arme", arme.getName());
    }

    @Test
    public void testGetPrice() {
        Arme arme = new Arme("Test Arme", 10, 50);
        assertEquals(50, arme.getPrice());
    }

    @Test
    public void testGetRandomWeapon() {
        Arme randomArme = Arme.getRandomWeapon();
        // make sure a random weapon is returned
        assertEquals(true, randomArme != null);
    }
}
