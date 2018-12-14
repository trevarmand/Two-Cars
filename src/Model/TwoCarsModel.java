package Model;

import java.util.List;

public interface TwoCarsModel {

  /**
   * Switches the lane of the car on the given side.
   *
   * @param side A string, either "left" or "right"
   */
  void switchLane(String side);

  /**
   * Returns the current score.
   *
   * @return the current score of the game
   */
  int getScore();

  /**
   * Inspect current movables for collisions and react accordingly.
   * Remove objects from the scene that are no longer rendered.
   * @return false if there is a game-ending collision.
   */
  boolean managePositions();

  /**
   * Makes all moves shift down one position.
   */
  void stepMovers();

  /**
   * Return a list of the active movers in the program.
   */
  List<Mover> getMovers();
}
