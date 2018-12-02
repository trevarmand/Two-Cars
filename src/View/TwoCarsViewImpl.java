package View;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.*;

import Model.Mover;

public class TwoCarsViewImpl extends JFrame implements TwoCarsView, KeyListener {

  //the current score
  private int score = 0;

  private GamePanel gp;

  private Decorations decor;

  /**
   * Constructs a new traditional Two Car View
   */
  public TwoCarsViewImpl() {
    super("Two Cars");
    Dimension gameScreenDim = new Dimension(600, 800);
    this.setSize(gameScreenDim);
    this.setResizable(false);
    decor = new Decorations();
    gp = new GamePanel();
    this.add(decor);
    decor.add(gp);
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
    //Alert controller
  }

  @Override
  public void keyReleased(KeyEvent e) {
    //Do nothing
  }
}
