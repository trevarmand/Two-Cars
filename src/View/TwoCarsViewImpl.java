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

  private JPanel panel = new JPanel();

  JFrame frame = new JFrame("Two Cars");

  //private JLabel score = new JLabel(Integer.toString(model.getScore()));

  /**
   * Constructs a new traditional Two Car View
   */
  public TwoCarsViewImpl(TwoCarsController controller, TwoCarsModel model) {
    super("Two Cars");
    setSize(600, 800);
    setResizable(false);
    setVisible(true);
    this.controller = controller;
    this.model = model;
  }

  @Override
  public void display() {
    if (!model.isGameOver()) {
      if (!model.isGamePaused()) {
        panel.add(frame);
        panel.add(new JTextField("hello world"));
      } else {
        //TODO implement pause screen
      }
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
