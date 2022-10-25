import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Tests the operations in the EnglishSolitaireModel class.
 */
public class EnglishSolitaireModelTest {
  EnglishSolitaireModel game;
  EnglishSolitaireModel game2;
  ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> b1;
  ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> b2;
  ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>> b3;
  MarbleSolitaireModelState.SlotState s1;
  MarbleSolitaireModelState.SlotState s2;
  MarbleSolitaireModelState.SlotState s3;

  @Before
  public void init() {
    game = new EnglishSolitaireModel();
    game2 = new EnglishSolitaireModel(5);
    s1 = MarbleSolitaireModelState.SlotState.Marble;
    s2 = MarbleSolitaireModelState.SlotState.Empty;
    s3 = MarbleSolitaireModelState.SlotState.Invalid;
    b1 = new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(
        Arrays.asList(
            (new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(s3,
                s3, s1, s1, s1, s3, s3))),
            (new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(s3,
                s3, s1, s1, s1, s3, s3))),
            (new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(s1,
                s1, s1, s1, s1, s1, s1))),
            (new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(s1,
                s1, s1, s2, s1, s1, s1))),
            (new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(s1,
                s1, s1, s1, s1, s1, s1))),
            (new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(s3,
                s3, s1, s1, s1, s3, s3))),
            (new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(s3,
                s3, s1, s1, s1, s3, s3)))));
    b2 = new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(
        Arrays.asList(
            (new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(s3,
                s3, s1, s1, s1, s3, s3))),
            (new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(s3,
                s3, s1, s2, s1, s3, s3))),
            (new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(s1,
                s1, s1, s2, s1, s1, s1))),
            (new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(s1,
                s1, s1, s1, s1, s1, s1))),
            (new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(s1,
                s1, s1, s1, s1, s1, s1))),
            (new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(s3,
                s3, s1, s1, s1, s3, s3))),
            (new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(s3,
                s3, s1, s1, s1, s3, s3)))));
    b3 = new ArrayList<ArrayList<MarbleSolitaireModelState.SlotState>>(
        Arrays.asList(
            (new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(s3,
                s3, s2, s2, s2, s3, s3))),
            (new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(s3,
                s3, s1, s2, s2, s3, s3))),
            (new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(s2,
                s2, s2, s2, s1, s2, s2))),
            (new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(s2,
                s2, s2, s2, s2, s2, s2))),
            (new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(s1,
                s2, s1, s2, s2, s1, s2))),
            (new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(s3,
                s3, s2, s2, s2, s3, s3))),
            (new ArrayList<MarbleSolitaireModelState.SlotState>(Arrays.asList(s3,
                s3, s1, s2, s2, s3, s3)))));

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSecondConstructor() {
    MarbleSolitaireModel test = new EnglishSolitaireModel(-2, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidThirdConstructor() {
    MarbleSolitaireModel test = new EnglishSolitaireModel(6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidFourthConstructor() {
    MarbleSolitaireModel test = new EnglishSolitaireModel(3, 5, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove() {
    this.game.move(1, 3, 4, 3);
  }

  @Test
  public void getBoardSize() {
    assertEquals(7, this.game.getBoardSize());
    assertEquals(13, this.game2.getBoardSize());
  }

  @Test(expected = IllegalArgumentException.class)
  public void getInvalidSlotAt() {
    this.game.getSlotAt(-1, 3);
  }

  @Test
  public void getSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,
        this.game.getSlotAt(1, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,
        this.game.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,
        this.game.getSlotAt(3, 3));
  }

  @Test
  public void getScore() {
    assertEquals(32, this.game.getScore());
  }
}