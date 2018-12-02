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
   * Get the lane of the care on the specified side
   *
   * @param side the car who's lane we would like to know.
   * @return int representing the lane of this car
   */
  int getCarLane(String side);

  /**
   * Returns the current score.
   *
   * @return the current score of the game
   */
  int getScore();

  /**
   * Inspect current movables for collisions and react accordingly.
   * Remove objects from the scene that are no longer rendered.
   * @Return false if there is a game-ending collision.
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
