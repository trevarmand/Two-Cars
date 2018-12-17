package Model;

import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.Vector;

public final class TwoCarsModelImpl implements TwoCarsModel {
  private Car leftCar = new Car(1);
  private Car rightCar = new Car(2);

  //All squares currently active in the game.
  private Stack<Square> squares = new Stack<>();
  //All circles currently active in the game.
  private Stack<Circle> circles = new Stack<>();

  //the current number of Circles collected
  private int score = 0;

  /**
   * Construct a new traditional Two Cars Model
   */
  public TwoCarsModelImpl() {
    squares.add(new Square(0));
    circles.add(new Circle(1));
    squares.add(new Square(2));
    circles.add(new Circle(3));

    circles.add(new Circle(0, -300));
    squares.add(new Square(1, -250));
    circles.add(new Circle(2, -430));
    squares.add(new Square(3, -400));
  }

  @Override
  public void switchLane(String side) {
    switch (side) {
      case "left":
        leftCar.switchLane();
        break;
      case "right":
        rightCar.switchLane();
        break;
      default:
        throw new IllegalArgumentException("Invalid side");
    }
  }

  @Override
  public int getScore() {
    return this.score;
  }

  @Override
  public boolean managePositions() {
    Square bottomSquare = null;
    Circle bottomCircle = null;
    for (Square sq : squares) {
      if ((Math.abs(sq.getXPosn() - leftCar.getXPosn()) < 30
              || Math.abs(sq.getXPosn() - rightCar.getXPosn()) < 30)
              && (sq.getYPosn() > 620)) {
        System.out.println("Hit Square");
        //return false;
      } else if (sq.getYPosn() > 815) {
        bottomSquare = sq;
      }
    }
    for (Circle c : circles) {
      if (c.getYPosn() > 700) {
        System.out.println("Missed Coin");
        //TODO will ultimately be removed, game over functionality imposed.
        this.spawnMover(c.getLane());
        return false;
      } else if ((Math.abs(c.getXPosn() - leftCar.getXPosn()) < 30
              || Math.abs(c.getXPosn() - rightCar.getXPosn()) < 30)
              && c.getYPosn() > 560) //Magic Number 560 = top edge of car
      {
        System.out.println("Coin collected");
        this.score++;
        bottomCircle = c;
      }
    }
    if (bottomSquare != null) {
      squares.remove(bottomSquare);
      this.spawnMover(bottomSquare.getLane());
    }
    if (bottomCircle != null) {
      this.spawnMover(bottomCircle.getLane());
      circles.remove(bottomCircle);
    }
    return false;
  }

  @Override
  public void stepMovers() {
    for (Square s : squares) {
      s.move();
    }
    for (Circle c : circles) {
      c.move();
    }
  }

  @Override
  public List<Mover> getMovers() {
    Vector<Mover> ret = new Vector<>();
    ret.addAll(circles);
    ret.addAll(squares);
    ret.add(leftCar);
    ret.add(rightCar);
    return ret;
  }

  /**
   * Helper for managing mover spawns. C
   */
  private void spawnMover(int lane) {
    Random randy = new Random();
    int offset = randy.nextInt(100);
    if (randy.nextBoolean()) {
      circles.push(new Circle(lane, 0 - offset));
    } else {
      squares.push(new Square(lane, 0 - offset));
    }
  }
}
