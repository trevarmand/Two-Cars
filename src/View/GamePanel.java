package View;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import Model.Mover;

public class GamePanel extends JPanel {

  private int score;

  private java.util.List<Mover> movers;

  private JLabel scoreBoard;

  GamePanel() {
    Dimension d = new Dimension(600, 800);
    this.setPreferredSize(d);
    movers = new ArrayList<>();
    scoreBoard = new JLabel(Integer.toString(score));
    Font curFont = scoreBoard.getFont();
    scoreBoard.setFont(new Font(curFont.getName(), Font.PLAIN, 50));
    scoreBoard.setForeground(Color.WHITE);
    scoreBoard.setHorizontalTextPosition(SwingConstants.RIGHT);
    BorderLayout bl = new BorderLayout();
    this.setLayout(bl);
    this.add(scoreBoard, BorderLayout.NORTH);
    this.setVisible(true);
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
      switch (m.getType()) {
        case "circle":
          g.fillOval(m.getXPosn() - 20, m.getYPosn(), 40, 40);
          g.setColor(inner);
          g.fillOval(m.getXPosn() - 15, m.getYPosn() + 5, 30, 30);
          if (m.getLane() < 2) {
            g.setColor(blue);
          } else {
            g.setColor(red);
          }
          g.fillOval(m.getXPosn() - 8, m.getYPosn() + 12, 16, 16);
          break;
        case "square":
          g.fillRect(m.getXPosn() - 20, m.getYPosn(), 40, 40);
          g.setColor(inner);
          g.fillRect(m.getXPosn() - 13, m.getYPosn() + 7, 26, 26);
          if (m.getLane() < 2) {
            g.setColor(blue);
          } else {
            g.setColor(red);
          }
          g.fillRect(m.getXPosn() - 6, m.getYPosn() + 14, 12, 12);
          break;
        case "left car":
          g.fillRect(m.getXPosn() - 25, m.getYPosn(), 50, 70);
          g.setColor(carInner);
          g.fillRect(m.getXPosn() - 12, m.getYPosn() + 17, 25, 35);
          break;
        case "right car":
          g.fillRect(m.getXPosn() - 25, m.getYPosn(), 50, 70);
          g.setColor(carInner);
          g.fillRect(m.getXPosn() - 12, m.getYPosn() + 17, 25, 35);
          break;
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
    scoreBoard.setText(Integer.toString(score));
  }
}
