package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.Vector;

public final class TwoCarsModelImpl implements TwoCarsModel, ActionListener {
  private Car leftCar = new Car(1);
  private Car rightCar = new Car(2);

  //All squares currently active in the game.
  //Linked List worst case add/remove: O(1)
  private ArrayList<Mover> obstacles = new ArrayList<>();

  //the current number of Circles collected
  private int score = 0;

  //Stores the movers that need to be removed from Obstacles.
  //They can't be removed on the fly due to ConcurredModExcepts
  //Might be a better way to do that, might want to talk to Ben
  private Stack<Mover> toRemove = new Stack<>();
  //Same deal here, but adding circles now.
  private Stack<Integer> toAdd = new Stack<>();

  /**
   * Construct a new traditional Two Cars Model
   */
  public TwoCarsModelImpl() {
    obstacles.add(new Square(0, this));
    obstacles.add(new Circle(1, this));
    obstacles.add(new Square(2, this));
    obstacles.add(new Circle(3, this));

    obstacles.add(new Circle(0, -300, this));
    obstacles.add(new Square(1, -250, this));
    obstacles.add(new Circle(2, -430, this));
    obstacles.add(new Square(3, -400, this));
  }

  /**
   * Cleans the list of obstacles, removing passed squares / collected circles
   */
  private void clearMovers() {
    for (Mover m : toRemove) {
      obstacles.remove(m);
    }
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

  /**
   * Check for collisions when the given mover is in the collision zone.
   */
  private void manageCollisionZone(Mover m) {
    if (m.getType().equals("circle")) {
      if (m.getLane() == leftCar.getLane() || m.getLane() == rightCar.getLane()) {
        score++;
        this.toAdd.push(leftCar.getLane());
        this.toRemove.push(m);
      }
    } else if (m.getType().equals("square")) {
      if (m.getLane() == leftCar.getLane() || m.getLane() == rightCar.getLane()) {

      }
    } else {
      throw new IllegalArgumentException("Unsupported mover found. Type: " + m.getType());
    }
  }

  @Override
  public void step() {
    for (Mover m : obstacles) {
      m.move();
    }
    this.spawnMovers();
    this.clearMovers();
    this.toAdd.clear();
    this.toRemove.clear();
  }

  @Override
  public List<Mover> getMovers() {
    Vector<Mover> ret = new Vector<>();
    ret.addAll(obstacles);
    ret.add(leftCar);
    ret.add(rightCar);
    return ret;
  }

  /**
   * Helper for managing mover spawns. C
   */
  private void spawnMovers() {
    Random randy = new Random();

    for (Integer lane : toAdd) {
      int offset = this.findHighestMover(lane).getYPosn() - randy.nextInt(100);
      //The minimum gap between two movers.
      offset -= 200;
      boolean circle = randy.nextBoolean();
      if (circle) {
        Circle newCirc = (new Circle(lane, offset, this));
        obstacles.add(newCirc);
        System.out.println("spawned a circle in lane" + lane + " at y: " + newCirc.getYPosn());
      } else {
        Square newSq = new Square(lane, offset, this);
        obstacles.add(newSq);
        System.out.println("spawned a square in lane" + lane + " at y: " + newSq.getYPosn());
      }
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
    for (Mover m : obstacles) {
      if ((m.getLane() < 2 && lane < 2) || (m.getLane() > 1 && lane > 1)) {
        if (top == null) {
          top = m;
        } else if (top != null && m.getYPosn() < top.getYPosn()) {
          top = m;
        }
      }
    }
    return top;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "collision_zone":
        this.manageCollisionZone((Mover) e.getSource());
        break;
      case "below_screen":
        if (((Mover) e.getSource()).getType().equals("Circle")) {
          //TODO game over
        } else {
          // Invariant: These need to be movers!
          this.toRemove.push((Mover) e.getSource());
          this.toAdd.push(((Mover) e.getSource()).getLane());
        }
        break;
      default:
        throw new IllegalArgumentException("Unknown action event received");
    }
  }
}
