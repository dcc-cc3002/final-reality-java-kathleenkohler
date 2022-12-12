package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippedWeapon;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.Normal;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Class to define the game controller.
 */
public class Game {

  private Player player;
  public ArrayList<AbstractPlayerCharacter> characterInventory = new ArrayList<>();
  public ArrayList<AbstractPlayerCharacter> playerCharacterInventory = new ArrayList<>();
  public ArrayList<Enemy> enemies = new ArrayList<>();
  private BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
  private final int maxNumberOfEnemies = 9;
  private int num0fEnemies = 1;
  public int turn = 1;
  Scanner sc = new Scanner(System.in);

  /**
   * Set up a character inventory.
   */
  public void setChracterInventory() throws InvalidStatValueException {
    BlackMage blackMage1 = new BlackMage("BlackMage1", 70, 15, 40, queue);
    characterInventory.add(blackMage1);
    BlackMage blackMage2 = new BlackMage("BlackMage2", 60, 10, 70, queue);
    characterInventory.add(blackMage2);
    WhiteMage whiteMage1 = new WhiteMage("WhiteMage1", 75, 18, 45, queue);
    characterInventory.add(whiteMage1);
    WhiteMage whiteMage2 = new WhiteMage("WhiteMage2", 60, 10, 60, queue);
    characterInventory.add(whiteMage2);
    Thief thief1 = new Thief("Thief1", 100, 10, queue);
    characterInventory.add(thief1);
    Thief thief2 = new Thief("Thief2", 70, 20, queue);
    characterInventory.add(thief2);
    Knight knight1 = new Knight("Knight1", 85, 15, queue);
    characterInventory.add(knight1);
    Knight knight2 = new Knight("Knight2", 95, 12, queue);
    characterInventory.add(knight2);
    Engineer engineer1 = new Engineer("Engineer1", 80, 20, queue);
    characterInventory.add(engineer1);
    Engineer engineer2 = new Engineer("Engineer2", 100, 15, queue);
    characterInventory.add(engineer2);
  }

  /*



  public void startGame() throws IOException, InvalidStatValueException, InvalidEquippedWeapon {
    setChracterInventory();
    System.out.print("Character Inventory:\n");
    for (int i = 0; i < characterInventory.size(); i++) {
      System.out.print((i + 1) + ". " + characterInventory.get(i) + "\n");
    }
    for (int i = 0; i < 4; i++) {
      int c1;
      System.out.print("Choose the number of your character number " + (i + 1) + " \n");
      c1 = sc.nextInt();
      //ME CAGA SI NO ES UN NUMERO
      while (c1 < 1 || c1 > 10) {
        System.out.print("Invalid number, try again \n");
        c1 = sc.nextInt();
      }
      playerCharacterInventory.add(characterInventory.get(c1 - 1));
    }
    player = new Player(playerCharacterInventory.get(0), playerCharacterInventory.get(1),
          playerCharacterInventory.get(2), playerCharacterInventory.get(3));
    System.out.print("Your characters are: \n");
    for (int i = 0; i < playerCharacterInventory.size(); i++) {
      System.out.print(playerCharacterInventory.get(i).toString() + "\n");
    }
    System.out.print("\n");

    player.setInventory();
    System.out.print("Now you have to choose a weapon for each character \n");
    for (int i = 0; i < player.inventory.size(); i++) {
      System.out.print((i + 1) + ". " + player.inventory.get(i) + "\n");
    }
    for (int i = 0; i < playerCharacterInventory.size(); i++) {
      int c5;
      System.out.print("Choose a weapon number for " + playerCharacterInventory.get(i) + "\n");
      c5 = sc.nextInt();
      int b = 0;
      while (c5 < 1 || c5 > 6 || b == 0) {
        if (c5 < 1 || c5 > 6) {
          System.out.print("Invalid number, try again \n");
          c5 = sc.nextInt();
        } else {
          try {
            playerCharacterInventory.get(i).equip(player.inventory.get(c5 - 1));
            b = 1;
          } catch (InvalidEquippedWeapon invalidEquippedWeapon) {
            System.out.print("The provided weapon is not equippable by that character.\n");
            System.out.print("Try again \n");
            c5 = sc.nextInt();
          }
        }
      }
    }
    int e1;
    System.out.print("How many enemies do you want to fight?(the minimum is one) \n");
    e1 = sc.nextInt();
    sc.nextLine();
    if (e1 > maxNumberOfEnemies) {
      System.out.print("That amount exceeds the maximum number of possible enemies,"
            + " it will be set to the maximum possible \n");
      num0fEnemies = maxNumberOfEnemies;
    } else if (e1 < 1) {
      System.out.print("that amount is less than the minimum number of possible enemies,"
            + " it will be set to the minimum possible\n");
      num0fEnemies = 1;
    } else {
      num0fEnemies = e1;
    }
    enemiess(num0fEnemies);
  }

   */

