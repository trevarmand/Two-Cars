package View;

import java.awt.event.KeyEvent;

import javax.swing.*;

import Controller.TwoCarsController;
import Model.TwoCarsModel;

public class TwoCarsViewImpl extends JFrame implements TwoCarsView {

  //the controller associated with this view
  private TwoCarsController controller;

  //the model associated with this view
  private TwoCarsModel model;

  /**
   * Constructs a new traditional Two Car View
   */
  public TwoCarsViewImpl(TwoCarsController controller, TwoCarsModel model) {
    super();
    this.controller = controller;
    this.model = model;
  }

  @Override
  public void display() {
    if (!model.isGameOver()) {
      //TODO implement graphics
    } else {
      //TODO implement a game over screen.
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {
    //do nothing
  }

  @Override
  public void keyPressed(KeyEvent e) {
    controller.dispatchInput(e.getKeyText(e.getKeyCode()));
  }

  @Override
  public void keyReleased(KeyEvent e) {
    //do nothing
  }
}
