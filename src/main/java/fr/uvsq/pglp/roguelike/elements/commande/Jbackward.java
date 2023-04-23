package fr.uvsq.pglp.roguelike.elements.commande;

import fr.uvsq.pglp.roguelike.Reference;
import fr.uvsq.pglp.roguelike.utils.Functions;
import fr.uvsq.pglp.roguelike.utils.Tile;
import java.awt.Point;

/**
 * Saut .
 */
public class Jbackward implements Commande {

  @Override
  public void execute() {
    try {
      if (Reference.currentDonjon.getTile(Reference.pj.getX(), Reference.pj.getY() + 2)
          == Tile.NOTHING) {
        int posX = Reference.pj.getX();
        int posY = Reference.pj.getY() + 2;
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
