package Model.Movers;

public class Car extends Mover {

  private int xPosn = 75 + ((lane - 1) * 150);

  /**
   * Constructs a car in the specified lane.
   *
   * @param lane the lane where this Car should reside
   */
  public Car(int lane) {
    this.lane = lane;
  }

  /**
   * Gives the precise x coordinate of this car.
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
