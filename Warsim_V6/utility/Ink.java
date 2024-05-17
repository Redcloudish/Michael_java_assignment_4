package utility;

import java.util.Scanner;
import warrior.Warrior;

public class Ink {

  public Ink() {
    // do nothing
  } // contructor

  // Welcome Message
  public void welcomeMessage() {
    System.out.println("""
      __        __             _             ____   ___ ____  _  _   
      \\ \\      / /_ _ _ __ ___(_)_ __ ___   |___ \\ / _ \\___ \\| || |  
       \\ \\ /\\ / / _` | '__/ __| | '_ ` _ \\    __) | | | |__) | || |_ 
        \\ V  V / (_| | |  \\__ \\ | | | | | |  / __/| |_| / __/|__   _|
         \\_/\\_/ \\__,_|_|  |___/_|_| |_| |_| |_____|\\___/_____|  |_|  
    """);
  }

  public boolean continueGame(Scanner input) {
    boolean isContinue = false;
    System.out.println("(1) continue game (2) new game");
    int choice = input.nextInt();
    if(choice == 1) {
      isContinue = !isContinue;
    }
    return isContinue;
  } // continueGame()

  // Warrior Menu
  public void printWarriorMenu() {
    System.out.println("Select a Type: \n1) Human\n2) Elf\n3) Orc");
  }

  // Weapon Menu
  public void printWeaponMenu() {
    System.out.println("Select a Weapon: \n1) Dagger\n2) Sword\n3) Axe");
  }
  
  // Armor Menu
  public void printArmourMenu() {
    System.out.println("Armour Pick: \n1) Leather\n2) Chainmail\n3) Platemail");
  }

  // Attack Menu
  public int printAttackMenu(Scanner input, boolean specialAvailable) {
    if(specialAvailable) {
      System.out.println("\nAttack Type: \n(1) Normal\n(2) Heavy\n(3) Special Ability (4) Save Game");
    }
    else {
      System.out.println("\nAttack Type: \n(1) Normal\n(2) Heavy\n(3) No Special Available (4) Save Game");
    }
    return input.nextInt();
  } // printAttackMenu

  // Print Stats
  public void printStats(Warrior pWarrior, Warrior eWarrior) {
    System.out.printf("%-25s (%s)\n", "Player: ", pWarrior.getWarriorType());
    System.out.printf("Health: %-25d\n", 
      pWarrior.getHealth());
    System.out.printf("Strength: %-25d\n", 
      pWarrior.getStrength());
    System.out.printf("Dexterity: %-25d\n", 
      pWarrior.getDexterity());
    System.out.printf("%-25s (%s)\n", "Enemy: ", eWarrior.getWarriorType());
    System.out.printf("Health: %-25d\n", 
      eWarrior.getHealth());
    System.out.printf("Strength: %-25d\n", 
      eWarrior.getStrength());
    System.out.printf("Dexterity: %-25d\n", 
      eWarrior.getDexterity());
  } // printStats()

  // GameOver Message
  public void printGameOver(String winner) {
    System.out.printf("""
         __ __
      .-',,^,,'.
     / \\(0)(0)/ \\
     )/( ,_"_,)\\(
     `  >-`~(   ' 
   _N\\ |(`\\ |___
   \\' |/ \\ \\/_-,)
    '.(  \\`\\_<
       \\ _\\|
        | |_\\_
        \\_,_>-'
    winner: %s
        """, winner);
  } // printGameOver()

} // class