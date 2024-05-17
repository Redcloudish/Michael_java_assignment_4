package weather;

public class Wind extends Weather {

  private int windIntensity = 15;
  
  public Wind() {
    super();
    super.setSeverity(super.randNum.nextInt(windIntensity) + 1);
  }
  
} // class