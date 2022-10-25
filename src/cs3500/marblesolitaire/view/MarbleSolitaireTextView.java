package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.MarbleSolitaireViewAbstract;

/**
 * This class represents operations to view the state of a marble solitaire model,
 * without changing it.
 */
public class MarbleSolitaireTextView extends MarbleSolitaireViewAbstract {

  /**
   * Creates a {@code MarbleSolitaireTextView} with the given model.
   *
   * @param model the model to represent the game state
   * @throws IllegalArgumentException when the given model is null
   */

  public MarbleSolitaireTextView(MarbleSolitaireModelState model) throws IllegalArgumentException {
    super(model);
  }

  /**
   * Creates a {@code MarbleSolitaireTextView} with the given model.
   *
   * @param model       the model
   * @param destination the {@code Appendable} object
   * @throws IllegalArgumentException if either param is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState model, Appendable destination) throws
      IllegalArgumentException {
    super(model, destination);
  }

  @Override
  public String toString() {
    StringBuilder init = new StringBuilder();
    int size = this.model.getBoardSize() - 1;
    int armThickness = (size / 3) + 1;
    int biggest = (armThickness * 2) - 2;
    int smallest = armThickness - 1;

    if (this.model instanceof EnglishSolitaireModel) {
      for (int i = 0; i < size + 1; i++) {
        for (int j = 0; j < size + 1; j++) {
          if (j > (armThickness * 2) - 2
              && this.model.getSlotAt(i, size) == MarbleSolitaireModelState.SlotState.Invalid) {
            break;
          }
          if (j > 0) {
            init.append(" ");
          }
          init.append(this.slotToString(this.model.getSlotAt(i, j)));
        }
        if (i == size) {
          break;
        }
        init.append("\n");
      }
    }
    if (this.model instanceof EuropeanSolitaireModel) {
      for (int i = 0; i < size + 1; i++) {
        for (int j = 0; j < size + 1; j++) {
          if (i < smallest && j > biggest + i
              && this.model.getSlotAt(i, size) == MarbleSolitaireModelState.SlotState.Invalid) {
            break;
          }
          if (i > biggest && j > size - i + biggest
              && this.model.getSlotAt(i, size) == MarbleSolitaireModelState.SlotState.Invalid) {
            break;
          }
          if (j > 0) {
            init.append(" ");
          }
          init.append(this.slotToString(this.model.getSlotAt(i, j)));
        }
        if (i == size) {
          break;
        }
        init.append("\n");
      }
    }
    return init.toString();
  }
}

