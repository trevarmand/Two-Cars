package Model;

public class Car extends Mover {

  /**
   * Constructs a car in the specified lane.
   *
   * @param lane the lane where this Car should reside
   */
  protected Car(int lane) {
    this.lane = lane;
    this.xPosn = (lane * 150) + 75;
    this.yPosn = 600;
  }

  /**
   * Switch the car's current lane.
   */
  public void switchLane() {
    if (lane == 0 || lane == 2) {
      this.lane++;
    } else if (lane == 1 || lane == 3) {
      this.lane--;
    } else {
      throw new IllegalArgumentException("Found a car outside of valid lanes");
    }
  }

  @Override
  public void move() {
    //Do nothing
  }

  @Override
  public String getType() {
    if (this.lane < 2) {
      return "left car";
    } else {
      return "right car";
    }
  }
}
