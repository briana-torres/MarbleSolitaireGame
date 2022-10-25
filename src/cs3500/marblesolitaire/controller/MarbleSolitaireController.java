package cs3500.marblesolitaire.controller;

/**
 * This interface represents the operations offered by the marble solitaire controller.
 */
public interface MarbleSolitaireController {
  /**
   * Allows the user to play a marble solitaire game.
   * @throws IllegalStateException when an input cannot be transmitted or
   *     there are no inputs left
   */
  public void playGame() throws IllegalStateException;
}
