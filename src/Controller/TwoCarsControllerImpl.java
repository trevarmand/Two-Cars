package Controller;

import java.awt.event.KeyEvent;
import java.util.Scanner;

import Model.TwoCarsModel;

public class TwoCarsControllerImpl implements TwoCarsController {
  private TwoCarsModel model;
  Scanner sc = new Scanner(System.in);

  public TwoCarsControllerImpl(TwoCarsModel m) {
    this.model = m;
  }

  public void dispatchKeyStroke(KeyEvent key) {
    if (!model.isGameOver()) {
      if (!model.isGamePaused()) {
        if () {

        }
      }
    }
  }

  @Override
  public void playGame() {
    while (!model.isGameOver()) {
      if (!model.isGamePaused()) {
        model.checkForCollisions();
        if (sc.hasNext()) {
          String next = sc.next();
          if (next.equals("left") || next.equals("a")) {
            model.switchLane("left");
          } else if (next.equals("right") || next.equals("d")) {
            model.switchLane("right");
          } else if (next.equals("space") || next.equals("p")) {
            model.pause();
            break;
          }
        }
      } else {
        if (sc.hasNext()) {
          String next = sc.next();
          if (next.equals("p") || next.equals("space")) {
            model.resume();
          }
          if (next.equals("q")) {
            model.quit();
          }
        }
      }
    }
  }
}
