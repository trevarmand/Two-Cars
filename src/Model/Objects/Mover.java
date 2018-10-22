package Model.Objects;

public abstract class Mover {
  //The lane in which this Mover resides.
  protected int lane;

  //the X coordinate of this Mover.
  protected int xPosn = 75 + ((lane - 1) * 150);

  //the Y coordinate of this Mover
  protected int yPosn = 0;

  int CANVAS_HEIGHT = 1000;

  public void move() {
    while (yPosn > CANVAS_HEIGHT) ;
  }
}
