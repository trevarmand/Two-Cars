package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Model.TwoCarsModel;
import View.TwoCarsView;

public class TwoCarsControllerImpl implements TwoCarsController, ActionListener {
  private TwoCarsModel model;
  private TwoCarsView view;
  boolean paused = true;
  boolean gameOver = false;

  public TwoCarsControllerImpl(TwoCarsModel m, TwoCarsView v) {
    this.model = m;
    this.view = v;
  }

  public void dispatchInput(String key) {
    switch (key) {
      case "left":
        model.switchLane("left");
        break;
      case "right":
        model.switchLane("right");
        break;
      case "p":
      case "space":
        paused = !paused;
        break;
      default:
        //do nothing
        break;
    }
  }

  @Override
  public void playGame() {
    //Magic Number "16": A delay that triggers tim 60 times per second
    Timer tim = new Timer(9, this);
    tim.setActionCommand("refresh");
    tim.start();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("refresh")) {
      model.stepMovers();
      //check and react to collisions
      if (model.managePositions()) {
        gameOver = true;
      }
      view.refresh(model.getMovers());
      view.setScore(model.getScore());
    }
    if (e.getActionCommand().equals("switchLeft")) {
      model.switchLane("left");
    }
    if (e.getActionCommand().equals("switchRight")) {
      model.switchLane("right");
    }
  }
}
