import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Tests the operations in the MarbleSolitaireTextView class.
 */
public class MarbleSolitaireTextViewTest {

  protected MarbleSolitaireTextView view;
  protected MarbleSolitaireTextView view2;
  protected MarbleSolitaireTextView view3;
  protected MarbleSolitaireTextView view4;
  protected EnglishSolitaireModel model;
  protected EnglishSolitaireModel model2;
  protected EuropeanSolitaireModel model3;
  protected StringBuilder log;
  protected StringBuilder log2;


  /**
   * Initializes examples before each test.
   */
  @Before
  public void init() {
    model = new EnglishSolitaireModel();
    view = new MarbleSolitaireTextView(model);
    model2 = new EnglishSolitaireModel(5);
    view2 = new MarbleSolitaireTextView(model2);
    log = new StringBuilder();
    view3 = new MarbleSolitaireTextView(model, log);
    model3 = new EuropeanSolitaireModel();
    log2 = new StringBuilder();
    view4 = new MarbleSolitaireTextView(model3, log2);
  }

  @Test
  public void testToString() {
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", view.toString());
    assertEquals("        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O _ O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "O O O O O O O O O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O\n"
        + "        O O O O O", view2.toString());
  }

  @Test
  public void testEuroCornerMove() {
    model3.move(1, 3, 3,3);
    model3.move(1, 1, 1,3);
    assertEquals("    O O O\n"
        + "  _ _ O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", view4.toString());
  }

  @Test
  public void renderBoard() {
    try {
      view3.renderBoard();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", log.toString());
  }

  @Test
  public void renderEuroBoard() {
    try {
      view4.renderBoard();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    assertEquals("    O O O\n"
        + "  O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "  O O O O O\n"
        + "    O O O", log2.toString());
  }

  @Test
  public void renderMessage() {
    try {
      view3.renderMessage("hello");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    assertEquals("hello", log.toString());
  }

  @Test
  public void renderEuroMessage() {
    try {
      view4.renderMessage("hello");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    assertEquals("hello", log2.toString());
  }
}