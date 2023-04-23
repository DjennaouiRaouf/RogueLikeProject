package fr.uvsq.pglp.roguelike;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fr.uvsq.pglp.roguelike.elements.Donjon;
import fr.uvsq.pglp.roguelike.elements.Status;
import fr.uvsq.pglp.roguelike.elements.Strategy;
import fr.uvsq.pglp.roguelike.elements.personnage.Builder;
import fr.uvsq.pglp.roguelike.elements.personnage.Pj;
import fr.uvsq.pglp.roguelike.elements.personnage.Pnj;
import fr.uvsq.pglp.roguelike.utils.Direction;
import fr.uvsq.pglp.roguelike.utils.Functions;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PnjTest {
  private Pnj pnj;
  @BeforeEach
  public void setUp() {
    Builder b= new Builder("Monster", 0, 30, 40, 10, 2, 2);
    pnj = new Pnj(b, Status.DANGEREUX);

  }
  @Test
  public void testStatus() {
    assertTrue(pnj.getStatus()== Status.DANGEREUX);

  }

  /*
  @Test
  public void testMove(){

    Reference.currentDonjon = new Donjon(1, Strategy.PREDEFF);
    Builder playerbuilder = new Builder("Player", 0, 3, 2, 20, 5, 1);
    Reference.pj = new Pj(playerbuilder);
    Reference.pnjs = new ArrayList<Pnj>();
    Reference.friendlies = new ArrayList<Pnj>();
    Reference.vendeurs = new ArrayList<Pnj>();

    Functions.initMovingTiles();
    System.out.println(Reference.pnjs.get(0).getX());
    System.out.println(Reference.pnjs.get(0).getY());
    Reference.pnjs.get(0).moveRandom();
    System.out.println(Reference.pnjs.get(0).getX());
    System.out.println(Reference.pnjs.get(0).getY());


  }
  */
  @Test
  public void testDamage(){

      System.out.println(pnj.getHp());
      pnj.damage(10);
      System.out.println(pnj.getHp());

  }
}
