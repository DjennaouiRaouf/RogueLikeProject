package fr.uvsq.pglp.roguelike.utils;


import fr.uvsq.pglp.roguelike.Reference;
import fr.uvsq.pglp.roguelike.elements.Arme;
import fr.uvsq.pglp.roguelike.elements.Armure;
import fr.uvsq.pglp.roguelike.elements.Donjon;
import fr.uvsq.pglp.roguelike.elements.Status;
import fr.uvsq.pglp.roguelike.elements.Strategy;
import fr.uvsq.pglp.roguelike.elements.personnage.Builder;
import fr.uvsq.pglp.roguelike.elements.personnage.Pnj;
import java.util.Random;

/**
 * Functions .
 */
public class Functions {

  /**Initializes all moving tiles in the floor like player etc.*/
  public static void initMovingTiles() {

    Reference.pnjs.clear();
    Reference.friendlies.clear();
    Reference.vendeurs.clear();

    for (int y = 0; y < Reference.currentDonjon.getHeight() - 1; y++) {
      for (int x = 0; x < Reference.currentDonjon.getWidth() - 1; x++) {
        switch (Reference.currentDonjon.getTile(x, y)) {
          case PLAYER:
            Reference.pj.setPos(x, y);
            break;
          case MONSTER:
            Builder monsterbuilder = new Builder("Monster", 0, x, y, 10, 2, 2);
            Reference.pnjs.add(new Pnj(monsterbuilder, Status.DANGEREUX));
            break;
          case FRIENDLY:
            monsterbuilder = new Builder("FRIENDLY", 0, x, y, 10, 2, 2);
            Reference.friendlies.add(new Pnj(monsterbuilder, Status.AMICAL));
            break;
          case VENDEUR:
            monsterbuilder = new Builder("FRIENDLY", 0, x, y, 10, 2, 2);
            Reference.vendeurs.add(new Pnj(monsterbuilder, Status.VENDEUR));
            break;
          default:
            break;
        }
      }
    }
  }

  /**Returns a random number between 1 and n .
   * The upper bound (inclusive).
   * a random number between 1 and n .*/
  public static int getRandomNumber(int n) {
    Random rand = new Random();
    return rand.nextInt(n) + 1;
  }

  /**Checks if player can move and calls Reference.player.move(Direction) .
   * direction - The direction the player wants to move.*/
  public static void handlePlayerMovment(Direction direction) {
    //Gets the tile the player is trying to move on
    Tile tile = null;
    switch (direction) {
      case FOWARD:
        tile = Reference.currentDonjon.getTile(Reference.pj.getX(),
            Reference.pj.getY() - 1);
        break;
      case LEFT:
        tile = Reference.currentDonjon.getTile(Reference.pj.getX() - 1,
            Reference.pj.getY());
        break;
      case BACKWARDS:
        tile = Reference.currentDonjon.getTile(Reference.pj.getX(),
            Reference.pj.getY() + 1);
        break;
      case RIGHT:
        tile = Reference.currentDonjon.getTile(Reference.pj.getX() + 1,
            Reference.pj.getY());
        break;
      default:
        break;
    }

    //Handles the player movement
    switch (tile) {
      case NOTHING:
        Reference.pj.move(direction);
        message = " ";
        message2 = " ";
        message3 = " ";
        break; //Move the player if it is in front of one of these tiles
      case WALL:
        message = "";
        message2 = " ";
        message3 = " ";
        break;
      case STAIRS:
        Reference.pj.move(direction);
        Reference.currentDonjon = new Donjon(Functions.getRandomNumber(Reference.floorCount),
            Strategy.PREDEFF);
        message = "Nouvel étage!";
        message2 = " ";
        message3 = " ";
        floorsCleared++;
        Functions.initMovingTiles();
        break; //Randomly change floor
      case TRAP:
        Reference.pj.move(direction);
        Reference.pj.damage(Functions.getRandomNumber(2));
        message = "Piége! Diminussion des points de vie";
        message2 = " ";
        message3 = " ";
        break; //Damage the player of 1 or 2 points
      case HP_POTION:
        message = "t'as trouver une potion de santé! veux tu la prendre?";
        message2 = "   [O] Oui     [N] Non";
        message3 = " ";
        decision = PlayerDecision.DRINK_HP_POTION;
        break; //Ask the player if it want to drink the potion
      case GOLD:
        Reference.pj.move(direction);

        message = "T'as trouver de l'argent!";
        message2 = "";
        message3 = "";
        Reference.pj.addGold(Functions.getRandomNumber(3) + 2);


        break; //Add between 3 and 5 gold

      case TREASURE:
        message = "t'as trouver un trésort!  veux tu l'avoir pour 10 pieces d'argent?";
        message2 = "   [O] Oui     [N] Non";
        message3 = " ";
        decision = PlayerDecision.OPEN_CHEST;
        break; //Ask to open chest



      case KEY:
        Reference.pj.move(direction);
        Reference.pj.addKey();
        message = "T'as trouver une clef!";
        message2 = " ";
        message3 = " ";
        break; //Adds a key
      case DOOR:
        message = "La Porte est fermée... veu tu utiliser la clef pour l'ouvrire?";
        message2 = "   [O] Oui     [N] Non";
        message3 = " ";
        decision = PlayerDecision.OPEN_DOOR;
        break; //Ask to open door

      case VENDEUR:
        message =  " ";
        message2 = " ";
        message3 = " ";
        Functions.vendeurEncounter(direction);
        decision = PlayerDecision.Buy;
        break; //Ask to open door



      case MONSTER:
        message = "";
        message2 = " ";
        message3 = " ";
        Functions.monsterEncounter(direction);
        break; //Handles encounters with monsters


      case FRIENDLY:
        message = "";
        message2 = " ";
        message3 = " ";
        Functions.friendlyEncounter(direction);

        break; //Handles encounters with monsters

      default:
        message = "quelque chose  de bizzar est arrivé...";
        message2 = " ";
        message3 = " ";
        break; //If something glitches out
    }
  }

