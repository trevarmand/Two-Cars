package View;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public interface TwoCarsView extends KeyListener {

  /**
   * Run the GUI for this game.
   */
  void display();

  @Override
  void keyTyped(KeyEvent e);

  @Override
  void keyPressed(KeyEvent e);

  @Override
  void keyReleased(KeyEvent e);
}
