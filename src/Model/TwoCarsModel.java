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
   * Update model data and react to new data. (Movement, Collisions).
   */
  void step();

  /**
   * Return a list of the active movers in the program.
   */
  List<Mover> getMovers();
}
