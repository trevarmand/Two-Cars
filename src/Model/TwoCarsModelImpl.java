package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public final class TwoCarsModelImpl implements TwoCarsModel {
  private Car leftCar = new Car(1);
  private Car rightCar = new Car(2);

  //All squares currently active in the game.
  private ArrayList<Square> squares = new ArrayList<>();
  //All circles currently active in the game.
  private ArrayList<Circle> circles = new ArrayList<>();

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

    circles.add(new Circle(0, -250));
    squares.add(new Square(1, -250));
    circles.add(new Circle(2, -250));
    squares.add(new Square(3, -250));

    circles.add(new Circle(0, -500));
    squares.add(new Square(1, -500));
    circles.add(new Circle(2, -500));
    squares.add(new Square(3, -500));
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
    int leftX = leftCar.getXPosn();
    int rightX = rightCar.getXPosn();
    for (Square sq : squares) {
      if ((Math.abs(sq.getXPosn() - leftCar.getXPosn()) < 30
              || Math.abs(sq.getXPosn() - rightCar.getXPosn()) < 30)
              && (sq.getYPosn() > 620)) {
        System.out.println("Hit Square");
        //return false;
        sq.reset();
      } else if (sq.getYPosn() > 815) {
        sq.reset();
      }
    }
    for (Circle c : circles) {
      //TODO determine lower boundary such that missing a token ends game
      //TODO determine safe zone
      if (c.getYPosn() > 750) {
        System.out.println("in here");
        c.reset();
        return false;
      } else if ((Math.abs(c.getXPosn() - leftCar.getXPosn()) < 30
              || Math.abs(c.getXPosn() - rightCar.getXPosn()) < 30)
              && c.getYPosn() > 620) {
        System.out.println("Coin collected");
        this.score++;
        c.reset();
      }
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
}
