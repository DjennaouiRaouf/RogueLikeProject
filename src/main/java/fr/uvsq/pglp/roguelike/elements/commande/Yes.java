package fr.uvsq.pglp.roguelike.elements.commande;

import fr.uvsq.pglp.roguelike.Reference;
import fr.uvsq.pglp.roguelike.utils.Functions;

/**
 * Yes .
 */
public  class Yes implements Commande {
  @Override
  public void execute() {
    Functions.makeDecision(true);
    Reference.currentDonjon.updatePlayerPos();
  }
}
