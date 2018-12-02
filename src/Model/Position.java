package Model;

/**
 * Represents a cartesian position. Useful for GamePanel storing positions of
 */
public class Position {
  private int x;
  private int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Return the x position.
   */
  public int getX() {
    return x;
  }

  /**
   * Return the y position.
   */
  public int getY() {
    return y;
  }
}
