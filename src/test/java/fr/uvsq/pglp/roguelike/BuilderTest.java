package fr.uvsq.pglp.roguelike;

import fr.uvsq.pglp.roguelike.elements.personnage.Builder;
import fr.uvsq.pglp.roguelike.elements.personnage.Caracteristique;
import fr.uvsq.pglp.roguelike.elements.personnage.ScoreDeCaracteristique;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BuilderTest {

  @Test
  public void testRandomCaracteristique() {
    Builder b = new Builder("Test Builder", 0, 0, 0, 100, 10, 10);

    List<ScoreDeCaracteristique> lsc = b.getCaracteristiques();

    int sum = 0;
    for (ScoreDeCaracteristique sc : lsc) {
      assertTrue(sc.getValue() >= 3 && sc.getValue() <= 18);
      sum += sc.getValue();
    }
    assertTrue(sum >= 65 && sum <= 80);
  }

  @Test
  public void testPriorite() {
    Builder b = new Builder("Test Builder", 0, 0, 0, 100, 10, 10);

    ArrayList<Integer> prio = new ArrayList<>();
    prio.add(4);
    prio.add(1);
    prio.add(5);
    prio.add(0);
    prio.add(3);
    prio.add(2);
    System.out.println("changer la priorité ");
    b.priorite(prio);
    List <ScoreDeCaracteristique> lsc=b.getCaracteristiques();
    int sum = 0;
    for(ScoreDeCaracteristique sc: lsc)
    {
      System.out.println(sc.getcaracteristique()+" "+sc.getValue());
      sum=sum+sc.getValue();
    }
    System.out.println();
    assertTrue(sum>=65 && sum <=80, "la somme est  hors intervale");
  }


  @Test
  public void testValeur() {
    Builder b = new Builder("Test Builder", 0, 0, 0, 100, 10, 10);

    assertTrue(b.valeur(Caracteristique.Force, 5));
    assertEquals(5, b.getCarScore(Caracteristique.Force));
    assertTrue(b.valeur(Caracteristique.Constitution, 10));
    assertEquals(10, b.getCarScore(Caracteristique.Constitution));
    assertFalse(b.valeur(Caracteristique.Charisme, 25));
    assertEquals(10, b.getCarScore(Caracteristique.Constitution));
    assertFalse(b.valeur(null, 5));
    assertEquals(10, b.getCarScore(Caracteristique.Constitution));
    assertFalse(b.valeur(Caracteristique.Force, -1));
    assertEquals(5, b.getCarScore(Caracteristique.Force));
    assertFalse(b.valeur(Caracteristique.Force, 21));
    assertEquals(5, b.getCarScore(Caracteristique.Force));
  }
}
