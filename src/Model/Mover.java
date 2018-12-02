package Model;

import java.util.Random;

public abstract class Mover {
  //The lane in which this Mover resides.
  int lane;

  //the X coordinate of this Mover.
  int xPosn = 0;

  //the Y coordinate of this Mover
  int yPosn = -50;

  /**
   * Returns the current lane of this mover.
   */
  public int getLane() {
    return this.lane;
  }

  /**
   * Returns the X position of this mover.
   *
   * @return the X position of the mover
   */
  public int getXPosn() {
    this.xPosn = (lane * 150) + 75;
    return this.xPosn;
  }

  /**
   * Returns the Y position of this mover.
   * @return the Y position of the mover.
   */
  public int getYPosn() {
    return this.yPosn;
  }

  /**
   * Updates this Mover's y position to simulate vertical movement.
   */
  public void move() {
    this.yPosn += 2;
  }

  /**
   * Return a String identifying the type of this mover MUST BE OVERRIDDEN
   */
  public String getType() {
    return "You forgot to override this method";
  }

  /**
   * Update the car's Y position so they roll in from the top of the screen. Randomize the lane
   */
  protected void reset() {
    Random randy = new Random();
    double newLane = randy.nextDouble() * 10;
    newLane = Math.round(newLane / 4.0);
    this.yPosn = -250;
    this.lane = (int) newLane;
  }
}
