package fr.uvsq.pglp.roguelike.elements.personnage;

import fr.uvsq.pglp.roguelike.elements.Arme;
import fr.uvsq.pglp.roguelike.elements.Armure;
import fr.uvsq.pglp.roguelike.utils.Direction;

/**
 * Player .
 */
public class Pj extends Personnage {

  private Direction facing;
  private int gold;
  private int keys;
  private Arme equippedArme;
  private Armure equippedArmure;
  private boolean alive;

  /**Calls super(int, int) and prints a message to the console .
   */
  public Pj(Builder b) {
    //super(posX, posY, 20, 1, 1);
    super(b);
    this.gold = 0;
    this.equippedArme = Arme.hand;
    this.equippedArmure = Armure.normal;
    this.alive = true;
    System.out.println("[Player]: Created player");
  }

  @Override
  public void move(Direction dir) {
    super.move(dir);
  }

  /**Moves the player in the direction it's facing .*/
  public void move() {
    this.move(facing);
  }

  /**Setter Method .*/
  public void setFacing(Direction dir) {
    this.facing = dir;
  }

  /**Getter Method .*/
  public int getGold() {
    return gold;
  }

  /**Adds gold to the player .
   * The amount of gold to add .*/
  public void addGold(int amount) {
    gold += amount;
  }

  /**Removes gold from the player.
   * The amount of gold to add .*/
  public void takeGold(int amount) {
    gold -= amount;
  }

  /**Getter Method .*/
  public int getKeys() {
    return keys;
  }

  /**Adds 1 key to the player.*/
  public void addKey() {
    keys++;
  }

  /**Removes 1 key from the player.*/
  public void takeKey() {
    if (keys > 0) {
      keys--;
    }
  }

  /**Setter Method - Gives a weapon to the player .
   * The weapon to equip .*/
  public void equipWeapon(Arme arme) {
    this.equippedArme = arme;
    this.strenght = 1;
    this.strenght += this.equippedArme.getDmg();

  }

  /**Setter Method - Gives an armor to the player .
   * The armor to equip .*/
  public void equipArmor(Armure armure) {
    this.equippedArmure = armure;
    this.defence = 1;
    this.defence += this.equippedArmure.getDef();
  }


  /**Getter Method.*/
  public Arme getWeapon() {
    return equippedArme;
  }

  /**Getter Method .*/
  public Armure getArmor() {
    return equippedArmure;
  }

  /**Getter Method.
   * returns true if the player is alive.*/
  public boolean isAlive() {
    return alive;
  }
  
  /**Sets isAlive() to false .*/
  public void setDead() {
    this.alive = false;
  }
}