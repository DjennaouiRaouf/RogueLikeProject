package fr.uvsq.pglp.roguelike.elements.personnage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Builder .
 */
public class Builder {
  protected final String name;
  int init;
  protected final ArrayList<ScoreDeCaracteristique> caracteristiques;
  protected static ArrayList<Caracteristique> order;
  protected int posX;
  protected int posY;

  protected int health;


  protected int strenght;
  protected int defence;
  /**
   * retourne la liste des score de caracteristique .
   */

  public ArrayList<ScoreDeCaracteristique> getCaracteristiques() {
    return caracteristiques;
  }

  /**
   * Constructeur .
   */
  public Builder(String name, int init,  int posX, int posY,
                 int health, int strenght, int defence) {
    this.name = name;
    this.posX = posX;
    this.posY = posY;
    this.init = init;
    this.health = health;

    this.strenght = strenght;
    this.defence = defence;
    caracteristiques = new ArrayList<>();
    this.order = new ArrayList<>();
    order.add(Caracteristique.Force);
    order.add(Caracteristique.Dextérité);
    order.add(Caracteristique.Constitution);
    order.add(Caracteristique.Intelligence);
    order.add(Caracteristique.Sagesse);
    order.add(Caracteristique.Charisme);
    randomCaracteristique(order);

  }

  /**
   * getCarScore .
   */
  public int getCarScore(Caracteristique c) {
    for (ScoreDeCaracteristique sc : this.caracteristiques) {
      if (sc.getcaracteristique().equals(c)) {
        return sc.getValue();
      }
    }
    return -1;
  }

  protected void randomCaracteristique(ArrayList<Caracteristique> order) {
    Random random = new Random();
    ArrayList<Integer> caracteristiqueValues = new ArrayList<>();
    ArrayList<Integer> randomValues;
    int index;
    int i = 0;
    int result;
    int sum;
    do {
      randomValues = new ArrayList<>();
      sum = 0;
      for (index = 0; index < Caracteristique.values().length; index++) {

        int tmp = 3 + random.nextInt(18 - 3);
        randomValues.add(tmp);
        sum = sum + tmp;


      }
    } while ((80 < sum) || (sum < 65));

    caracteristiqueValues = randomValues;
    for (Caracteristique c : order) {
      caracteristiques.add(new ScoreDeCaracteristique(c, caracteristiqueValues.get(i)));
      i++;
    }
    Collections.sort(caracteristiques, new ScoreDeCaracteristiqueComparator());


  }

  /**
   * Priorité .
   */
  public  boolean priorite(ArrayList<Integer> tabpriorite) {
    if (tabpriorite.size() == caracteristiques.size()) {
      ArrayList<Integer> copy = new ArrayList<>();
      for (ScoreDeCaracteristique sc : caracteristiques) {

        copy.add(sc.getValue());

      }
      for (int i = 0; i < tabpriorite.size(); i++) {
        int j = tabpriorite.get(i);
        caracteristiques.get(i).setValue(copy.get(j));

      }
      Collections.sort(caracteristiques, new ScoreDeCaracteristiqueComparator());
      return true;

    } else {
      return  false;

    }
  }

  /**
   * valeur .
   */
  public boolean valeur(Caracteristique c, int v) {
    boolean flag = false;
    if (c != null && (v >= 1 && v <= 20)) {
      for (ScoreDeCaracteristique sc : caracteristiques) {
        if (sc.getcaracteristique().equals(c)) {
          sc.setValue(v);
          flag = true;
          break;
        }
      }
      Collections.sort(caracteristiques, new ScoreDeCaracteristiqueComparator());


    }
    return flag;




  }




}