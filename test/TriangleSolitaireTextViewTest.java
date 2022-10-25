import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Tests the TriangleSolitaireTextView class.
 */
public class TriangleSolitaireTextViewTest {
  protected TriangleSolitaireModel model;
  protected TriangleSolitaireModel model2;
  protected TriangleSolitaireModel model3;
  protected TriangleSolitaireTextView view;
  protected TriangleSolitaireTextView view2;
  protected TriangleSolitaireTextView view3;
  protected StringBuilder log;

  @Before
  public void init() {
    model = new TriangleSolitaireModel();
    log = new StringBuilder();
    view = new TriangleSolitaireTextView(model, log);
    model2 = new TriangleSolitaireModel(7, 4, 2);
    view2 = new TriangleSolitaireTextView(model2);
    model3 = new TriangleSolitaireModel(5, 2,0);
    view3 = new TriangleSolitaireTextView(model3);
  }

  @Test
  public void testToString() {
    assertEquals("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", view.toString());
    assertEquals("      O\n"
        + "     O O\n"
        + "    O O O\n"
        + "   O O O O\n"
        + "  O O _ O O\n"
        + " O O O O O O\n"
        + "O O O O O O O", view2.toString());
  }

  @Test
  public void testMoveUp() {
    model.move(2,0,0,0);
    assertEquals("    O\n"
        + "   _ O\n"
        + "  _ O O\n"
        + " O O O O\n"
        + "O O O O O", view.toString());
  }

  @Test
  public void testMoveDown() {
    model3.move(0,0,2,0);
    assertEquals("    _\n"
        + "   _ O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", view3.toString());
  }

  @Test
  public void testMoveLeft() {
    model2.move(4,4,4,2);
    assertEquals("      O\n"
        + "     O O\n"
        + "    O O O\n"
        + "   O O O O\n"
        + "  O O O _ _\n"
        + " O O O O O O\n"
        + "O O O O O O O", view2.toString());
  }

  @Test
  public void testMoveRight() {
    model2.move(4,0,4,2);
    assertEquals("      O\n"
        + "     O O\n"
        + "    O O O\n"
        + "   O O O O\n"
        + "  _ _ O O O\n"
        + " O O O O O O\n"
        + "O O O O O O O", view2.toString());
  }

  @Test
  public void testMoveUpRight() {
    model2.move(6,2,4,2);
    assertEquals("      O\n"
        + "     O O\n"
        + "    O O O\n"
        + "   O O O O\n"
        + "  O O O O O\n"
        + " O O _ O O O\n"
        + "O O _ O O O O", view2.toString());
  }

  @Test
  public void testMoveUpLeft() {
    model2.move(6,4,4,2);
    assertEquals("      O\n"
        + "     O O\n"
        + "    O O O\n"
        + "   O O O O\n"
        + "  O O O O O\n"
        + " O O O _ O O\n"
        + "O O O O _ O O", view2.toString());
  }

  @Test
  public void testMoveDownLeft() {
    model2.move(2,2,4,2);
    assertEquals("      O\n"
        + "     O O\n"
        + "    O O _\n"
        + "   O O _ O\n"
        + "  O O O O O\n"
        + " O O O O O O\n"
        + "O O O O O O O", view2.toString());
  }

  @Test
  public void testMoveDownRight() {
    model2.move(2,0,4,2);
    assertEquals("      O\n"
        + "     O O\n"
        + "    _ O O\n"
        + "   O _ O O\n"
        + "  O O O O O\n"
        + " O O O O O O\n"
        + "O O O O O O O", view2.toString());
  }

  @Test
  public void renderMessage() {
    try {
      view.renderMessage("hello");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    assertEquals("hello", log.toString());
  }

  @Test
  public void renderBoard() {
    try {
      view.renderBoard();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    assertEquals("    _\n"
        + "   O O\n"
        + "  O O O\n"
        + " O O O O\n"
        + "O O O O O", log.toString());
  }
}