  /**
   * Create the requested number of enemies.
   */
  public void enemiess(int ne) throws InvalidStatValueException {
    for (int i = 1; i < ne + 1; i++) {
      Random random = new Random();
      int ranWeight = random.nextInt(10, 30);
      int ranHp = random.nextInt(50, 80);
      int ranDefense = random.nextInt(5, 15);
      int ranDamage = random.nextInt(15, 30);
      enemies.add(new Enemy("Enemy" + i, ranWeight, ranHp, ranDefense, ranDamage, queue));
    }
  }
  /*
  public boolean loop() throws IOException, InvalidStatValueException, InvalidEquippedWeapon {
    boolean a = false;
    while (!a) {
      if (turn == 1) {
        gameState();
        System.out.print("It's your turn now\n");
        playerTurn();
        swapTurn();
      } else {
        System.out.print("It's the enemy's turn\n");
        System.out.print("\n");
        enemyTurn();
        swapTurn();
      }
      a = gameOver();
    }
    return a;
    // va a devolver true si el juego se acaba
  }}*/

  /**
   * Change current turn.
   */
  public void swapTurn() {
    turn = (turn == 1) ? 0 : 1;
  }

  /*
  public void gameState() {
    System.out.print("Current state of the game:\n");
    System.out.print("\n");
    System.out.print("Characters:\n");
    for (int i = 0; i < playerCharacterInventory.size(); i++) {
      System.out.print((i + 1) + " " + playerCharacterInventory.get(i).toString() + "\n");
      System.out.print(playerCharacterInventory.get(i).getEquippedWeapon() + "\n");
    }
    System.out.print("\n");
    System.out.print("Enemies:\n");
    for (int i = 0; i < enemies.size(); i++) {
      System.out.print((i + 1) + " " + enemies.get(i).toString() + "\n");
    }
  }

   */
  /*
  public void enemyTurn() throws InvalidStatValueException {
    Random random = new Random();
    int ranInt = random.nextInt(0, playerCharacterInventory.size() - 1);
    int ranIntt = random.nextInt(0, enemies.size() - 1);
    if (enemies.get(ranIntt).getCurrentHp() > 0
          && playerCharacterInventory.get(ranInt).getCurrentHp() > 0) {
      if (enemies.get(ranIntt).isParalyzed()) {
        System.out.print(enemies.get(ranIntt) + "is paralyzed" + "\n");
        Normal normal = new Normal(0);
        enemies.get(ranIntt).setState(normal);
        //imprimir algo
        return;
      } else {
        if (enemies.get(ranIntt).isBurned()) {
          if (enemies.get(ranIntt).getCurrentHp()
                - (int) (enemies.get(ranIntt).getState().getMagiDam() / 2) <= 0) {
            enemies.get(ranIntt).setCurrentHp(0);
            System.out.print(enemies.get(ranIntt) + "has died from being burned" + "\n");
            return;
          } else {
            enemies.get(ranIntt).setCurrentHp(enemies.get(ranIntt).getCurrentHp()
                  - (int) enemies.get(ranIntt).getState().getMagiDam() / 2);
          }
        } else if (enemies.get(ranIntt).isPoisoned()) {
          if (enemies.get(ranIntt).getCurrentHp()
                - (int) (enemies.get(ranIntt).getState().getMagiDam() / 3) <= 0) {
            enemies.get(ranIntt).setCurrentHp(0);
            System.out.print(enemies.get(ranIntt) + "has died from being poisoned" + "\n");
            return;
          } else {
            enemies.get(ranIntt).setCurrentHp(enemies.get(ranIntt).getCurrentHp()
                  - (int) enemies.get(ranIntt).getState().getMagiDam() / 3);
          }
        }
        if (enemies.get(ranIntt).getCurrentHp() > 0) {
          enemies.get(ranIntt).attack(playerCharacterInventory.get(ranInt));
          System.out.print(enemies.get(ranIntt) + "\n");
          System.out.print("has attacked the\n");
          System.out.print(playerCharacterInventory.get(ranInt) + "\n");
          System.out.print("\n");
        }
      }
    } else {
      enemyTurn();
    }
  }
*/

