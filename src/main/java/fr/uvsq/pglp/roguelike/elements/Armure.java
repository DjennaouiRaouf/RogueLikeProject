package fr.uvsq.pglp.roguelike.elements;

import fr.uvsq.pglp.roguelike.utils.Functions;

/**
 * Class Armure .
 */
public class Armure {
  public static Armure normal = new Armure(" ", 0, 0);
  public static Armure cuir = new Armure("Cuir", 2, 4);
  public static Armure demiPlaque = new Armure("DemiPlaque", 3, 8);
  public static Armure plaqueComplete = new Armure("PlaqueComplete", 8, 20);
  public static Armure grandBouclier = new Armure("GrandBouclier", 2, 4);




  private String name;
  private int def;
  private int price;


  /**Creates an Armor object.*/
  public Armure(String name, int def, int price) {
    this.name = name;
    this.def = def;
    this.price = price;
  }

  /**Getter Method .*/
  public int getDef() {
    return def;
  }
  
  /**Getter Method .*/
  public String getName() {
    return name;
  }
  

  /**Getter Method .*/
  public int getPrice() {
    return price;
  }

  /**Gets a random type of weapon .
   * return a random Weapon.Type among all the available ones .*/
  public static Armure getRandomArmor() {
    int choice = Functions.getRandomNumber(4);
    if (choice == 1) {
      return cuir;
    } else if (choice == 2) {
      return demiPlaque;
    } else if (choice == 3) {
      return plaqueComplete;
    } else if (choice == 4) {
      return grandBouclier;
    } else {
      return normal;
    }
  }
}

