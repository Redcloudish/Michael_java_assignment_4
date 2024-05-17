import warrior.*;
import weapon.*;
import armour.*;
import weather.*;
import utility.*;

import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.Random;

public class Warsim {

  // Objects
  public static Scanner input = new Scanner(System.in);
  public static Random randNum = new Random();
  public static Ink ink = new Ink();
  public static Weather weather;
  public static IO io = new IO();

  // Player Objects
  public static Warrior player; // player
  public static Weapon pWeapon; // player weapon
  public static Armour pArmour; // player armour

  // Enemy Objects
  public static Warrior enemy; // enemy
  public static Weapon eWeapon; // enemy weapon
  public static Armour eArmour; // enemy armour

  // Variables
  public static boolean gameOver = false;
  public static boolean playerTurn = true;
  public static boolean specialActive = false;
  public static int choice = 0;
  public static int attackType = 0;
  public static int damage = 0;
  public static int rapidHitCount = 0; // elf
  public static int berserkBonus = 0; // orc
  public static String who = "Player";
  public static String winner = "";

  public static void main(String[] args) {
    ink.welcomeMessage();

    // set a random weather for the battle
    int weatherType = randNum.nextInt(4) + 1;
    createWeather(weatherType);

    String filePath = "./gameSave.txt"; // specify the file path
    File file = new File(filePath); // create the file

    // Check if the file exists
    if (file.exists()) {
      // if the file exists give them the option!
      // Prompt the player to either a) continue b) play new game
      boolean isContinue = ink.continueGame(input);
      if (isContinue) {
        // open save file, returns the newly created objects
        // we then assign those objects to our local object :)
        List<Object> things = io.loadGame(player, pWeapon, pArmour, enemy, eWeapon, eArmour);
        player = (Warrior) things.get(0);
        pWeapon = (Weapon) things.get(1);
        pArmour = (Armour) things.get(2);
        enemy = (Warrior) things.get(3);
        eWeapon = (Weapon) things.get(4);
        eArmour = (Armour) things.get(5);

        // read in stats
        // create objects from stats
        // start the game
      } else {
        createGame(); // there is gameSave but they chose to start a new game
      }
    } else {
      createGame(); // no gameSave file start new game
    }

    ink.printStats(player, enemy);

    // main game loop
    while (!gameOver) { // while the game is NOT over
      if (playerTurn) {
        int choice = ink.printAttackMenu(input, player.getSpecialAvailable()); // add a quit and save game option
        if (choice == 4) { // Surrender option
          winner = "Enemy";
          gameOver = true;
          break;
        }
        if (choice == 3) {
          specialActive = true;
          switch (player.getWarriorType()) {
            case "Human":
              player.heal(player.specialAttack());
              player.specialUsed();
              break;
            case "Elf":
              rapidHitCount = player.specialAttack();
              break;
            case "Orc":
              berserkBonus = player.specialAttack();
              break;
          } // switch
          // elf if
          if (rapidHitCount > 0 && specialActive) {
            int reduction = player.getRapidAttackDecay();
            for (int i = 0; i < rapidHitCount; i++) {
              damage = pWeapon.strike(weather.getSeverity(), attackType, player.getStrength(), player.getDexterity());
              damage = eArmour.reduceDamage(damage - (i * reduction));
              enemy.takeDamage(damage);
              rapidHitCount--;
            } // for
            player.specialUsed();
          } // elf
          // orc if
          if (berserkBonus > 0 && specialActive) {
            damage = pWeapon.strike(weather.getSeverity(), attackType, player.getStrength(), player.getDexterity());
            damage = eArmour.reduceDamage(
              (int) damage + (damage * (berserkBonus / 100)));
            enemy.takeDamage(damage);
            player.specialUsed();
          } // if orc
        } // if

        if (!specialActive) {
          damage = pWeapon.strike(weather.getSeverity(), attackType, player.getStrength(), player.getDexterity());
          damage = eArmour.reduceDamage(damage);
          enemy.takeDamage(damage);
        }

        // checking if the enemy is dead yet
        if (!enemy.isAlive()) {
          winner = "Player";
          gameOver = true;
        }
        specialActive = false;
      } else { // enemy turn code poor AI fool
        System.out.println("Enemy Turn!");
        // Implement enemy attack logic here if necessary
      }
      ink.printStats(player, enemy);
      playerTurn = !playerTurn; // toggle turns
      System.out.println(playerTurn ? "Player's Turn" : "Enemy's Turn");
    } // while()

    ink.printGameOver(winner);
  } // main()

  // Helper Methods
  public static void createWarrior(String who, int choice) {
    if (who.equals("Player")) {
      switch (choice) {
        case 1: // Human
          player = new Human("Human");
          break;
        case 2: // Elf
          player = new Elf("Elf");
          break;
        case 3: // Orc
          player = new Orc("Orc");
          break;
        default:
          System.out.println("oops!");
          break;
      } // switch
    } else {
      switch (choice) {
        case 1: // Human
          enemy = new Human("Human");
          break;
        case 2: // Elf
          enemy = new Elf("Elf");
          break;
        case 3: // Orc
          enemy = new Orc("Orc");
          break;
        default:
          System.out.println("oops!");
          break;
      } // switch
    }
  } // createWarrior()

  public static void createWeapon(String who, int choice) {
    switch (choice) {
      case 1: // Dagger
        if (who.equals("Player")) {
          pWeapon = new Dagger("Dagger");
        } else {
          eWeapon = new Dagger("Dagger");
        }
        break;
      case 2: // Sword
        if (who.equals("Player")) {
          pWeapon = new Sword("Sword");
        } else {
          eWeapon = new Sword("Sword");
        }
        break;
      case 3: // Axe
        if (who.equals("Player")) {
          pWeapon = new Axe("Axe");
        } else {
          eWeapon = new Axe("Axe");
        }
        break;
      default:
        System.out.println("oops!");
        break;
    } // switch
  } // createWeapon()

  public static void createArmour(String who, int choice) {
    switch (choice) {
      case 1: // Leather
        if (who.equals("Player")) {
          pArmour = new Leather("Leather");
        } else {
          eArmour = new Leather("Leather");
        }
        break;
      case 2: // Chainmail
        if (who.equals("Player")) {
          pArmour = new Chainmail("Chainmail");
        } else {
          eArmour = new Chainmail("Chainmail");
        }
        break;
      case 3: // Platemail
        if (who.equals("Player")) {
          pArmour = new Platemail("Platemail");
        } else {
          eArmour = new Platemail("Platemail");
        }
        break;
      default:
        System.out.println("oops!");
        break;
    } // switch
  } // createArmour()

  public static void createWeather(int weatherType) {
    switch (weatherType) {
      case 1: // sun 
        weather = new Sun();
        break;
      case 2: // rain
        weather = new Rain();
        break;
      case 3: // wind
        weather = new Wind();
        break;
      case 4: // storm
        weather = new Storm();
        break;
      default:
        System.out.println("Run!! A black hole !!!");
        break;
    } // switch
  } // createWeather()

  public static void createGame() {
    //====================>>
    // Player Setup
    // Warrior
    ink.printWarriorMenu();
    int choice = input.nextInt(); // 1, 2 or 3
    createWarrior(who, choice);
    }
  }  
    // Weapon