  /**Called when the player has to make a decision.
   *  yn - True for yes, false for no .*/
  public static void makeDecision(boolean yn) {
    if (decision == PlayerDecision.NONE) {
      return; //Nothing
    } else if (decision == PlayerDecision.DRINK_HP_POTION && yn == true) {
      Reference.pj.heal(Functions.getRandomNumber(5) + 3);
      message = "Points de vie en plus!";
      message2 = " ";
      message3 = " ";
      Reference.pj.move(); //Drink potion
    } else if (decision == PlayerDecision.DRINK_HP_POTION && yn == false) {
      message = "Pas besoin pour le moment...";
      message2 = " ";
      message3 = " "; //Doesn't drink potion
    } else if (decision == PlayerDecision.Buy && yn == true) {
      if (Functions.getRandomNumber(2) == 1) {
        Arme w = Arme.getRandomWeapon();
        int p = w.getPrice();
        if (Reference.pj.getGold() - p >= 0) {
          Reference.pj.takeGold(p);
          Reference.pj.equipWeapon(w);
          message3 = "félicitation t'as acheté une Arme!";
        } else {
          message3 = "Désolé ,pas assez d'argent ";
        }

      } else {
        Armure a = Armure.getRandomArmor();
        int p = a.getPrice();
        if (Reference.pj.getGold() - p >= 0) {
          Reference.pj.takeGold(p);
          Reference.pj.equipArmor(a);
          message3 = "félicitation t'as acheté une Armure!";
        } else {
          message3 = "Désolé ,pas assez d'argent ";
        }
      }
    } else if (decision == PlayerDecision.OPEN_CHEST && yn == true) {
      if (Reference.pj.getGold() >= 10) {
        Reference.pj.takeGold(10);
        message = "t'as ouvert le coffre!";
        message2 = " ";
        message3 = " "; //Open chest

        //Chose weapon or armor
        if (Functions.getRandomNumber(2) == 1) {
          Reference.pj.equipWeapon(Arme.getRandomWeapon());
          message2 = Reference.pj.getWeapon().getName() + " equippé!";
        } else {
          Reference.pj.equipArmor(Armure.getRandomArmor());
          message2 = Reference.pj.getArmor().getName() + " equippé!";
        }
        Reference.pj.move();
      } else {
        message = "T'as pas assez d'argent...";
        message2 = " ";
        message3 = " ";
      }
    } else if (decision == PlayerDecision.OPEN_CHEST && yn == false) {
      message = "J'ai pas envie de l'ouvrire...";
      message2 = " ";
      message3 = " "; //Doesn't open chest
    } else if (decision == PlayerDecision.OPEN_DOOR && yn == true) {
      if (Reference.pj.getKeys() > 0) {
        Reference.pj.takeKey();
        Reference.pj.move();
        message = "T'as ouvert la Porte!";
        message2 = " ";
        message3 = " "; //Open door
      } else {
        message = "Tu n'as pas la clef...";
        message2 = " ";
        message3 = " ";
      }
    } else if (decision == PlayerDecision.OPEN_DOOR && yn == false) {
      message = "";
      message2 = " ";
      message3 = " "; //Doesn't open door
    }
    decision = PlayerDecision.NONE;
  }

  /**Moves all the monsters on the floor .*/
  public static void moveMonsters() {
    for (int i = 0; i < Reference.pnjs.size(); i++) {
      Reference.pnjs.get(i).moveRandom();
    }
  }

  /**Moves Firendlies .*/
  public static void moveFriendlies() {
    for (int i = 0; i < Reference.friendlies.size(); i++) {
      Reference.friendlies.get(i).moveRandom();
    }
  }

