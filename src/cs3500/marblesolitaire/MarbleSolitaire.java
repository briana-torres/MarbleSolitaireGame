package cs3500.marblesolitaire;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireTextView;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import java.io.InputStreamReader;

/**
 * Main class to run the controller class.
 */
public final class MarbleSolitaire {

  /**
   * Creates a new model and view in order to run the game.
   *
   * @param args the {@code String} input
   */
  public static void main(String[] args) {
    if (args[0].toLowerCase().equals("english")) {
      EnglishSolitaireModel model = new EnglishSolitaireModel();
      MarbleSolitaireTextView view = new MarbleSolitaireTextView(model);
      MarbleSolitaireControllerImpl controller =
          new MarbleSolitaireControllerImpl(model, view, new InputStreamReader(System.in));
      controller.playGame();
    }
    if (args[0].toLowerCase().equals("triangular")) {
      TriangleSolitaireModel model = new TriangleSolitaireModel();
      TriangleSolitaireTextView view = new TriangleSolitaireTextView(model);
      MarbleSolitaireControllerImpl controller =
          new MarbleSolitaireControllerImpl(model, view, new InputStreamReader(System.in));
      controller.playGame();
    }
    if (args[0].toLowerCase().equals("european")) {
      EuropeanSolitaireModel model = new EuropeanSolitaireModel();
      EuropeanSolitaireTextView view = new EuropeanSolitaireTextView(model);
      MarbleSolitaireControllerImpl controller =
          new MarbleSolitaireControllerImpl(model, view, new InputStreamReader(System.in));
      controller.playGame();
    }
  }
}