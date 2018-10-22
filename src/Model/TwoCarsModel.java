package Model;

public interface TwoCarsModel {

  public boolean isGameOver();

  public boolean isGamePaused();

  public void pause();

  public void resume();

  public void quit();

  public void switchLane(String side);

  public int getLane(String side);

  public void checkForCollisions();

  public void runMovers();
}
