import Controller.TwoCarsController;
import Controller.TwoCarsControllerImpl;
import Model.TwoCarsModel;
import Model.TwoCarsModelImpl;

public class TwoCars {

  public static void main(String[] args) {
    TwoCarsModel tcm = new TwoCarsModelImpl();
    TwoCarsController tcc = new TwoCarsControllerImpl(tcm);
    tcc.playGame();
  }
}
