import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

/**
 * Tests the operations in the {@code MarbleSolitaireControllerImpl} class.
 */
public class MarbleSolitaireControllerImplTest {

  protected EnglishSolitaireModel model;
  protected MarbleSolitaireTextView view;
  protected StringBuilder log;
  protected Reader in;
  protected MarbleSolitaireControllerImpl controller;

  @Before
  public void init() {
    log = new StringBuilder();
    model = new EnglishSolitaireModel();
    view = new MarbleSolitaireTextView(model, log);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorNullModel() {
    MarbleSolitaireControllerImpl test = new MarbleSolitaireControllerImpl(null, view,
        new StringReader(""));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorNullView() {
    MarbleSolitaireControllerImpl test = new MarbleSolitaireControllerImpl(model, null,
        new StringReader(""));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorNullInput() {
    MarbleSolitaireControllerImpl test = new MarbleSolitaireControllerImpl(model, view, in);
  }

  @Test(expected = IllegalStateException.class)
  public void testInvalidInput() {
    in = new StringReader("ahadjca");
    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
  }

  @Test(expected = IllegalStateException.class)
  public void testRanOutOfInputs() {
    in = new StringReader("4 6 4 4");
    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
  }

  @Test
  public void testValidMoveUp() {
    in = new StringReader("6 4 4 4 q \n");
    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 31", log.toString());
  }

  @Test
  public void testValidMoveDown() {
    in = new StringReader("2 4 4 4 q \n");
    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O _ O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", log.toString());
  }

  @Test
  public void testValidMoveLeft() {
    in = new StringReader("4 2 4 4 q \n");
    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O _ _ O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", log.toString());
  }

  @Test
  public void testValidMoveRight() {
    in = new StringReader("4 6 4 4 q \n");
    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31", log.toString());
  }

  @Test
  public void testInvalidMove() {
    in = new StringReader("2 6 4 5 q \n");
    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Invalid move \n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32", log.toString());
  }

  @Test
  public void testLowerCaseQuit() {
    in = new StringReader("q \n");
    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32", log.toString());
  }

  @Test
  public void testUpperCaseQuit() {
    in = new StringReader("Q \n");
    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32", log.toString());
  }

  @Test
  public void testGameOver() {
    in = new StringReader("4 6 4 4 4 3 4 5 4 1 4 3 6 4 4 4 3 4 5 4 1 4 3 4");
    controller = new MarbleSolitaireControllerImpl(model, view, in);
    controller.playGame();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O _ O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 32\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O _ _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 31\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O _ _ O _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 30\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "_ _ O _ O _ O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O\n"
        + "Score: 29\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "_ _ O O O _ O\n"
        + "O O O _ O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 28\n"
        + "    O O O\n"
        + "    O O O\n"
        + "O O O _ O O O\n"
        + "_ _ O _ O _ O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 27\n"
        + "    O _ O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "_ _ O _ O _ O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 26\n"
        + "Game over!\n"
        + "    O _ O\n"
        + "    O _ O\n"
        + "O O O O O O O\n"
        + "_ _ O _ O _ O\n"
        + "O O O O O O O\n"
        + "    O _ O\n"
        + "    O O O\n"
        + "Score: 26", log.toString());
  }


}