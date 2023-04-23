package fr.uvsq.pglp.roguelike.elements.personnage;

import java.util.Comparator;

/**
 * ScoreDeCaracteristiqueComparator .
 */
public class ScoreDeCaracteristiqueComparator implements Comparator<ScoreDeCaracteristique> {
  @Override
  public int compare(ScoreDeCaracteristique o1, ScoreDeCaracteristique o2) {

    if (o1.getValue() < o2.getValue()) {
      return 1;
    } else {
      return -1;
    }

  }
}
