package Model;

public class Square extends Mover {

  /**
   * Construct a square in the specified lane.
   *
   * @param lane the lane where this Square should reside
   */
  protected Square(int lane) {
    super();
    this.lane = lane;
    this.xPosn = (lane * 150) + 75;
  }

  /**
   * Construct a new square at the specified y coordinate.
   *
   * @param lane  the lane of this square.
   * @param yPosn the y coordinate of this square.
   */
  public Square(int lane, int yPosn) {
    this.lane = lane;
    this.yPosn = yPosn;
  }

  @Override
  public String getType() {
    return "square";
  }
}
