package fr.uvsq.pglp.roguelike.elements.commande;

import fr.uvsq.pglp.roguelike.Reference;
import fr.uvsq.pglp.roguelike.elements.Donjon;
import fr.uvsq.pglp.roguelike.utils.Functions;
import fr.uvsq.pglp.roguelike.utils.Tile;
import java.awt.Point;
/**
 * Saut .
 */

public class Jright implements Commande {

  @Override
  public void execute() {
    try {
      if (Reference.currentDonjon.getTile(Reference.pj.getX() + 2,  Reference.pj.getY())
          == Tile.NOTHING) {
        int posX = Reference.pj.getX() + 2;
        int posY = Reference.pj.getY();
        Reference.pj.setPos(posX, posY);
        Reference.currentDonjon.updatePlayerPos();
        Functions.moveMonsters();
        Functions.moveFriendlies();
        Reference.currentDonjon.updateMonstersPos();
        Reference.currentDonjon.updateFriendliesPos();
        Reference.currentDonjon.setVendeurPos();
      }

    } catch (IndexOutOfBoundsException e) {
      System.out.println("out of bounds");
    }



  }
}
