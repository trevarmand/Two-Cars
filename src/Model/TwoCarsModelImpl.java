package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.Vector;

public final class TwoCarsModelImpl implements TwoCarsModel {
  private Car leftCar = new Car(1);
  private Car rightCar = new Car(2);

  private Random randy;

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
    randy = new Random();

    squares.add(new Square(0));
    circles.add(new Circle(1));
    squares.add(new Square(2));
    circles.add(new Circle(3));

    circles.add(new Circle(0, -300));
    squares.add(new Square(1, -250));
    circles.add(new Circle(2, -430));
    squares.add(new Square(3, -400));

    circles.add(new Circle(0, -435));
    squares.add(new Square(1, -650));
    circles.add(new Circle(2, -630));
    squares.add(new Square(3, -550));
//    if (randy.nextBoolean()) {
//      circles.add(new Circle(0, -450));
//      squares.add(new Square(1, -375));
//    } else if (randy.nextBoolean()) {
//      squares.add(new Square(2, -525));
//      circles.add(new Circle(3, -500));
//    }
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
    //TODO handle multiple events at once.
    ArrayList<Square> squaresToRemove = new ArrayList<Square>();
    ArrayList<Circle> circlesToRemove = new ArrayList<Circle>();
    for (Square sq : squares) {
      if ((Math.abs(sq.getXPosn() - leftCar.getXPosn()) < 30
              || Math.abs(sq.getXPosn() - rightCar.getXPosn()) < 30)
              && (sq.getYPosn() > 620) && sq.getYPosn() < 700) {
        //System.out.println("Hit Square");
        //return false;
      } else if (sq.getYPosn() > 815) {
        System.out.println("Square dropped off the bottom in lane " + sq.getLane());
        squaresToRemove.add(sq);
      }
    }
    for (Circle c : circles) {
      if (c.getYPosn() > 700) {
//        System.out.println("Missed Coin in lane" + c.getLane());
        //TODO will ultimately be removed, game over functionality imposed.
        circlesToRemove.add(c);
        return false;
      } else if ((Math.abs(c.getXPosn() - leftCar.getXPosn()) < 30
              || Math.abs(c.getXPosn() - rightCar.getXPosn()) < 30)
              && c.getYPosn() > 560) //Magic Number 560 = top edge of car
      {
        System.out.println("Coin collected in lane " + c.getLane());
        this.score++;
        circlesToRemove.add(c);
      }
    }
    if (!squaresToRemove.isEmpty()) {
      for (Square s : squaresToRemove) {
        this.spawnMover(s.getLane());
        squares.remove(s);
      }
    }
    if (!circlesToRemove.isEmpty()) {
      for (Circle c : circlesToRemove) {
        this.spawnMover(c.getLane());
        circles.remove(c);
      }
    }
    squaresToRemove.clear();
    circlesToRemove.clear();
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
    int offset = this.findHighestMover(lane).getYPosn() - randy.nextInt(100);
    //The minimum gap between two movers.
    offset -= 200;
    boolean circle = randy.nextBoolean();
    if (circle) {
      circles.push(new Circle(lane, offset));
      System.out.println("spawned a circle in lane" + lane);
    } else {
      Square newSq = new Square(lane, offset);
      squares.push(newSq);
      System.out.println("spawned a square in lane" + lane + " at y: " + newSq.getYPosn());
    }
  }

  /**
   * Helper to find the highest mover ON THIS SIDE. Used for gap deciding when spawning movers.
   * Should be pretty quick, but there's gotta be a better way to do this if we move away from a
   * stack.
   *
   *
   */
  //TODO make private once tested.
  public Mover findHighestMover(int lane) {
    Mover top = null;
    for (Circle c : circles) {
      if ((c.getLane() < 2 && lane < 2) || (c.getLane() > 1 && lane > 1)) {
        if (top == null) {
          top = c;
        } else if (top != null && c.getYPosn() < top.getYPosn()) {
          top = c;
        }
      }
    }
    for (Square s : squares) {
      if ((s.getLane() < 2 && lane < 2) || (s.getLane() > 1 && lane > 1)) {
        if (top == null) {
          top = s;
        } else if (top != null && s.getYPosn() < top.getYPosn()) {
          top = s;
        }
      }
    }
    return top;
  }
}
