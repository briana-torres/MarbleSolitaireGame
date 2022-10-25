package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class represents operations that can be used to receive input from the user and
 * delegate to the model and view.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  protected MarbleSolitaireModel model;
  protected MarbleSolitaireView view;
  protected Readable input;

  /**
   * Constructs a new controller.
   *
   * @param model the given model
   * @param view  the given view
   * @param input the input
   * @throws IllegalArgumentException if any given param is null
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
                                       Readable input) throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null");
    }
    if (view == null) {
      throw new IllegalArgumentException("View cannot be null");
    }
    if (input == null) {
      throw new IllegalArgumentException("Input cannot be null");
    }
    this.model = model;
    this.view = view;
    this.input = input;

  }

  @Override
  public void playGame() throws IllegalStateException {
    Scanner s = new Scanner(this.input);
    MarbleSolitaireModel m = this.model;
    int count = 0;
    int[] positions = new int[4];

    try {
      this.view.renderBoard();
      this.view.renderMessage("\n");
      this.view.renderMessage("Score: " + model.getScore() + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Cannot transmit output");
    }

    while (!model.isGameOver()) {
      String curVal;

      try {
        curVal = s.next();
      } catch (NoSuchElementException e) {
        throw new IllegalStateException("Ran out of inputs");
      }

      if (curVal.equals("q") || curVal.equals("Q")) {
        try {
          this.view.renderMessage("Game quit!\n");
          this.view.renderMessage("State of game when quit:\n");
          this.view.renderBoard();
          this.view.renderMessage("\n");
          this.view.renderMessage("Score: " + model.getScore());
          return;
        } catch (IOException e) {
          throw new IllegalStateException("Cannot transmit output");
        }
      }

      try {
        if (Integer.parseInt(curVal) > 0) {
          positions[count] = Integer.parseInt(curVal) - 1;
          count++;
        }
      } catch (NumberFormatException nfe) {
        try {
          this.view.renderMessage("Please enter a valid input \n");
        } catch (IOException e) {
          throw new IllegalStateException("Cannot transmit output");
        }
      }
      if (count == 4) {
        try {
          this.model.move(positions[0], positions[1], positions[2], positions[3]);
        } catch (IllegalArgumentException i) {
          try {
            this.view.renderMessage("Invalid move \n");
          } catch (IOException e) {
            throw new IllegalStateException("Cannot transmit output");
          }
        }
        try {
          this.view.renderBoard();
          this.view.renderMessage("\n");
          this.view.renderMessage("Score: " + model.getScore());
          this.view.renderMessage("\n");
        } catch (IOException e) {
          throw new IllegalStateException("Cannot transmit output");
        }
        count = 0;
      }
      if (model.isGameOver()) {
        try {
          this.view.renderMessage("Game over!\n");
          this.view.renderBoard();
          this.view.renderMessage("\n");
          this.view.renderMessage("Score: " + model.getScore());
          return;
        } catch (IOException e) {
          throw new IllegalStateException("Cannot transmit output");
        }
      }

    }

  }
}

