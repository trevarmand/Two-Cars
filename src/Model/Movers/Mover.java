package Model.Movers;

public abstract class Mover {
  //The lane in which this Mover resides.
  int lane;

  //the X coordinate of this Mover.
  private int xPosn;

  //the Y coordinate of this Mover
  private int yPosn = 0;

  //the height of the canvas
  private final int CANVAS_HEIGHT = 1000;

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
    return this.xPosn;
  }

  /**
   * Returns the Y position of this mover.
   *
   * @return the Y position of the mover.
   */
  public int getYPosn() {
    return this.yPosn;
  }

  /**
   * Updates this Mover's y position to simulate vertical movement.
   */
  public void moveDown() {
    while (yPosn > CANVAS_HEIGHT) {
      //TODO move down
    }
  }

  /**
   * Updates this Mover's x position to simulate horizontal movement.
   */
  public void moveHorizontal() {
    if ((this.lane & 1) == 0) {
      //TODO move to the right
    } else {
      //TODO move to the left
    }
  }
}
