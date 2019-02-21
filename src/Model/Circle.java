package Model;

import java.awt.event.ActionListener;

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
   * Construct a Circle with the specified listener, in the specified lane.
   *
   * @param lane     the lane where this Circle should reside.
   * @param listener the listener to this Circle.
   */
  protected Circle(int lane, ActionListener listener) {
    super();
    this.lane = lane;
    this.listener = listener;
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

  /**
   * Construct a Circle with the specified listener, in the specified lane.
   *
   * @param lane     the lane where this Circle should reside.
   * @param yPosn    the y coordinate of this Circle.
   * @param listener the listener to this Circle.
   */
  protected Circle(int lane, int yPosn, ActionListener listener) {
    super();
    this.lane = lane;
    this.yPosn = yPosn;
    this.listener = listener;
  }

  @Override
  public String getType() {
    return "circle";
  }
}
