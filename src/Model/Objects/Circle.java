package Model.Objects;

public class Circle extends Mover {
  /**
   * Contructs a circle in a random lane
   */
  public Circle() {
    lane = (int) (Math.random() * 3) + 1;
  }

  /**
   * Constructs a new circle in the given lane.
   *
   * @param lane the lane where this Circle should reside
   */
  public Circle(int lane) {
    this.lane = lane;
  }

  public int getXPosn() {
    return this.xPosn;
  }

  public int getYPosn() {
    return this.yPosn;
  }
}