  /*



  public void playerTurn() throws IOException, InvalidStatValueException, InvalidEquippedWeapon {
    String a1;
    System.out.print("Do you want to change the weapon, "
          + "attack or use a spell(only for mages characters)?");
    a1 = sc.nextLine();
    if (a1.equals("change the weapon")) {
      playerChangeWeapon();
      playerTurn();
    } else if (a1.equals("use a spell")) {
      playerSpell();
    } else if (a1.equals("attack")) {
      playerAttack();
    } else {
      System.out.print("Invalid move, try again\n");
      playerTurn();
    }
  }

  public void playerSpell() {
    int c1;
    System.out.print("(put the number)\n"); //suena feo // con que personaje quieres hechizar(??
    c1 = sc.nextInt();;
    if (playerCharacterInventory.get(c1 - 1).getCurrentHp() < 0) {
      System.out.print("That character is dead, try again\n");
      playerSpell();
    } else {
      String c2;
      System.out.print("Which spell?");
      c2 = sc.nextLine();
      sc.nextLine();
      if (c2.equals("cure")) {
        String c3;
        System.out.print("Which of your characters do you want to heal?");


      } else if (c2.equals("thunder")) {
        String c3;
        System.out.print("Which enemy do you want to spell?");
        c3 = sc.next();;

      } else if (c2.equals("fire")) {
        String c3;
        System.out.print("Which enemy do you want to spell?");
        c3 = sc.next();
      } else if (c2.equals("paralysis")) {
        String c3;
        System.out.print("Which enemy do you want to spell?");
        c3 = sc.next();
      } else if (c2.equals("poison")) {
        String c3;
        System.out.print("Which enemy do you want to spell?");
        c3 = sc.next();
      }
    }
  }

  public void playerAttack() throws IOException, InvalidStatValueException {
    int c1;
    System.out.print("Which of your characters do you want to attack with??(put the number)\n");
    c1 = sc.nextInt();
    if (playerCharacterInventory.get(c1 - 1).getCurrentHp() < 0) {
      System.out.print("That character is dead, try again\n");
      playerAttack();
    } else if (c1 < 1 || c1 > 10) {
      System.out.print("Invalid number, try again\n");
      playerAttack();
    } else {
      int c2;
      System.out.print("Which enemy do you want to attack?(put the number)\n");
      c2 = sc.nextInt();
      sc.nextLine();

      while (enemies.get(c2 - 1).getCurrentHp() < 0 || c2 < 1 || c2 > 6) {
        System.out.print("That enemy is dead or number out of range, try again\n");
        c2 = sc.nextInt();
      }
      playerCharacterInventory.get(c1 - 1).attack(enemies.get(c2 - 1));
      System.out.print(playerCharacterInventory.get(c1 - 1) + "\n");
      System.out.print("has attacked the\n");
      System.out.print(enemies.get(c2 - 1) + "\n");
    }
  }

  public void playerChangeWeapon() throws InvalidEquippedWeapon {
    System.out.print("These are your weapons: \n");
    for (int i = 0; i < player.inventory.size(); i++) {
      System.out.print((i + 1) + ". " + player.inventory.get(i) + "\n");
    }
    int c1;
    System.out.print("Which of your characters do you want to change their equipped weapon?");
    c1 = sc.nextInt();
    int c2;
    System.out.print("Which weapon do you want to use?");
    c2 = sc.nextInt();
    sc.nextLine();

    int b = 0;
    while (c1 < 1 || c1 > 10 || c2 < 1 || c2 > 6 || b == 0) {
      if (c2 < 1 || c2 > 6) {
        System.out.print("Invalid weapon number, try again \n");
        c2 = sc.nextInt();
      } else if (c1 < 1 || c1 > 10) {
        System.out.print("Invalid character number, try again \n");
        c1 = sc.nextInt();
      } else {
        try {
          playerCharacterInventory.get(c1 - 1).equip(player.inventory.get(c2 - 1));
          b = 1;
        } catch (InvalidEquippedWeapon invalidEquippedWeapon) {
          System.out.print("The provided weapon is not equippable by that character.\n");
          System.out.print("Try again another weapon\n");
          c2 = sc.nextInt();
        }
      }
    }
  }
  */

  /**
   * Function that checks if the game is over and who won.
   */
  public boolean gameOver() {
    boolean livingEnemies = false;
    for (int  i = 0; i < enemies.size(); i++) {
      if (enemies.get(i).getCurrentHp() != 0) {
        livingEnemies = true;
        break;
      }
    }

    boolean livingCharacters = false;
    for (int i = 0; i < playerCharacterInventory.size(); i++) {
      if (playerCharacterInventory.get(i).getCurrentHp() != 0) {
        livingCharacters = true;
        break;
      }
    }
    if (!livingCharacters) {
      System.out.print("The enemy won");
      return true;
    } else if (!livingEnemies) {
      System.out.print("You won");
      return true;
    } else {
      return false;
    }
  }
}
