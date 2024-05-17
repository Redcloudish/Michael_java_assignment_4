package weapon;

public class Bow extends Weapon {
  private int damageAmount = 100;
  private int dexterityCost = 50;
  private int hitPercentage = 80;

  public Bow(String weaponType) {
    super();
    super.setDamageAmount(damageAmount);
    super.setDexterityCost(dexterityCost);
    super.setWeaponType(weaponType);
  }

  public int shoot(int weatherIntensity, int attackType, int strength, int dexterity) {
    int amount = 0;

   
    int roll = super.randNum.nextInt(100) + 1; // 1 - 100

    
    if (roll <= hitPercentage +
      ((dexterity - dexterityCost) / 10) - (attackType * 5)) { 
      if (attackType == 2) {
        amount = this.damageAmount + (strength / 10) + 2 - weatherIntensity;
      } else {
        amount = this.damageAmount + (strength / 20) - weatherIntensity;
      }
    }
    return amount;
  }
}