package warrior;

public class Human extends Warrior {
  private int baseHealth = 75;
  private int bonusHealth = 100;
  private int baseStrength = 75;
  private int bonusStrength = 100;
  private int baseDexterity = 75;
  private int bonusDexterity = 100;

  public Human(String warriorType) {
    super(); // must be called first in Java!
    super.setHealth(super.randNum.nextInt(bonusHealth) + baseHealth);
    super.setStrength(super.randNum.nextInt(bonusStrength) + baseStrength);
    super.setDexterity(super.randNum.nextInt(bonusDexterity) + baseDexterity);
    super.setWarriorType(warriorType);
  } // contructor

  public Human(int health, int strength, int dexterity, String type) {
    super(health, strength, dexterity, type); // must be called first!
  } // contructor

  public int specialAttack() {
    int healAmount = 0;
    healAmount = super.randNum.nextInt(50) + 10;
    return healAmount;
  } // specialAttack()

} // class