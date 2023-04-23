package fr.uvsq.pglp.roguelike.elements.personnage;

/**
 * ScoreDeCaracteristique .
 */
public class ScoreDeCaracteristique {
  private static final int [] modificatorValues = {-4, -4, -3, -3, -2, -2, -1, -1, 0,
      0, 1, 1, 2, 2, 3, 3, 4, 4, 5};
  private final Caracteristique caracteristique;
  private  int value;
  private  int modificator;



  //constructeur de la classe

  /**
   * constructeur .
   */
  public ScoreDeCaracteristique(Caracteristique caracteristique, int value) {
    this.caracteristique = caracteristique;
    this.value = value;
    this.modificator = modificatorValues[value - 2];
  }

  @Override
  //compare l'egalité entre deux caracteristiques
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScoreDeCaracteristique that = (ScoreDeCaracteristique) o;
    return    caracteristique == that.caracteristique;

  }

  // affecter une valeur a une caracteristique
  public void setValue(int value) {
    this.value = value;
  }

  //Getter
  public Caracteristique getcaracteristique() {
    return caracteristique;
  }

  public int getValue() {
    return value;
  }

  public int getModificator() {
    return modificator;
  }

  public static int[] getModificatorValues() {
    return modificatorValues;
  }

}
