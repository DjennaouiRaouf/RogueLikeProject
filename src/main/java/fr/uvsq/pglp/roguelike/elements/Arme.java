package fr.uvsq.pglp.roguelike.elements;

import fr.uvsq.pglp.roguelike.utils.Functions;

/**
 * Weapon .
 */
public class Arme {

  public static Arme hand = new Arme(" ", 0, 0);
  public static Arme baton_ferre = new Arme("Baton_ferre", 6, 2);
  public static Arme dague = new Arme("Dague", 4, 3);
  public static Arme epeelongue = new Arme("Epee_longue", 8, 6);
  public static Arme katana = new Arme("Katana", 10, 12);


  private String name;
  private int dmg;

  private  int price;

  /**
   * Creates a Weapon object.
   */

  public Arme() {

  }

  /**
   *Constructor .
   */
  public Arme(String name, int dmg, int price) {
    this.name = name;
    this.dmg = dmg;
    this.price = price;
  }

  /**Getter Method .*/
  public int getDmg() {
    return dmg;
  }

  /**Getter Method. */
  public String getName() {
    return name;
  }

  /**Getter Method .*/
  public int getPrice() {
    return price;
  }



  /**Gets a random type of weapon.
   * returns a random Weapon.Type among all the available ones .*/
  public static Arme getRandomWeapon() {
    int choice = Functions.getRandomNumber(4);
    if (choice == 1) {
      return baton_ferre;
    } else if (choice == 2) {
      return dague;
    } else if (choice == 3) {
      return epeelongue;
    } else if (choice == 4) {
      return katana;
    } else {
      return hand;
    }

  }
}
