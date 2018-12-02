import Controller.TwoCarsController;
import Controller.TwoCarsControllerImpl;
import Model.TwoCarsModel;
import Model.TwoCarsModelImpl;
import View.TwoCarsView;
import View.TwoCarsViewImpl;

public class TwoCars {

  public static void main(String[] args) {
    TwoCarsModel tcm = new TwoCarsModelImpl();
    TwoCarsView tcv = new TwoCarsViewImpl();
    TwoCarsController tcc = new TwoCarsControllerImpl(tcm, tcv);
    tcc.playGame();
  }
}
