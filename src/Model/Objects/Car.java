package Model.Objects;

public class Car {
  private int lane;

  private int xPosn = 75 + ((lane - 1) * 150);

  public Car() {
    this.lane = (int) (Math.random() * 3) + 1;
  }

  public Car(int lane) {
    this.lane = lane;
  }

  /**
   * Gives the current lane of the Car;
   */
  public int getLane() {
    return lane;
  }

  /**
   * Gives the precise x coordinate of this car.
   *
   * @return the x coordinate of this car.
   */
  public int getX() {
    return this.xPosn;
  }

  public void switchLane() {
    if ((lane & 1) == 0) {
      lane--;
    } else {
      lane++;
    }
    //TODO: a function for moving the x coordinate
  }
}
