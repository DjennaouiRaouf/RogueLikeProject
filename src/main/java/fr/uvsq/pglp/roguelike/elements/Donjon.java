package fr.uvsq.pglp.roguelike.elements;

import fr.uvsq.pglp.roguelike.Reference;
import fr.uvsq.pglp.roguelike.utils.Tile;
import java.util.ArrayList;

/**
 * Floor .
 */
public class Donjon {

  private ArrayList<ArrayList<Tile>> tiles;
  private boolean firstFloor;
  private Strategy strategy;

  /**Creates a floor.
   * The ordinal number of this floor in the file .*/
  public Donjon(int floorNumber, Strategy strategy) {
    this.strategy = strategy;
    tiles = strategy.build(tiles, floorNumber);
    if (floorNumber == 0) {
      firstFloor = true;
    } else {
      firstFloor = false;
    }
  }

  /**Gets the size of the floor on the y coordinate.*/
  public int getHeight() {
    return tiles.size();
  }

  /**Gets the size of the floor on the x coordinate .*/
  public int getWidth() {
    return tiles.get(0).size();
  }

  /**Returns one tile of the floor.
   * The x coordinate of the tile.
   * The y coordinate of the tile.*/
  public Tile getTile(int x, int y) {
    return tiles.get(y).get(x);
  }

  /**Returns one tile of the floor.
   * The x coordinate of the tile.
   * The y coordinate of the tile.*/
  public char getTileChar(int x, int y) {
    return tiles.get(y).get(x).symbol();
  }

  /**Updates the position of the player.*/
  public void updatePlayerPos() {
    //Deletes old pos
    for (int i = 0; i < this.getHeight(); i++) {
      for (int j = 0; j < this.getWidth(); j++) {
        if (tiles.get(i).get(j) == Tile.PLAYER) {
          tiles.get(i).set(j, Tile.NOTHING);
        }

      }
    }
    //Sets new pos
    tiles.get(Reference.pj.getY()).set(Reference.pj.getX(), Tile.PLAYER);
  }

  /**
   * setVendeurPos.
   */
  public void setVendeurPos() {
    //Deletes old pos
    for (int i = 0; i < this.getHeight(); i++) {
      for (int j = 0; j < this.getWidth(); j++) {
        if (tiles.get(i).get(j) == Tile.VENDEUR) {
          tiles.get(i).set(j, Tile.VENDEUR);
        }
      }
    }

  }

  /**Updates the position of the monsters.*/
  public void updateMonstersPos() {
    //Deletes old pos
    for (int i = 0; i < this.getHeight(); i++) {
      for (int j = 0; j < this.getWidth(); j++) {
        if (tiles.get(i).get(j) == Tile.MONSTER) {
          tiles.get(i).set(j, Tile.NOTHING);
        }

      }
    }
    //Sets new pos
    for (int i = 0; i < Reference.pnjs.size(); i++) {
      if (Reference.pnjs.get(i).getHp() <= 0) {
        Reference.pnjs.remove(i);
      } else {
        tiles.get(Reference.pnjs.get(i).getY()).set(Reference.pnjs.get(i).getX(),
            Tile.MONSTER);
      }

    }

  }

  /**
   * Update Pos .
   */
  public void updateFriendliesPos() {
    //Deletes old pos
    for (int i = 0; i < this.getHeight(); i++) {
      for (int j = 0; j < this.getWidth(); j++) {
        if (tiles.get(i).get(j) == Tile.FRIENDLY) {
          tiles.get(i).set(j, Tile.NOTHING);
        }

      }
    }
    //Sets new pos
    for (int i = 0; i < Reference.friendlies.size(); i++) {
      if (Reference.friendlies.get(i).getHp() <= 0) {
        Reference.friendlies.remove(i);
      } else {
        tiles.get(Reference.friendlies.get(i).getY()).set(Reference.friendlies.get(i).getX(),
            Tile.FRIENDLY);
      }

    }

  }


  /**Getter Method.
   * true if this is floor0. */
  public boolean isFirstFloor() {
    return firstFloor;
  }
}
