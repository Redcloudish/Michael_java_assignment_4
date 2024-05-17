package weather;

public class Storm extends Weather {

  private int stormIntensity = 25;
  
  public Storm() {
    super();
    super.setSeverity(super.randNum.nextInt(stormIntensity) + 1);
  }
  
} // class
