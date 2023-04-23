package fr.uvsq.pglp.roguelike.elements.commande;

import fr.uvsq.pglp.roguelike.Reference;
import fr.uvsq.pglp.roguelike.utils.Direction;
import fr.uvsq.pglp.roguelike.utils.Functions;

/**
 * Right .
 */

public class Right implements Commande {
  @Override
  public void execute() {
    Reference.pj.setFacing(Direction.RIGHT);
    Functions.handlePlayerMovment(Direction.RIGHT);
    Reference.currentDonjon.updatePlayerPos();
    Functions.moveMonsters();
    Functions.moveFriendlies();
    Reference.currentDonjon.updateMonstersPos();
    Reference.currentDonjon.updateFriendliesPos();
    Reference.currentDonjon.setVendeurPos();
  }
}
