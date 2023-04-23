package fr.uvsq.pglp.roguelike.utils;

/**
 * Tile .
 * */

public enum Tile {

  NOTHING('.'),
  WALL('#'),
  PLAYER('A'),
  STAIRS('^'),
  TRAP(','),
  HP_POTION('p'),
  GOLD('G'),
  TREASURE('T'),
  KEY('!'),
  DOOR('/'),
  VENDEUR('V'),
  FRIENDLY('F'),
  MONSTER('M');




  private char symbol;

  Tile(char symbol) {
    this.symbol = symbol;
  }

  public char symbol() {
    return symbol;
  }
}
