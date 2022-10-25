package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import java.io.IOException;

/**
 * This class represents the abstracted operations to view the state of a marble solitaire model,
 * without changing it.
 */
public abstract class MarbleSolitaireViewAbstract implements MarbleSolitaireView {

  protected MarbleSolitaireModelState model;
  protected Appendable destination;

  /**
   * Creates a default solitaire text view with the given model.
   * @param model the model
   * @throws IllegalArgumentException if the model is null
   */
  public MarbleSolitaireViewAbstract(MarbleSolitaireModelState model)
      throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException();
    }
    this.model = model;
    this.destination = System.out;
  }

  /**
   * Creates a new solitaire text view with the given model and appendable.
   * @param model the model
   * @param destination the {@code Appendable}
   * @throws IllegalArgumentException if either parameter is null
   */
  public MarbleSolitaireViewAbstract(MarbleSolitaireModelState model, Appendable destination) throws
      IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null");
    }
    if (destination == null) {
      throw new IllegalArgumentException("Destination cannot be null");
    }
    this.model = model;
    this.destination = destination;
  }

  /**
   * Returns a {@code String} to represent the given {@code SlotState}.
   *
   * @param slotState the given slot state
   * @return a string to represent the given slot state
   */
  protected String slotToString(MarbleSolitaireModelState.SlotState slotState) {
    String s = "";
    if (slotState == MarbleSolitaireModelState.SlotState.Marble) {
      s = "O";
    }
    if (slotState == MarbleSolitaireModelState.SlotState.Empty) {
      s = "_";
    }
    if (slotState == MarbleSolitaireModelState.SlotState.Invalid) {
      s = " ";
    }
    return s;
  }

  @Override
  public void renderBoard() throws IOException {
    this.destination.append(this.toString());
  }

  @Override
  public void renderMessage(String message) throws IOException {
    this.destination.append(message);
  }

}
