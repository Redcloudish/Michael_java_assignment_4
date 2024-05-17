package utility;

import armour.*;
import warrior.*;
import weapon.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IO {

  private String fileName = "gameSave.txt";
  
  public IO() {
    // do nothing  
  } // contructor

  public void saveGame(Warrior player, Weapon pWeapon, Armour pArmour,
    Warrior enemy, Weapon eWeapon, Armour eArmour) {
    // Write to file
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
      
      // player data
      writer.write(player.getWarriorType() + " ");
      writer.write(pWeapon.getWeaponType() + " ");
      writer.write(pArmour.getArmourType() + "\n");
      writer.write(player.getHealth() + " ");
      writer.write(player.getStrength() + " ");
      writer.write(player.getDexterity() + "\n");
      
      // enemy data
      writer.write(enemy.getWarriorType() + " ");
      writer.write(eWeapon.getWeaponType() + " ");
      writer.write(eArmour.getArmourType() + "\n");
      writer.write(enemy.getHealth() + " ");
      writer.write(enemy.getStrength() + " ");
      writer.write(enemy.getDexterity()  + "\n");
    }
    catch (IOException e) {
        System.err.println("Error writing to file: " + e.getMessage());
    }
  } // saveGame()

  public List<Object> loadGame(Warrior player, Weapon pWeapon, Armour pArmour, 
    Warrior enemy, Weapon eWeapon, Armour eArmour) {
    List<Object> things = new ArrayList<>();
    
    // data that is read in
    String[] playerDetails = new String[3];
    int[] playerStats = new int[3];
    String[] enemyDetails = new String[3];
    int[] enemyStats = new int[3];

    // Read from file
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      String line;
      int lineNum = 0;
      while ((line = reader.readLine()) != null) {
          switch (lineNum) {
            case 0: // player details(type weapon armour)
              playerDetails = line.split(" ");
              break;
            case 1: // player stats
              String[] pStats = line.split(" ");
              for(int i = 0; i < pStats.length; i++) {
                playerStats[i] = Integer.parseInt(pStats[i]);
              }
              break;
            case 2: // enemy details
              enemyDetails = line.split(" ");
              break;
            case 3: // enemy stats
              String[] eStats = line.split(" ");
              for(int i = 0; i < eStats.length; i++) {
                enemyStats[i] = Integer.parseInt(eStats[i]);
              }
              break;
          } // switch
          lineNum++;
      } // while
    } 
    catch (IOException e) {
        System.err.println("Error reading from file: " + e.getMessage());
    }

    //===================================>>
    // first create the player objects
    switch (playerDetails[0]) {
      case "Human":
        player = new Human(playerStats[0], playerStats[1], playerStats[2], "Human");
        break;
      case "Elf":
        player = new Elf(playerStats[0], playerStats[1], playerStats[2], "Elf");
        break;
      case "Orc":
        player = new Orc(playerStats[0], playerStats[1], playerStats[2], "Orc");
        break;
    } things.add(player);
    // create the player weapon
    switch (playerDetails[1]) {
      case "Dagger":
        pWeapon = new Dagger("Dagger");
        break;
      case "Sword":
        pWeapon = new Sword("Sword");
        break;
      case "Axe":
        pWeapon = new Axe("Axe");
        break;
    } things.add(pWeapon);
    // create the player armour
    switch (playerDetails[2]) {
      case "Leather":
        pArmour = new Leather("Leather");
        break;
      case "Chainmail":
        pArmour = new Chainmail("Chainmail");
        break;
      case "Platemail":
        pArmour = new Platemail("Platemail");
        break;
    } things.add(pArmour);

    //===================================>>
    // next create the enemy objects
    switch (enemyDetails[0]) {
      case "Human":
        enemy = new Human(enemyStats[0], enemyStats[1], enemyStats[2], "Human");
        break;
      case "Elf":
        enemy = new Elf(enemyStats[0], enemyStats[1], enemyStats[2], "Elf");
        break;
      case "Orc":
        enemy = new Orc(enemyStats[0], enemyStats[1], enemyStats[2], "Orc");
        break;
    } things.add(enemy);
    // create the player weapon
    switch (enemyDetails[1]) {
      case "Dagger":
        eWeapon = new Dagger("Dagger");
        break;
      case "Sword":
        eWeapon = new Sword("Sword");
        break;
      case "Axe":
        eWeapon = new Axe("Axe");
        break;
    } things.add(eWeapon);
    // create the player armour
    switch (enemyDetails[2]) {
      case "Leather":
        eArmour = new Leather("Leather");
        break;
      case "Chainmail":
        eArmour = new Chainmail("Chainmail");
        break;
      case "Platemail":
        eArmour = new Platemail("Platemail");
        break;
    } things.add(eArmour);
    return things;
  } // loadGame()

} // class