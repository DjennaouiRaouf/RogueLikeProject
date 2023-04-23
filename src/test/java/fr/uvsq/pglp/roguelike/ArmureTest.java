package fr.uvsq.pglp.roguelike;

import fr.uvsq.pglp.roguelike.elements.Armure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArmureTest {

    @Test
    public void testGetDef() {
        Armure cuir = new Armure("Cuir", 2, 4);
        Armure grandBouclier = new Armure("GrandBouclier", 2, 4);
        assertEquals(2, cuir.getDef());
        assertEquals(2, grandBouclier.getDef());
    }

    @Test
    public void testGetName() {
        Armure demiPlaque = new Armure("DemiPlaque", 3, 8);
        Armure plaqueComplete = new Armure("PlaqueComplete", 8, 20);
        assertEquals("DemiPlaque", demiPlaque.getName());
        assertEquals("PlaqueComplete", plaqueComplete.getName());
    }

    @Test
    public void testGetPrice() {
        Armure normal = new Armure(" ", 0, 0);
        Armure cuir = new Armure("Cuir", 2, 4);
        assertEquals(0, normal.getPrice());
        assertEquals(4, cuir.getPrice());
    }

    @Test
    public void testGetRandomArmor() {
        Armure randomArmor = Armure.getRandomArmor();
        assertTrue(randomArmor instanceof Armure);
    }
}
