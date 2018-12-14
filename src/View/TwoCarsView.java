package View;

import java.awt.event.ActionListener;
import java.util.List;

import Model.Mover;

public interface TwoCarsView {

  /**
   * Redraw the GUI for this game.
   */
  void refresh(List<Mover> obstacles);

  /**
   * Update the score of this view
   */
  void setScore(int score);

  /**
   * Set the action listener to this view. Typically the controller.
   */
  void setActionListener(ActionListener a);
}
