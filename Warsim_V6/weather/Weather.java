package weather;

import java.util.Random;

public abstract class Weather {
  protected Random randNum = new Random();
  private int severity;

  public Weather() {
    // do nothing
  }
  //=============>>
  // GETTERS
  public int getSeverity() {
    return this.severity;
  }

  //=============>>
  // SETTERS
  public void setSeverity(int severity) {
    this.severity = severity;
  }
  
} // class
