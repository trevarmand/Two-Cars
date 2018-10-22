package Model;

import Model.Objects.Car;
import Model.Objects.Circle;
import Model.Objects.Square;

public class TwoCarsModelImpl implements TwoCarsModel {
  private Car leftCar = new Car();
  private Car rightCar = new Car();

  Square[] squares = new Square[10];
  Circle[] circles = new Circle[10];

  private int score;

  //have we seen a collision?
  private boolean gameOver;

  //is the game paused?
  private boolean gamePaused;

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

  //get the lane of the car on the specified side
  public int getLane(String side) {
    if (side.equals("left")) {
      return leftCar.getLane();
    } else return rightCar.getLane();
  }

  public void pause() {
    this.gamePaused = true;
  }

  public void resume() {
    this.gamePaused = false;
  }

  public void quit() {
    this.gameOver = true;
  }

  public boolean isGameOver() {
    return this.gameOver;
  }

  public boolean isGamePaused() {
    return this.gamePaused;
  }

  @Override
  public void checkForCollisions() {
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

  @Override
  public void runMovers() {
    if (!this.gamePaused) {
      for (Circle c : circles) {
        c.move();
      }
      for (Square s : squares) {
        s.move();
      }
    }
  }
}
