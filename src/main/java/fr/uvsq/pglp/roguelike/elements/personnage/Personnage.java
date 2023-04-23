package fr.uvsq.pglp.roguelike.elements.personnage;

import fr.uvsq.pglp.roguelike.utils.Direction;
import java.util.ArrayList;

/**
 * Entity .
 */
public class Personnage {

  protected ArrayList<ScoreDeCaracteristique> caracteristiques;

  protected int posX;
  protected int posY;

  protected float health;
  protected int maxHealth;

  protected int strenght;
  protected int defence;


  /**
   * Creates a moving tile objecte .
   */
  protected Personnage(Builder b) {
    this.setPos(b.posX, b.posY);
    this.health = b.health;
    this.maxHealth = b.health;
    this.strenght = b.strenght; 
    this.defence = b.defence;
    this.caracteristiques = b.caracteristiques;
  }

  /**Setter Method.
   * Position on the x coordinate .
   * Position on the y coordinate .*/
  public void setPos(int posX, int posY) {
    this.posX = posX;
    this.posY = posY;
  }

  /**Getter Method.*/
  public int getX() {
    return posX;
  }

  /**Getter Method.*/
  public int getY() {
    return posY;
  }

  /**Getter Method.*/
  public float getHp() {
    return health;
  }

  /**Getter Method .*/
  public int getMaxhp() {
    return maxHealth;
  }

  /**Getter Method.*/
  public int getStr() {
    return strenght;
  }

  /**Getter Method.*/
  public int getDef() {
    return defence;
  }

  /**Reduces health.
   * The amount of health to take from the tile.*/
  public void damage(float amount) {
    this.health -= amount;
  }

  /**Restores health.
   * The amount of health to give to the tile.*/
  public void heal(int amount) {
    this.health += amount;
    if (health > maxHealth) {
      health = maxHealth;
    }
  }

  /**Changes the position of the tile.
   * Determines the new position of the tile.*/
  protected void move(Direction dir) {
    switch (dir) {
      case FOWARD:
        this.posY--;
        break;
      case LEFT:
        this.posX--;
        break;
      case BACKWARDS:
        this.posY++;
        break;
      case RIGHT:
        this.posX++; 
        break;
      default:
        break;
    }
  }
}
