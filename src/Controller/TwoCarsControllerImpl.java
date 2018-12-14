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
    Timer tim = new Timer(10, this);
    tim.setActionCommand("refresh");
    tim.start();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("refresh") && !this.paused) {
      model.stepMovers();
      //check and react to collisions
      if (model.managePositions()) {
        gameOver = true;
      }
      view.refresh(model.getMovers());
      view.setScore(model.getScore());
    } else if (e.getActionCommand().equals("switchLeft")) {
      model.switchLane("left");
    } else if (e.getActionCommand().equals("switchRight")) {
      model.switchLane("right");
    } else if (e.getActionCommand().equals("togglePause")) {
      this.paused = !paused;
    }
  }
}
