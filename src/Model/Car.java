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
    if ((lane & 1) == 0) {
      lane--;
    } else {
      lane++;
    }
  }

  @Override
  public void move() {
    //TODO make this switch its lane.
    //Keep in mind this is called every tick, so it needs to only operate during active movement.
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
