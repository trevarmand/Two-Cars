package Controller;

import Model.TwoCarsModel;

public class TwoCarsControllerImpl implements TwoCarsController {
  private TwoCarsModel model;

  public TwoCarsControllerImpl(TwoCarsModel m) {
    this.model = m;
  }

  public void dispatchInput(String key) {
    switch (key) {
      case "left":
        model.switchLane("left");
        break;
      case "right":
        model.switchLane("right");
        break;
      case "space":
        if (model.isGamePaused()) {
          model.resume();
        } else {
          model.pause();
        }
        break;
      default:
        //do nothing
        break;
    }
  }

  @Override
  public void playGame() {
    while (!model.isGameOver()) {
      if (!model.isGamePaused()) {
        model.run();
      } else {
        //TODO Add pause screen in the future
      }
    }
  }
}
