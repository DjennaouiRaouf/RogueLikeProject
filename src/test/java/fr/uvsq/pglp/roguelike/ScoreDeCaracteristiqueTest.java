package fr.uvsq.pglp.roguelike;

import org.junit.jupiter.api.Test;
import fr.uvsq.pglp.roguelike.elements.personnage.Caracteristique;
import fr.uvsq.pglp.roguelike.elements.personnage.ScoreDeCaracteristique;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class  ScoreDeCaracteristiqueTest {

    @Test
    public void test1()
    {
        ScoreDeCaracteristique sc1 = new ScoreDeCaracteristique(Caracteristique.Force, 15);
        ScoreDeCaracteristique sc2 = new ScoreDeCaracteristique(Caracteristique.Force, 15);
        boolean flag = sc1.equals(sc2);
        assertEquals(true,flag);

    }

    @Test
    public void test2()
    {
        ScoreDeCaracteristique sc1 = new ScoreDeCaracteristique(Caracteristique.Force, 15);
        ScoreDeCaracteristique sc2 = new ScoreDeCaracteristique(Caracteristique.Charisme, 16);
        boolean flag = sc1.equals(sc2);
        assertEquals(false,flag);

    }

    @Test
    public void test3()
    {
        ScoreDeCaracteristique sc1 = new ScoreDeCaracteristique(Caracteristique.Force, 15);

        assertEquals(15,sc1.getValue());

    }








}