package armour;

public class Chainmail extends Armour {
  private int armourAmount = 150;
  private int dexterityCost = 100;

  public Chainmail(String armourType) {
    super();
    super.setArmourAmount(armourAmount);
    super.setDexterityCost(dexterityCost);
    super.setArmourType(armourType);
  } // constructor

  public int reduceDamage(int damageAmount) {
    return damageAmount - this.armourAmount / 5;
  }
  
} // class
