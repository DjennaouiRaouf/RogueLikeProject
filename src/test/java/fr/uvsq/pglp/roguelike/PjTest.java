package fr.uvsq.pglp.roguelike;



import fr.uvsq.pglp.roguelike.elements.Arme;
import fr.uvsq.pglp.roguelike.elements.Armure;
import fr.uvsq.pglp.roguelike.elements.personnage.Builder;
import fr.uvsq.pglp.roguelike.elements.personnage.Pj;
import fr.uvsq.pglp.roguelike.utils.Direction;
import fr.uvsq.pglp.roguelike.utils.Functions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PjTest {

  private Pj player;

  @BeforeEach
  public void setUp() {
    Builder builder = new Builder("Test Player", 0, 0, 20, 20, 1,10);
    player = new Pj(builder);
  }



  @Test
  public void testAddGold() {
    player.addGold(100);
    assertEquals(player.getGold(), 100);
  }

  @Test
  public void testTakeGold() {
    player.addGold(100);
    player.takeGold(50);
    assertEquals(player.getGold(), 50);
  }

  @Test
  public void testAddKey() {
    player.addKey();
    assertEquals(player.getKeys(), 1);
  }

  @Test
  public void testTakeKey() {
    player.addKey();
    player.takeKey();
    assertEquals(player.getKeys(), 0);
  }

  @Test
  public void testIsAlive() {
    assertTrue(player.isAlive());
    player.setDead();
    assertFalse(player.isAlive());
  }
  @Test
  public void testMovement(){
    System.out.println(player.getX());
    System.out.println(player.getY());
    player.move(Direction.BACKWARDS);
    System.out.println(player.getX());
    System.out.println(player.getY());

  }
  


  
  @Test
  public void testDamage(){
    System.out.println(player.getHp());
    player.damage(10);
    System.out.println(player.getHp());
    player.heal(7);
    System.out.println(player.getHp());
  }

}
