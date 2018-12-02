package View;

import java.awt.*;

import javax.swing.*;

/**
 * Allows the rendering of all non-moving "decoration" to the screen, such as lane dividers.
 */
public class Decorations extends JPanel {

  public Decorations() {
    this.setBackground(new Color(80, 30, 150));
    Dimension d = new Dimension(600, 800);
    this.setPreferredSize(d);
    this.setVisible(true);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(new Color(150, 150, 150));
    g.fillRect(140, 0, 10, 800);
    g.fillRect(295, 0, 10, 800);
    g.fillRect(445, 0, 10, 800);
  }
}
