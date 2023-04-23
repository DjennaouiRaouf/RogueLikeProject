package fr.uvsq.pglp.roguelike.elements;

import fr.uvsq.pglp.roguelike.utils.ResourceManager;
import fr.uvsq.pglp.roguelike.utils.Tile;
import java.util.ArrayList;
import java.util.Random;

/**
 * Strategy .
 */

public enum Strategy {


  RAND {
    /**
     * random .
     */
    public ArrayList<ArrayList<Tile>> build(ArrayList<ArrayList<Tile>> tiles, int floorNumber) {
      System.out.println("[Floor]: Creating floor" + floorNumber);

      tiles = new ArrayList<ArrayList<Tile>>();

      ArrayList<String> strs = ResourceManager.readFloorFile("src/main/resources/floors/floor"
          + floorNumber + ".txt");

      for (int i = 0; i < strs.size() - 1; i++) {
        char[] charray = strs.get(i).toCharArray();
        tiles.add(new ArrayList<Tile>());
        for (int j = 0; j < charray.length; j++) {
          switch (charray[j]) {
            case '.':
              tiles.get(i).add(Tile.NOTHING);
              break;
            case '#':
              tiles.get(i).add(Tile.WALL);
              break;
            case 'A':
              tiles.get(i).add(Tile.PLAYER);
              break;
            case '^':
              tiles.get(i).add(Tile.STAIRS);
              break;
            case ',':
              tiles.get(i).add(Tile.TRAP);
              break;
            case 'p':
              tiles.get(i).add(Tile.HP_POTION);
              break;
            case 'G':
              tiles.get(i).add(Tile.GOLD);
              break;
            case 'T':
              tiles.get(i).add(Tile.TREASURE);
              break;
            case '!':
              tiles.get(i).add(Tile.KEY);
              break;
            case '/':
              tiles.get(i).add(Tile.DOOR);
              break;

            case 'F':
              tiles.get(i).add(Tile.FRIENDLY);
              break;
            case 'V':
              tiles.get(i).add(Tile.VENDEUR);
              break;
            case 'M':
              tiles.get(i).add(Tile.MONSTER);
              break;
            default:
              break;
          }
        }
      }

      Random random = new Random();
      for (int i = 0; i < tiles.size(); i++) {
        for (int j = 0; j < tiles.get(i).size(); j++) {
          Tile value = tiles.get(i).get(j);
          if (value != Tile.WALL) {
            int newi;
            int newj;
            do {
              newi = random.nextInt(tiles.size());
              newj = random.nextInt(tiles.get(i).size());
            } while (tiles.get(newi).get(newj) != Tile.NOTHING);
            tiles.get(newi).set(newj, value);
            tiles.get(i).set(j, Tile.NOTHING);
          }




        }
      }


      return tiles;

    }

  },
  PREDEFF {
    /**
     * predifined .
     */
    public ArrayList<ArrayList<Tile>> build(ArrayList<ArrayList<Tile>> tiles, int floorNumber) {
      System.out.println("[Floor]: Creating floor" + floorNumber);

      tiles = new ArrayList<ArrayList<Tile>>();

      ArrayList<String> strs = ResourceManager.readFloorFile("src/main/resources/floors/floor"
          + floorNumber + ".txt");

      for (int i = 0; i < strs.size() - 1; i++) {
        char[] charray = strs.get(i).toCharArray();
        tiles.add(new ArrayList<Tile>());
        for (int j = 0; j < charray.length; j++) {
          switch (charray[j]) {
            case '.':
              tiles.get(i).add(Tile.NOTHING);
              break;
            case '#':
              tiles.get(i).add(Tile.WALL);
              break;
            case 'A':
              tiles.get(i).add(Tile.PLAYER);
              break;
            case '^':
              tiles.get(i).add(Tile.STAIRS);
              break;
            case ',':
              tiles.get(i).add(Tile.TRAP);
              break;
            case 'p':
              tiles.get(i).add(Tile.HP_POTION);
              break;
            case 'G':
              tiles.get(i).add(Tile.GOLD);
              break;
            case 'T':
              tiles.get(i).add(Tile.TREASURE);
              break;
            case '!':
              tiles.get(i).add(Tile.KEY);
              break;
            case '/':
              tiles.get(i).add(Tile.DOOR);
              break;

            case 'F':
              tiles.get(i).add(Tile.FRIENDLY);
              break;
            case 'V':
              tiles.get(i).add(Tile.VENDEUR);
              break;
            case 'M':
              tiles.get(i).add(Tile.MONSTER);
              break;
            default:
              break;
          }
        }
      }
      return tiles;

    }


  };
  public abstract  ArrayList<ArrayList<Tile>> build(ArrayList<ArrayList<Tile>> tiles,
                                                     int floorNumber);



}
