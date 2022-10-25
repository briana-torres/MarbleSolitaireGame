import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the TriangleSolitaireModel class.
 */
public class TriangleSolitaireModelTest {

  TriangleSolitaireModel model;
  TriangleSolitaireModel model2;
  TriangleSolitaireModel model3;


  @Before
  public void init() {
    model = new TriangleSolitaireModel();
    model2 = new TriangleSolitaireModel(7);
    model3 = new TriangleSolitaireModel(5, 2, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSecondConstructor() {
    TriangleSolitaireModel test = new TriangleSolitaireModel(0, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidThirdConstructor() {
    TriangleSolitaireModel test = new TriangleSolitaireModel(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidFourthConstructor() {
    TriangleSolitaireModel test = new TriangleSolitaireModel(3, 3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidFourthConstructor2() {
    TriangleSolitaireModel test = new TriangleSolitaireModel(-2, 3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove() {
    this.model.move(1, 3, 4, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveNoMarble() {
    this.model.move(0, 0, 4, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveJumpOverEmpty() {
    this.model3.move(3, 1, 1, 1);
  }

  @Test
  public void getBoardSize() {
    assertEquals(5, this.model.getBoardSize());
    assertEquals(7, this.model2.getBoardSize());
    assertEquals(5, this.model3.getBoardSize());
  }

}