package fr.uvsq.pglp.roguelike.elements.commande;

import fr.uvsq.pglp.roguelike.Reference;
import fr.uvsq.pglp.roguelike.utils.Direction;
import fr.uvsq.pglp.roguelike.utils.Functions;

/**
 * Left .
 */
public class Left implements Commande {
  @Override
  public void execute() {
    Reference.pj.setFacing(Direction.LEFT);
    Functions.handlePlayerMovment(Direction.LEFT);
    Reference.currentDonjon.updatePlayerPos();
    Functions.moveMonsters();
    Functions.moveFriendlies();
    Reference.currentDonjon.updateMonstersPos();
    Reference.currentDonjon.updateFriendliesPos();
    Reference.currentDonjon.setVendeurPos();
  }
}
