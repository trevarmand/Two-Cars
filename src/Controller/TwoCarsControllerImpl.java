package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Model.TwoCarsModel;
import View.TwoCarsView;

public class TwoCarsControllerImpl implements TwoCarsController, ActionListener {
  private TwoCarsModel model;
  private TwoCarsView view;
  private boolean paused = false;
  private boolean gameOver = false;

  public TwoCarsControllerImpl(TwoCarsModel m, TwoCarsView v) {
    this.model = m;
    this.view = v;
    this.view.setActionListener(this);
  }

  @Override
  public void playGame() {
    //Magic Number "16": A delay that triggers tim 60 times per second
    Timer tim = new Timer(8, this);
    tim.setActionCommand("refresh");
    tim.start();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "refresh":
        if (!this.paused) {
          model.step();
          view.refresh(model.getMovers());
          view.setScore(model.getScore());
        }
        break;
      case "switchLeft":
        model.switchLane("left");
        break;
      case "switchRight":
        model.switchLane("right");
        break;
      case "togglePause":
        this.paused = !paused;
    }
  }
}
