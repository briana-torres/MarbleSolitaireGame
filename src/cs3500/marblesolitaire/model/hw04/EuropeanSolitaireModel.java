package cs3500.marblesolitaire.model.hw04;

/**
 * This class represents operations that can be used to monitor the state of a marble solitaire
 * european model, without changing it.
 */
public class EuropeanSolitaireModel extends MarbleSolitaireModelAbstract {

  protected final int sideLength;

  /**
   * Creates a default european solitaire model.
   */
  public EuropeanSolitaireModel() {
    this.sideLength = 3;
    this.sRow = 3;
    this.sCol = 3;
    this.board = this.makeBoard(3, 3, 3);
  }

  /**
   * Creates a european solitaire model with a given size.
   * @param sideLength the side length
   * @throws IllegalArgumentException if length is non-positive or even
   */
  public EuropeanSolitaireModel(int sideLength) throws IllegalArgumentException {
    if (sideLength <= 0 || sideLength % 2 == 0) {
      throw new IllegalArgumentException("Invalid side length");
    }
    this.sideLength = sideLength;
    this.sRow = (this.getBoardSize() - 1) / 2;
    this.sCol = (this.getBoardSize() - 1) / 2;
    this.makeBoard(this.sideLength, this.sRow, this.sCol);
  }

  /**
   * Creates a new european solitaire model with the given empty slot.
   * @param sRow the empty slot row
   * @param sCol the empty slot column
   * @throws IllegalArgumentException if given an invalid empty slot position
   */
  public EuropeanSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    if (!this.isValid(3, sRow, sCol)) {
      throw new IllegalArgumentException("Invalid empty slot position");
    }
    this.sideLength = 3;
    this.sRow = sRow;
    this.sCol = sCol;
    this.board = this.makeBoard(this.sideLength, this.sRow, this.sCol);
  }

  /**
   * Creates a new european solitaire model with the given size and empty slot.
   * @param sideLength the side length
   * @param sRow the empty slot row
   * @param sCol the empty slot column
   * @throws IllegalArgumentException either the side length or empty slot position is invalid
   */
  public EuropeanSolitaireModel(int sideLength, int sRow, int sCol)
      throws IllegalArgumentException {
    if (!this.isValid(sideLength, sRow, sCol)) {
      throw new IllegalArgumentException("Invalid board configuration");
    }
    this.sideLength = sideLength;
    this.sRow = sRow;
    this.sCol = sCol;
    this.board = this.makeBoard(this.sideLength, this.sRow, this.sCol);
  }

  @Override
  public int getBoardSize() {
    return this.sideLength + (this.sideLength - 1) + (this.sideLength - 1);
  }

  @Override
  protected boolean isValid(int sideLength, int sRow, int sCol) {
    int smallest = sideLength - 1;
    int biggest = (sideLength * 2) - 2;
    int size = sideLength + (sideLength - 1) + (sideLength - 1) - 1;
    if (sideLength <= 0 || sideLength % 2 == 0) {
      return false;
    }
    if (sRow < 0 || sCol < 0) {
      return false;
    }
    if ((sRow == 0 || sRow == size) && (sCol < smallest || sCol > biggest)) {
      return false;
    }
    if ((sCol == 0 || sCol == size) && (sRow < smallest || sRow > biggest)) {
      return false;
    }
    if (sRow < smallest && sCol >= smallest - sRow && sCol < smallest) {
      return true;
    }
    if (sRow < smallest && sCol <= biggest + sRow && sCol > biggest) {
      return true;
    }
    if (sRow > biggest && sCol >= sRow - biggest && sCol < smallest) {
      return true;
    }
    if (sRow > biggest && sCol <= size - sRow + biggest && sCol > biggest) {
      return true;
    }
    if (sRow >= smallest && sRow <= biggest) {
      return true;
    }
    return sCol >= smallest && sCol <= biggest;
  }
}
