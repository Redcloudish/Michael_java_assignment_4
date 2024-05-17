package weather;

public class Rain extends Weather {

  private int rainIntensity = 5;
  
  public Rain() {
    super();
    super.setSeverity(super.randNum.nextInt(rainIntensity) + 1);
  }

} // class
