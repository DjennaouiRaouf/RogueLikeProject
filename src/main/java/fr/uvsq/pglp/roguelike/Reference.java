package fr.uvsq.pglp.roguelike;


import fr.uvsq.pglp.roguelike.elements.Donjon;
import fr.uvsq.pglp.roguelike.elements.personnage.Pj;
import fr.uvsq.pglp.roguelike.elements.personnage.Pnj;
import java.util.ArrayList;

/**
 * Reference .
 */
public class Reference {

  public static final int windowWidth = 1000;
  public static final int windowHeight = 600;

  public static final int floorCount = 5;

  public static Donjon currentDonjon;
  public static Pj pj;
  public static ArrayList<Pnj> pnjs;
  public static ArrayList<Pnj> friendlies;
  public static ArrayList<Pnj> vendeurs;


}
