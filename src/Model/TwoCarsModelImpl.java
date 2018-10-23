package Model;

import Model.Movers.Car;
import Model.Movers.Circle;
import Model.Movers.Square;

public final class TwoCarsModelImpl implements TwoCarsModel {
  private Car leftCar = new Car(1);
  private Car rightCar = new Car(2);

  private Square[] squares = new Square[10];
  private Circle[] circles = new Circle[10];

  //the current number of Circles collected
  private int score;

  //have we seen a collision?
  private boolean gameOver;

  //is the game paused?
  private boolean gamePaused;

  /**
   * Construct a new traditional Two Cars Model
   */
  public TwoCarsModelImpl() {
    this.score = 0;
    this.gameOver = false;
    this.gamePaused = false;
  }

  @Override
  public void switchLane(String side) {
    if (side.equals("left")) {
      leftCar.switchLane();
    } else {
      rightCar.switchLane();
    }
  }

  @Override
  public int getCarLane(String side) {
    if (side.equals("left")) {
      return leftCar.getLane();
    } else return rightCar.getLane();
  }

  @Override
  public void pause() {
    this.gamePaused = true;
  }

  @Override
  public void resume() {
    this.gamePaused = false;
  }

  @Override
  public void quit() {
    this.gameOver = true;
  }

  @Override
  public boolean isGameOver() {
    return this.gameOver;
  }

  @Override
  public boolean isGamePaused() {
    return this.gamePaused;
  }

  @Override
  public void manageCollisions() {
    int leftX = leftCar.getX();
    int rightX = rightCar.getX();
    if (!this.gamePaused) {
      for (Square sq : squares) {
        if (sq.getXPosn() == leftX || sq.getXPosn() == rightX
                && (sq.getYPosn() > 800 && sq.getYPosn() < 50)) {
          this.gameOver = true;
        }
      }
      for (Circle c : circles) {
        //TODO determine lower boundary such that missing a token ends game
        if (c.getYPosn() > 1000) {
          this.gameOver = true;
        } else if (c.getXPosn() == leftX || c.getXPosn() == rightX
                && (c.getYPosn() > 800)) {
          this.score++;
        }
      }
    }
  }

  /**
   * Run the program.
   */
  public void run() {
    if (!this.gameOver) {
      while (!this.gamePaused) {
        this.runShapes();
      }
    }
  }

  /**
   * Move all shapes
   */
  private void runShapes() {
    if (!this.gamePaused) {
      for (Circle c : circles) {
        c.moveDown();
      }
      for (Square s : squares) {
        s.moveDown();
      }
    }
  }
}