  /**
   * when player encounters a riendly .
   */
  public static void friendlyEncounter(Direction direction) {

    int monsterX = 0;
    int monsterY = 0;

    switch (direction) {

      case FOWARD:
        monsterX = Reference.pj.getX();
        monsterY = Reference.pj.getY() - 1;
        break;
      case LEFT:
        monsterX = Reference.pj.getX() - 1;
        monsterY = Reference.pj.getY();
        break;
      case BACKWARDS:
        monsterX = Reference.pj.getX();
        monsterY = Reference.pj.getY() + 1;
        break;
      case RIGHT:
        monsterX = Reference.pj.getX() + 1;
        monsterY = Reference.pj.getY();
        break;
      default:
        break;
    }

    for (int i = 0; i < Reference.friendlies.size(); i++) {

      if (Reference.friendlies.get(i).getX() == monsterX
          && Reference.friendlies.get(i).getY() == monsterY) {
        float playerAttack = Reference.pj.getStr() - (Reference.friendlies.get(i).getDef() / 10)
            * Reference.pj.getStr();
        Reference.friendlies.get(i).damage(playerAttack);
        message2 = "T'as attaqué le PNJ amicale et tu lui a elevé "
            + Reference.friendlies.get(i).getHp() + " Points de vie!";

      }


    }
  }

  /**
   * vendeurEncounter .
   */
  public static void vendeurEncounter(Direction direction) {

    int monsterX = 0;
    int monsterY = 0;

    switch (direction) {
      case FOWARD:
        monsterX = Reference.pj.getX();
        monsterY = Reference.pj.getY() - 1;
        break;
      case LEFT:
        monsterX = Reference.pj.getX() - 1;
        monsterY = Reference.pj.getY();
        break;
      case BACKWARDS:
        monsterX = Reference.pj.getX();
        monsterY = Reference.pj.getY() + 1;
        break;
      case RIGHT:
        monsterX = Reference.pj.getX() + 1;
        monsterY = Reference.pj.getY();
        break;
      default:
        break;
    }

    for (int i = 0; i < Reference.vendeurs.size(); i++) {

      if (Reference.vendeurs.get(i).getX() == monsterX
          && Reference.vendeurs.get(i).getY() == monsterY) {
        message = "Veux tu quelque chose ?";
        message2 = "   [O] Oui     [N] Non";

      }


    }
  }

  /**Makes a monster attack the player and the player attack the monster.
   *  direction - The position of the monster relative to the player.*/
  public static void monsterEncounter(Direction direction) {

    int monsterX = 0;
    int monsterY = 0;

    switch (direction) {
      case FOWARD:
        monsterX = Reference.pj.getX();
        monsterY = Reference.pj.getY() - 1;
        break;
      case LEFT:
        monsterX = Reference.pj.getX() - 1;
        monsterY = Reference.pj.getY();
        break;
      case BACKWARDS:
        monsterX = Reference.pj.getX();
        monsterY = Reference.pj.getY() + 1;
        break;
      case RIGHT:
        monsterX = Reference.pj.getX() + 1;
        monsterY = Reference.pj.getY();
        break;
      default:
    }

    for (int i = 0; i < Reference.pnjs.size(); i++) {

      if (Reference.pnjs.get(i).getX() == monsterX
          && Reference.pnjs.get(i).getY() == monsterY) {
        float playerAttack = Reference.pj.getStr()
            - (Reference.pnjs.get(i).getDef() / 10) * Reference.pj.getStr();
        float monsterAttck = Reference.pnjs.get(i).getStr()
            - (Reference.pj.getDef() / 10) * Reference.pnjs.get(i).getStr();
        Reference.pnjs.get(i).damage(playerAttack);
        Reference.pj.damage(monsterAttck);
        message2 = "T'as attaqué le PNJ aggressif et tu lui a elevé "
            + Reference.pnjs.get(i).getHp() + " Points de vie!";
        message3 = "Le PNJ aggressif t'as attaqué!";
      }


    }
  }

  /**Displays a death message if the player has 0 hp .*/
  public static void checkPlayerDeath() {
    if (Reference.pj.getHp() <= 0) {
      message = "T'es Mort!";
      message2 = "T'as jouer sur  " + floorsCleared + " étages!";
      message3 = "Appuye sur n'importe quel boutton pour continuer";
      Reference.pj.setDead();
    }
  }

  private static String message = " ";
  private static String message2 = " ";
  private static String message3 = " ";
  private static int floorsCleared = 0;

  /**Returns the message to display on the screen .*/
  public static String getMessage() {
    return message;
  }

  /**Returns the second message to display on the screen .*/
  public static String getMessage2() {
    return message2;
  }

  /**Returns the third message to display on the screen .*/
  public static String getMessage3() {
    return message3;
  }

  private static PlayerDecision decision = PlayerDecision.NONE;

  private enum PlayerDecision {
    NONE,
    DRINK_HP_POTION,
    OPEN_CHEST,
    Buy,
    OPEN_DOOR;
  }
}
