package warrior;

import java.util.Random;

// abstract means it CANNOT be directly instantiated!
public abstract class Warrior {
  // public(open to all), private(internal to class)
  // protected(closed outside, open on the inside)
  protected Random randNum = new Random();
  private int health;
  private int strength;
  private int dexterity;
  private String warriorType;
  private int rapidAttackDecay = 25; // 25% reduction with each hit
  private boolean specialAvailable = true;

  public Warrior() {
    // do nothing
  } // contructor

  // called when we are reloading the save game
  public Warrior(int health, int strength, int dexterity, String warriorType) {
    this.health = health;
    this.strength = strength;
    this.dexterity = dexterity;
    this.warriorType = warriorType;
  } // Warrior()

  //===============>>
  // GETTERS
  public int getHealth() {
    return this.health;
  }
  public int getStrength() {
    return this.strength;
  }
  public int getDexterity() {
    return this.dexterity;
  }
  public String getWarriorType() {
    return this.warriorType;
  }
  public int getRapidAttackDecay() {
    return this.rapidAttackDecay;
  }
  public boolean isAlive() {
    if(this.health > 0)
      return true;
    else 
      return false;
  }
  public boolean getSpecialAvailable() {
    return this.specialAvailable;
  }

  //===============>>
  // SETTERS
  public void setHealth(int health) {
    this.health = health;
  }
  public void setStrength(int strength) {
    this.strength = strength;
  }
  public void setDexterity(int dexterity) {
    this.dexterity = dexterity;
  }
  public void setWarriorType(String warriorType) {
    this.warriorType = warriorType;
  }
  public void takeDamage(int damageAmount) {
    if(damageAmount > 0)
      this.health -= damageAmount;
  }
  public void heal(int healAmount) {
    this.health += healAmount;
  } // I feel better already!

  public void specialUsed() {
    this.specialAvailable = !this.specialAvailable;
  }

  public abstract int specialAttack(); 
} // class
