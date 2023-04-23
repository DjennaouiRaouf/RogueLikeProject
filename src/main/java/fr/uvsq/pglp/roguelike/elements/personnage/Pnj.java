package fr.uvsq.pglp.roguelike.elements.personnage;

import fr.uvsq.pglp.roguelike.Reference;
import fr.uvsq.pglp.roguelike.elements.Status;
import fr.uvsq.pglp.roguelike.utils.Direction;
import fr.uvsq.pglp.roguelike.utils.Functions;
import fr.uvsq.pglp.roguelike.utils.Tile;

/**
 * Monster .
 */
public class Pnj extends Personnage {

  private String name;
  private Status status;
  /**Creates a monster . */

  public Pnj(Builder b, Status status) {
    super(b);
    this.status = status;
    System.out.println("[Monster]: Creating monster");
  }

  public Status getStatus() {
    return this.status;
  }

  /**Moves the monster in a random direction.*/
  public void moveRandom() {
    if (status != Status.VENDEUR) {
      switch (Functions.getRandomNumber(4)) {
        case 1:
          if (Reference.currentDonjon.getTile(this.getX(), this.getY() - 1) == Tile.NOTHING) {
            super.move(Direction.FOWARD);
          } else if (Reference.currentDonjon.getTile(this.getX(), this.getY() - 1) == Tile.PLAYER) {
            Functions.monsterEncounter(Direction.FOWARD);
          }
          break;
        case 2:
          if (Reference.currentDonjon.getTile(this.getX() - 1, this.getY()) == Tile.NOTHING) {
            super.move(Direction.LEFT);
          } else if (Reference.currentDonjon.getTile(this.getX() - 1, this.getY()) == Tile.PLAYER) {
            Functions.monsterEncounter(Direction.LEFT);
          }
          break;
        case 3:
          if (Reference.currentDonjon.getTile(this.getX(), this.getY() + 1) == Tile.NOTHING) {
            super.move(Direction.BACKWARDS);
          } else if (Reference.currentDonjon.getTile(this.getX(), this.getY() + 1) == Tile.PLAYER) {
            Functions.monsterEncounter(Direction.BACKWARDS);
          }
          break;
        case 4:
          if (Reference.currentDonjon.getTile(this.getX() + 1, this.getY()) == Tile.NOTHING) {
            super.move(Direction.RIGHT);
          } else if (Reference.currentDonjon.getTile(this.getX() + 1, this.getY()) == Tile.PLAYER) {
            Functions.monsterEncounter(Direction.RIGHT);
          }
          break;
        default:
          break;
      }
    } else {
      switch (Functions.getRandomNumber(4)) {
        case 1:
          if (Reference.currentDonjon.getTile(this.getX(), this.getY() - 1) == Tile.NOTHING) {
            super.move(Direction.FOWARD);
          } else if (Reference.currentDonjon.getTile(this.getX(), this.getY() - 1) == Tile.PLAYER) {
            Functions.vendeurEncounter(Direction.FOWARD);
          }
          break;
        case 2:
          if (Reference.currentDonjon.getTile(this.getX() - 1, this.getY()) == Tile.NOTHING) {
            super.move(Direction.LEFT);
          } else if (Reference.currentDonjon.getTile(this.getX() - 1, this.getY()) == Tile.PLAYER) {
            Functions.vendeurEncounter(Direction.LEFT);
          }
          break;
        case 3:
          if (Reference.currentDonjon.getTile(this.getX(), this.getY() + 1) == Tile.NOTHING) {
            super.move(Direction.BACKWARDS);
          } else if (Reference.currentDonjon.getTile(this.getX(), this.getY() + 1) == Tile.PLAYER) {
            Functions.vendeurEncounter(Direction.BACKWARDS);
          }
          break;
        case 4:
          if (Reference.currentDonjon.getTile(this.getX() + 1, this.getY()) == Tile.NOTHING) {
            super.move(Direction.RIGHT);
          } else if (Reference.currentDonjon.getTile(this.getX() + 1, this.getY()) == Tile.PLAYER) {
            Functions.vendeurEncounter(Direction.RIGHT);
          }
          break;
        default:
          break;
      }

    }
  }



  /**Getter Method.*/
  public String getName() {
    return name;
  }

}
