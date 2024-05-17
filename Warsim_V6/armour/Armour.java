package armour;

public abstract class Armour {
  private int armourAmount;
  private int dexterityCost;
  private String armourType;

  public Armour() {
    // do nothing
  }

  //==============>>
  // GETTERS
  public int getArmourAmount() {
    return this.armourAmount;
  }
  public int getDexterityCost() {
    return this.dexterityCost;
  }
  public String getArmourType() {
    return this.armourType;
  }
  public abstract int reduceDamage(int damageAmount);

  //==============>>
  // SETTERS
  public void setArmourAmount(int armourAmount) {
    this.armourAmount = armourAmount;
  }
  public void setDexterityCost(int dexterityCost) {
    this.dexterityCost = dexterityCost;
  }
  public void setArmourType(String armourType) {
    this.armourType = armourType;
  }
} // class
