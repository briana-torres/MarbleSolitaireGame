package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This class represents operations to view the state of a european marble solitaire model,
 * without changing it.
 */
public class EuropeanSolitaireTextView extends MarbleSolitaireViewAbstract {

  /**
   * Creates a default european solitaire text view with the given model.
   *
   * @param model the model
   * @throws IllegalArgumentException if the model is null
   */
  public EuropeanSolitaireTextView(MarbleSolitaireModelState model)
      throws IllegalArgumentException {
    super(model);
  }

  /**
   * Creates a new european solitaire text view with the given model and appendable.
   *
   * @param model       the model
   * @param destination the {@code Appendable}
   * @throws IllegalArgumentException if either parameter is null
   */
  public EuropeanSolitaireTextView(MarbleSolitaireModelState model, Appendable destination) throws
      IllegalArgumentException {
    super(model, destination);
  }

  @Override
  public String toString() {
    StringBuilder init = new StringBuilder();
    int size = this.model.getBoardSize() - 1;
    int sideLength = (size / 3) + 1;
    int biggest = (sideLength * 2) - 2;
    int smallest = sideLength - 1;

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
    return init.toString();
  }

}
