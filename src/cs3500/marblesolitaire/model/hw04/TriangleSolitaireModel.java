package cs3500.marblesolitaire.model.hw04;

/**
 * This class represents operations that can be used to monitor the state of a marble solitaire
 * triangle model, without changing it.
 */
public class TriangleSolitaireModel extends MarbleSolitaireModelAbstract {

  protected final int bRow;

  /**
   * Creates a default triangle solitaire model.
   */
  public TriangleSolitaireModel() {
    this.bRow = 5;
    this.sRow = 0;
    this.sCol = 0;
    this.board = this.makeBoard(this.bRow, this.sRow, this.sCol);
  }

  /**
   * Creates a triangle solitaire model with a given size.
   *
   * @param bRow the bottom row size
   * @throws IllegalArgumentException if the given size is a non-positive integer
   */
  public TriangleSolitaireModel(int bRow) throws IllegalArgumentException {
    if (bRow <= 0) {
      throw new IllegalArgumentException("Must have positive dimensions");
    }
    this.bRow = bRow;
    this.sRow = 0;
    this.sCol = 0;
    this.board = this.makeBoard(this.bRow, this.sRow, this.sCol);
  }

  /**
   * Creates a new triangle solitaire model with the given empty slot.
   *
   * @param sRow the empty slot row
   * @param sCol the empty slot column
   * @throws IllegalArgumentException if the empty slot position is invalid
   */
  public TriangleSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    if (!(this.isValid(5, sRow, sCol))) {
      throw new IllegalArgumentException("Invalid empty slot position");
    }
    this.bRow = 5;
    this.sRow = sRow;
    this.sCol = sCol;
    this.board = this.makeBoard(this.bRow, this.sRow, this.sCol);
  }

  /**
   * Creates a new triangle solitaire model with the given size and empty slot.
   *
   * @param bRow the bottom row size
   * @param sRow the empty slot row
   * @param sCol the empty slot column
   * @throws IllegalArgumentException if the given parameters create an invalid game
   */
  public TriangleSolitaireModel(int bRow, int sRow, int sCol) throws IllegalArgumentException {
    if (!(this.isValid(bRow, sRow, sCol))) {
      throw new IllegalArgumentException();
    }
    this.bRow = bRow;
    this.sRow = sRow;
    this.sCol = sCol;
    this.board = this.makeBoard(this.bRow, this.sRow, this.sCol);
  }

  @Override
  protected SlotState getMiddle(int fromRow, int fromCol, int toRow, int toCol) {
    SlotState middle = null;
    if (fromCol == toCol && fromRow > toRow) {
      middle = this.getSlotAt(fromRow - 1, toCol);
    }
    if (fromCol == toCol && fromRow < toRow) {
      middle = this.getSlotAt(toRow - 1, toCol);
    }
    if (fromRow == toRow && fromCol > toCol) {
      middle = this.getSlotAt(toRow, fromCol - 1);
    }
    if (fromRow == toRow && fromCol < toCol) {
      middle = this.getSlotAt(toRow, toCol - 1);
    }
    if ((Math.abs(fromRow - toRow) == 2 && Math.abs(fromCol - toCol) == 2)) {
      middle = this.getSlotAt(toRow + 1, toCol + 1);
    }
    return middle;
  }

  @Override
  protected boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
    SlotState middle = this.getMiddle(fromRow, fromCol, toRow, toCol);
    return this.isInBounds(fromRow, fromCol) && this.isInBounds(toRow, toCol)
        && (this.getSlotAt(fromRow, fromCol) != SlotState.Invalid)
        && (this.getSlotAt(toRow, toCol) != SlotState.Invalid)
        && (this.getSlotAt(fromRow, fromCol) != SlotState.Empty)
        && (this.getSlotAt(toRow, toCol) == SlotState.Empty)
        && ((Math.abs(fromRow - toRow) == 2 && fromCol == toCol)
        || (Math.abs(fromCol - toCol) == 2 && fromRow == toRow)
        || (Math.abs(fromRow - toRow) == 2 && Math.abs(fromCol - toCol) == 2)
        || (Math.abs(fromCol - toCol) == 2 && Math.abs(fromRow - toRow) == 2))
        && (middle == SlotState.Marble);
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (this.isMoveValid(fromRow, fromCol, toRow, toCol)) {
      this.board.get(fromRow).set(fromCol, SlotState.Empty);
      this.board.get(toRow).set(toCol, SlotState.Marble);
      if (fromCol == toCol && fromRow > toRow) {
        this.board.get(fromRow - 1).set(toCol, SlotState.Empty);
      }
      if (fromCol == toCol && fromRow < toRow) {
        this.board.get(toRow - 1).set(toCol, SlotState.Empty);
      }
      if (fromRow == toRow && fromCol > toCol) {
        this.board.get(toRow).set(fromCol - 1, SlotState.Empty);
      }
      if (fromRow == toRow && fromCol < toCol) {
        this.board.get(toRow).set(toCol - 1, SlotState.Empty);
      }
      if ((Math.abs(fromRow - toRow) == 2 && fromCol - toCol == 2)) {
        this.board.get(toRow + 1).set(toCol + 1, SlotState.Empty);
      }
      if ((Math.abs(fromRow - toRow) == 2 && fromCol - toCol == -2)) {
        this.board.get(fromRow + 1).set(fromCol + 1, SlotState.Empty);
      }
    } else {
      throw new IllegalArgumentException("Invalid move");
    }
  }

  @Override
  protected boolean isValid(int bRow, int sRow, int sCol) {
    if (bRow <= 0) {
      return false;
    }
    if (sRow < 0 || sCol < 0) {
      return false;
    }
    return sCol <= sRow;
  }

  @Override
  public int getBoardSize() {
    return this.bRow;
  }
}
