package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.MarbleSolitaireModelAbstract;

/**
 * This class represents operations that can be used to monitor the state of a marble solitaire
 * model, without changing it.
 */
public class EnglishSolitaireModel extends MarbleSolitaireModelAbstract {

  protected final int armThickness;

  /**
   * Creates a default {@code EnglishSolitaireModel}.
   */
  public EnglishSolitaireModel() {
    this.armThickness = 3;
    this.sCol = 3;
    this.sRow = 3;
    this.board = this.makeBoard(this.armThickness, this.sRow, this.sCol);
  }

  /**
   * Creates an {@code EnglishSolitaireModel} with an empty slot at the given position.
   *
   * @param sRow the empty position slot
   * @param sCol the empty position column
   * @throws IllegalArgumentException when the cell position is invalid
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    if (!(this.isValid(3, sRow, sCol))) {
      throw new IllegalArgumentException("Invalid empty cell position ("
          + sRow + "," + sCol + ")");
    }
    this.armThickness = 3;
    this.sRow = sRow;
    this.sCol = sCol;
    this.board = this.makeBoard(this.armThickness, this.sRow, this.sCol);

  }

  /**
   * Creates an {@code EnglishSolitaireModel} with the given arm thickness and
   * an empty slot at the center.
   *
   * @param armThickness the arm thickness
   * @throws IllegalArgumentException when the cell position is invalid
   */
  public EnglishSolitaireModel(int armThickness) throws IllegalArgumentException {
    if (armThickness <= 0 || armThickness % 2 == 0) {
      throw new IllegalArgumentException("Invalid arm thickness");
    }
    this.armThickness = armThickness;
    this.sRow = (this.getBoardSize() - 1) / 2;
    this.sCol = (this.getBoardSize() - 1) / 2;
    this.board = this.makeBoard(this.armThickness, this.sRow, this.sCol);

  }

  /**
   * Creates an {@code EnglishSolitaireModel} with a given arm thickness and empty slot position.
   *
   * @param armThickness the arm thickness
   * @param sRow         the empty position slot
   * @param sCol         the empty position column
   * @throws IllegalArgumentException when the cell position is invalid
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol)
      throws IllegalArgumentException {
    if (!this.isValid(armThickness, sRow, sCol)) {
      throw new IllegalArgumentException("Invalid empty cell position ("
          + sRow + "," + sCol + ")");
    }
    this.armThickness = armThickness;
    this.sRow = sRow;
    this.sCol = sCol;
    this.board = this.makeBoard(this.armThickness, this.sRow, this.sCol);

  }

  @Override
  protected boolean isValid(int armThickness, int sRow, int sCol) {
    int smallest = armThickness - 1;
    int biggest = (armThickness * 2) - 2;
    if (armThickness <= 0 || armThickness % 2 == 0) {
      return false;
    }
    if (sRow < 0 || sCol < 0) {
      return false;
    }
    if ((sRow < smallest && sCol < smallest) || (sRow < smallest && sCol > biggest)) {
      return false;
    }
    return (sRow <= biggest || sCol >= smallest) && (sRow <= biggest || sCol <= biggest);
  }

  @Override
  public int getBoardSize() {
    return this.armThickness + (this.armThickness - 1) + (this.armThickness - 1);
  }


}


