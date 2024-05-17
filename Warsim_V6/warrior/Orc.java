package warrior;

public class Orc extends Warrior {
  private int baseHealth = 200;
  private int bonusHealth = 150;
  private int baseStrength = 200;
  private int bonusStrength = 200;
  private int baseDexterity = 50;
  private int bonusDexterity = 50;

  public Orc(String warriorType) {
    super();
    super.setHealth(super.randNum.nextInt(bonusHealth) + baseHealth);
    super.setStrength(super.randNum.nextInt(bonusStrength) + baseStrength);
    super.setDexterity(super.randNum.nextInt(bonusDexterity) + baseDexterity);
    super.setWarriorType(warriorType);
  } // contructor

  public Orc(int health, int strength, int dexterity, String type) {
    super(health, strength, dexterity, type); // must be called first!
  } // contructor

  public int specialAttack() {
    int beserkAmount = super.randNum.nextInt(20) + 10;

    return beserkAmount;
  } // specialAttack()

} // class