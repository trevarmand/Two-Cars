package View;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import Model.Mover;

public class GamePanel extends JPanel {

  private int score;

  private java.util.List<Mover> movers;

  GamePanel() {
    Dimension d = new Dimension(600, 800);
    this.setPreferredSize(d);
    this.setVisible(true);
    movers = new ArrayList<>();
  }

  @Override
  public void paintComponent(Graphics g) {
    Color inner = new Color(150, 150, 150);
    Color carInner = new Color(100, 100, 120);
    Color red = new Color(225, 0, 0);
    Color blue = new Color(0, 0, 255);

    for (Mover m : movers) {
      if (m.getLane() < 2) {
        g.setColor(blue);
      } else {
        g.setColor(red);
      }
      if (m.getType().equals("circle")) {
        g.fillOval(m.getXPosn() - 20, m.getYPosn(), 40, 40);
        g.setColor(inner);
        g.fillOval(m.getXPosn() - 15, m.getYPosn() + 5, 30, 30);
        if (m.getLane() < 2) {
          g.setColor(blue);
        } else {
          g.setColor(red);
        }
        g.fillOval(m.getXPosn() - 8, m.getYPosn() + 12, 16, 16);
      } else if (m.getType().equals("square")) {
        g.fillRect(m.getXPosn() - 20, m.getYPosn(), 40, 40);
        g.setColor(inner);
        g.fillRect(m.getXPosn() - 10, m.getYPosn() + 10, 20, 20);
      } else if (m.getType().equals("left car")) {
        g.fillRect(m.getXPosn() - 25, m.getYPosn(), 50, 70);
        g.setColor(carInner);
        g.fillRect(m.getXPosn() - 12, m.getYPosn() + 17, 25, 35);
      } else if (m.getType().equals("right car")) {
        g.fillRect(m.getXPosn() - 25, m.getYPosn(), 50, 70);
        g.setColor(carInner);
        g.fillRect(m.getXPosn() - 12, m.getYPosn() + 17, 25, 35);
      }
    }
  }

  /**
   * Push new data to the panel for rendering.
   */
  void updateShapePosns(java.util.List<Mover> movers) {
    this.movers = movers;
  }

  /**
   * Push the current score to the panel.
   */
  void updateScore(int score) {
    this.score = score;
  }
}