package Model;

public interface TwoCarsModel {

  /**
   * @return whether or not this game is over.
   */
  boolean isGameOver();

  /**
   * @return whether or not the game is paused.
   */
  boolean isGamePaused();

  /**
   * Pause the game.
   */
  void pause();

  /**
   * Resume the game.
   */
  void resume();

  /**
   * Quit the current game.
   */
  void quit();

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
   * Inspect current movables for collisions and react accordingly.
   */
  void manageCollisions();

  /**
   * Run the game. Allows controller to reference fewer Model methods, which loosens coupling
   */
  void run();
}
