package fr.uvsq.pglp.roguelike.elements.commande;

import fr.uvsq.pglp.roguelike.Reference;
import fr.uvsq.pglp.roguelike.utils.Direction;
import fr.uvsq.pglp.roguelike.utils.Functions;

/**
 * Backward .
 */
public class Backward implements Commande {
  @Override
   public void execute() {
    Reference.pj.setFacing(Direction.BACKWARDS);
    Functions.handlePlayerMovment(Direction.BACKWARDS);
    Reference.currentDonjon.updatePlayerPos();
    Functions.moveMonsters();
    Functions.moveFriendlies();
    Reference.currentDonjon.updateMonstersPos();
    Reference.currentDonjon.updateFriendliesPos();
    Reference.currentDonjon.setVendeurPos();
  }
}
