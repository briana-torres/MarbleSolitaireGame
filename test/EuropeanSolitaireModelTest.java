import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the EuropeanSolitaireModel class.
 */
public class EuropeanSolitaireModelTest {

  EuropeanSolitaireModel model;
  EuropeanSolitaireModel model2;


  @Before
  public void init() {
    model = new EuropeanSolitaireModel();
    model2 = new EuropeanSolitaireModel(5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSecondConstructor() {
    EuropeanSolitaireModel test = new EuropeanSolitaireModel(-2, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidThirdConstructor() {
    EuropeanSolitaireModel test = new EuropeanSolitaireModel(6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidFourthConstructor() {
    EuropeanSolitaireModel test = new EuropeanSolitaireModel(3, 5, 0);
  }

  @Test
  public void getBoardSize() {
    assertEquals(7, this.model.getBoardSize());
    assertEquals(13, this.model2.getBoardSize());
  }

  @Test
  public void getScore() {
    assertEquals(36, this.model.getScore());
  }
}