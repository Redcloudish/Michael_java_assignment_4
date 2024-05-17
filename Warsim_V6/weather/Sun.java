package weather;

public class Sun extends Weather {

  // perfect weather no effect on battle
  private int sunIntensity = 0;
  
  public Sun() {
    super();
    super.setSeverity(sunIntensity);
  }
  
} // class
