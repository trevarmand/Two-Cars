package Model;

public class Circle extends Mover {

  /**
   * Constructs a new circle in the given lane.
   *
   * @param lane the lane where this Circle should reside
   */
  public Circle(int lane) {
    super();
    this.lane = lane;
    this.xPosn = (lane * 150) + 75;
  }

  /**
   * Construct a new circle at the specified y coordinate.
   *
   * @param lane  the lane of this circle.
   * @param yPosn the y coordinate of this Circle.
   */
  public Circle(int lane, int yPosn) {
    this.lane = lane;
    this.yPosn = yPosn;
  }

  @Override
  public String getType() {
    return "circle";
  }
}
