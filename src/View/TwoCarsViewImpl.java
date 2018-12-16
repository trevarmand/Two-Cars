package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.*;

import Model.Mover;

import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_SPACE;

public class TwoCarsViewImpl extends JFrame implements TwoCarsView, KeyListener {

  //the current score
  private int score = 0;

  private GamePanel gp;

  private Decorations decor;

  private ActionListener listener;

  /**
   * Constructs a new traditional Two Car View
   */
  public TwoCarsViewImpl() {
    super("Two Cars");
    Dimension gameScreenDim = new Dimension(600, 800);
    this.setSize(gameScreenDim);
    this.setResizable(false);
    this.decor = new Decorations();
    this.gp = new GamePanel();
    decor.add(gp);
    this.add(decor);
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setFocusable(true);
    this.addKeyListener(this);
  }

  @Override
  public void refresh(List<Mover> obstacles) {
    gp.updateShapePosns(obstacles);
    gp.updateScore(score);
    decor.repaint();
    this.repaint();
  }

  @Override
  public void setScore(int score) {
    this.score = score;
  }

  @Override
  public void keyTyped(KeyEvent e) {
    //Do nothing
  }

  @Override
  public void keyPressed(KeyEvent e) {
    switch (e.getKeyCode()) {
      case VK_LEFT:
        listener.actionPerformed(new ActionEvent(this, 0, "switchLeft"));
        break;
      case VK_RIGHT:
        listener.actionPerformed(new ActionEvent(this, 0, "switchRight"));
        break;
      case VK_SPACE:
        listener.actionPerformed(new ActionEvent(this, 2, "togglePause"));
        break;
      default:
        //Do nothing
        break;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    //Do nothing
  }

  @Override
  public void setActionListener(ActionListener a) {
    this.listener = a;
  }
}
