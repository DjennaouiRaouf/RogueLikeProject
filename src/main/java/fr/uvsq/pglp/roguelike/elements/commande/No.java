package fr.uvsq.pglp.roguelike.elements.commande;

import fr.uvsq.pglp.roguelike.Reference;
import fr.uvsq.pglp.roguelike.utils.Functions;

/**
 * No .
 */
public class No implements Commande {
  @Override
  public void execute() {
    Functions.makeDecision(false);
    Reference.currentDonjon.updatePlayerPos();
  }
}
