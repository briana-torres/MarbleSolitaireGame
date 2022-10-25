package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.MarbleSolitaireViewAbstract;

/**
 * This class represents operations to view the state of a triangle marble solitaire model,
 * without changing it.
 */
public class TriangleSolitaireTextView extends MarbleSolitaireViewAbstract {

  /**
   * Creates a default triangle solitaire text view with the given model.
   *
   * @param model the model
   * @throws IllegalArgumentException if the model is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model)
      throws IllegalArgumentException {
    super(model);
  }

  /**
   * Creates a new triangle solitaire text view with the given model and appendable.
   *
   * @param model       the model
   * @param destination the {@code Appendable}
   * @throws IllegalArgumentException if either parameter is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model, Appendable destination) throws
      IllegalArgumentException {
    super(model, destination);
  }

  @Override
  public String toString() {
    StringBuilder init = new StringBuilder();
    int size = this.model.getBoardSize();

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (j > i
            && this.model.getSlotAt(i, size - 1) == MarbleSolitaireModelState.SlotState.Invalid) {
          break;
        }
        if (j == 0) {
          int count = size - 1 - i;
          int k = 0;
          while (k < count) {
            init.append(" ");
            k++;
          }
        }
        if (j > 0) {
          init.append(" ");
        }
        init.append(this.slotToString(this.model.getSlotAt(i, j)));
      }
      if (i == size - 1) {
        break;
      }
      init.append("\n");
    }

    return init.toString();
  }

}
