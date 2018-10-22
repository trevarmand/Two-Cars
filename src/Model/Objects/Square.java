package Model.Objects;

public class Square extends Mover {

  public Square() {
    this.lane = (int) (Math.random() * 3) + 1;
    this.xPosn = 75 + ((lane - 1) * 150);
    this.yPosn = 0;
  }

  public int getXPosn() {
    return this.xPosn;
  }

  public int getYPosn() {
    return this.yPosn;
  }

  public Square(int lane) {
    this.xPosn = lane * 150;
    this.yPosn = 0;
    this.lane = lane;
  }
}
