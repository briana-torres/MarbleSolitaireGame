package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

import java.util.ArrayList;

/**
 * This class represents the abstracted operations that can be used to monitor
 * the state of a marble solitaire model, without changing it.
 */
public abstract class MarbleSolitaireModelAbstract implements MarbleSolitaireModel {

  protected int sRow;
  protected int sCol;
  protected ArrayList<ArrayList<SlotState>> board;

  /**
   * Determines if the given position is valid.
   *
   * @param size the size
   * @param sRow the empty position row
   * @param sCol the empty position column
   * @return true if the position is valid and false if it is not valid
   */
  protected abstract boolean isValid(int size, int sRow, int sCol);

  /**
   * Creates the game board with the given arm thickness and empty position.
   *
   * @param size the size
   * @param sRow the empty position row
   * @param sCol the empty position column
   * @return a board with the given arm thickness and empty position
   */
  protected ArrayList<ArrayList<SlotState>> makeBoard(int size, int sRow, int sCol) {
    this.board = new ArrayList<ArrayList<SlotState>>();
    int boardSize = this.getBoardSize();
    for (int i = 0; i < boardSize; i++) {
      board.add(new ArrayList<SlotState>());
      for (int j = 0; j < boardSize; j++) {
        board.get(i).add(this.whichState(i, j, size, this.sRow, this.sCol));
      }
    }
    return this.board;
  }

  /**
   * Determines the cell in the middle of two given cell positions.
   *
   * @param fromRow the from row position
   * @param fromCol the from column position
   * @param toRow   the to row position
   * @param toCol   the to column position
   * @return the {@code SlotState} of the middle cell
   */
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
    return middle;
  }

  /**
   * Determines if the given position is in bounds of the board.
   *
   * @param row the row position
   * @param col the column position
   * @return true if in bounds and false if not
   */
  protected boolean isInBounds(int row, int col) {
    int boardSize = this.getBoardSize();
    return row < boardSize && row >= 0 && col >= 0 && col < boardSize;
  }

  /**
   * Determines if a move is valid.
   *
   * @param fromRow the from row position
   * @param fromCol the to column position
   * @param toRow   the to row position
   * @param toCol   the to column position
   * @return true if the move is valid and false if not
   */
  protected boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
    SlotState middle = this.getMiddle(fromRow, fromCol, toRow, toCol);
    return this.isInBounds(fromRow, fromCol) && this.isInBounds(toRow, toCol)
        && (this.getSlotAt(fromRow, fromCol) != SlotState.Invalid)
        && (this.getSlotAt(toRow, toCol) != SlotState.Invalid)
        && (this.getSlotAt(fromRow, fromCol) != SlotState.Empty)
        && (this.getSlotAt(toRow, toCol) == SlotState.Empty)
        && (Math.abs(toRow - fromRow) == 2 && fromCol == toCol
        || Math.abs(toCol - fromCol) == 2 && fromRow == toRow)
        && (middle == SlotState.Marble);
  }

  /**
   * Returns the {@code SlotState} at the given position.
   *
   * @param row  the given row
   * @param col  the given column
   * @param size the size
   * @param sRow the empty position row
   * @param sCol the empty position column
   * @return the {@code SlotState} at the given position
   */
  protected SlotState whichState(int row, int col, int size, int sRow, int sCol) {
    if (!(this.isValid(size, row, col))) {
      return SlotState.Invalid;
    }
    if (row == sRow && col == sCol) {
      return SlotState.Empty;
    }
    return SlotState.Marble;
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
    } else {
      throw new IllegalArgumentException("Invalid move");
    }
  }

  @Override
  public boolean isGameOver() {
    int size = this.getBoardSize();
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        if (row + 2 < size && this.isMoveValid(row, col, row + 2, col)) {
          return false;
        } else if (row - 2 >= 0 && this.isMoveValid(row, col, row - 2, col)) {
          return false;
        } else if (col + 2 < size && this.isMoveValid(row, col, row, col + 2)) {
          return false;
        } else if (col - 2 >= 0 && this.isMoveValid(row, col, row, col - 2)) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    int boardSize = this.getBoardSize();
    SlotState s = null;
    if (row < 0 || row > boardSize) {
      throw new IllegalArgumentException("Slot does not exist");
    }
    if (col < 0 || col > boardSize) {
      throw new IllegalArgumentException("Slot does not exist");
    }
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        if (i == row && j == col) {
          s = this.board.get(i).get(j);
        }
      }
    }
    return s;
  }

  @Override
  public int getScore() {
    int boardSize = this.getBoardSize();
    int score = 0;
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        if (this.board.get(i).get(j) == SlotState.Marble) {
          score++;
        }
      }
    }
    return score;
  }

}
