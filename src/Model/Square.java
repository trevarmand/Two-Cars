package Model;

import java.awt.event.ActionListener;

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
   * Construct a Square with the specified listener, in the specified lane.
   *
   * @param lane     the lane where this Square should reside.
   * @param listener the listener to this square.
   */
  protected Square(int lane, ActionListener listener) {
    super();
    this.lane = lane;
    this.listener = listener;
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


  /**
   * Construct a Square with the specified listener, in the specified lane.
   *
   * @param lane     the lane where this Square should reside.
   * @param yPosn    the y coordinate of this Square.
   * @param listener the listener to this Square.
   */
  protected Square(int lane, int yPosn, ActionListener listener) {
    super();
    this.lane = lane;
    this.yPosn = yPosn;
    this.listener = listener;
  }

  @Override
  public String getType() {
    return "square";
  }
}
