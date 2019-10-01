import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;

import static org.junit.Assert.assertEquals;

import cs3500.pyramidsolitaire.model.hw02.Card;
import java.util.List;
import org.junit.Test;

/**
 * test functionality.
 */
public class BasicPyramidSolitaireTest {
  BasicPyramidSolitaire testGame = new BasicPyramidSolitaire();

  List<Card> deck;
  Card card1 = new Card(1,'♥');
  Card card13 = new Card(1,'♣');
  Card cardKing = new Card(13,'♠');
  Card card7 = new Card(2, '♦');
  Card cardDraw = new Card(3,'♥');
  Card card0 = new Card(1, '♣');
  Card card2 = new Card(2,'♥');
  Card card9 = new Card(9, '♦');
  Card card8 = new Card(6, '♦');

  public void startTests() {
    deck = testGame.getDeck();
    testGame.startGame(deck, false, 7, 8);
  }

  @Test
  public void shuffleTest() {
    deck = testGame.getDeck();
    testGame.startGame(deck, false, 7, 8);
    assertEquals(deck.size(), 52);
  }

  @Test
  public void testGetDeck() {
    startTests();
    assertEquals(52, deck.size());
    assertEquals(deck.get(0).toString(), card13.toString());
    assertEquals(deck.get(51).toString(), cardKing.toString());
  }

  @Test
  public void testGetNumRows() {
    startTests();
    assertEquals(testGame.getNumRows(), 7);
  }

  @Test
  public void testGetNumDraw() {
    startTests();
    assertEquals(testGame.getNumDraw(), 8);
  }

  @Test
  public void testIsGameOverNoMoves() {
    startTests();
    assertEquals(testGame.isGameOver(), false);
  }

  @Test
  public void testGetCard() {
    startTests();
    assertEquals(testGame.getCardAt(0,0).toString(), card0.toString());
    assertEquals(testGame.getCardAt(6,6).toString(), card2.toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testGetCardFailure() {
    startTests();
    assertEquals(testGame.getCardAt(7,7), true);
  }

  @Test (expected = IllegalStateException.class)
  public void testGameStartNo() {
    assertEquals(testGame.getCardAt(0,0), true);
  }

  @Test (expected = IllegalStateException.class)
  public void testRemoveNoGameStart() {
    testGame.remove(6,4);
  }

  @Test
  public void testGetScore() {
    startTests();
    assertEquals(testGame.getScore(), 185);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testSmallRow() {
    deck = testGame.getDeck();
    testGame.startGame(deck, false, 0, 8);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testLargeRow() {
    deck = testGame.getDeck();
    testGame.startGame(deck, false, 10, 8);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testLargeDraw() {
    deck = testGame.getDeck();
    testGame.startGame(deck, false, 4, 100);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testSmallDraw() {
    deck = testGame.getDeck();
    testGame.startGame(deck, false, 4, 0);
  }

  @Test
  public void testGetFalseRowWidth() {
    startTests();
    assertEquals(testGame.getRowWidth(6), 7);
    testGame.startGame(deck, false, 4, 8);
  }

  @Test
  public void testGetRowWidth() {
    startTests();
    assertEquals(testGame.getRowWidth(6), 7);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testGetRowWidthOther() {
    startTests();
    assertEquals(testGame.getRowWidth(9), 7);
  }

  @Test
  public void testRemove() {
    startTests();
    assertEquals(testGame.getScore(), 185);
    testGame.remove(6, 4);
    testGame.remove(6,3, 6, 5);
    assertEquals(testGame.getScore(), 159);
  }

  @Test
  public void testSideDeck() {
    startTests();
    assertEquals(cardDraw.toString(), testGame.getDrawCards().get(0).toString());
  }

  @Test
  public void testGetDrawDeck() {
    startTests();
    assertEquals(testGame.getDrawCards().size(), 8);

  }

  @Test
  public void testSizeSideDeck() {
    startTests();
    assertEquals(testGame.getDrawCards().size(), 8);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidRemove() {
    startTests();
    testGame.remove(6,0,6,1);
  }

  @Test
  public void testRemover() {
    startTests();
    //assertEquals(testGame.toString(), "test");
    testGame.remove(6,2,6,6);
    testGame.remove(6,4);
    testGame.remove(6,3,6,5);
    testGame.remove(5,3,5,4);
    testGame.remove(5,5, 5,2);
    testGame.remove(4,2);

    testGame.removeUsingDraw(0, 6,1);

    testGame.remove(5,1,6, 0);
    testGame.remove(4,1,4, 3);
    //testGame.remove(4,1,4,1);

    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    //assertEquals(testGame.toString(), "test");
    testGame.discardDraw(0);


    assertEquals(testGame.getScore(), 71);
    assertEquals(testGame.isGameOver(), true);

  }

  @Test
  public void testRemover2() {
    startTests();
    assertEquals(52, deck.size());
    testGame.remove(6,2,6,6);
    testGame.remove(6,4);
    testGame.discardDraw(1);

    testGame.removeUsingDraw(0,6,1);
    testGame.remove(6,3,6,5);
    testGame.remove(5,3,5,4);
    testGame.remove(5,2,5,5);
    testGame.remove(4,2);
    testGame.removeUsingDraw(1,4,4);
    testGame.removeUsingDraw(0,4,3);
    testGame.remove(6,0,5,1);
    testGame.removeUsingDraw(7, 5,0);

    assertEquals(testGame.getScore(), 78);

    assertEquals(testGame.isGameOver(), false);

    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    testGame.discardDraw(0);
    assertEquals(testGame.isGameOver(), true);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testTopCard() {
    startTests();
    testGame.remove(0,0,1,1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testSingleRemoveCard() {
    startTests();
    testGame.remove(0,0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testSameCard() {
    startTests();
    testGame.remove(0,0,0,0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testOutOfRange() {
    startTests();
    testGame.remove(10,10,10,10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNegative() {
    startTests();
    testGame.remove(-1,-1,-1,-1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNegativeRemoveSingle() {
    startTests();
    testGame.remove(-1,-1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testBadDraw() {
    startTests();
    testGame.removeUsingDraw(200,6,4);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testBadMatch() {
    startTests();
    testGame.removeUsingDraw(0,-1,200);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testValidNumbers() {
    startTests();
    testGame.removeUsingDraw(2, 0, 1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testDiscard() {
    startTests();
    testGame.discardDraw(1010);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNegativeDiscard() {
    startTests();
    testGame.discardDraw(-1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testLargerThanDraw() {
    startTests();
    testGame.discardDraw(9);
  }

  @Test
  public void testRemoves1() {
    startTests();
    testGame.remove(6,2,6,6);
    testGame.remove(6,4);
    testGame.discardDraw(1);
    testGame.removeUsingDraw(0,6,1);
    assertEquals(testGame.getNumRows(), 7);
    assertEquals(testGame.getRowWidth(6), 7);
    assertEquals(testGame.getRowWidth(0), 1);
  }

  @Test
  public void testRemoves1ReverseOrder() {
    startTests();
    testGame.remove(6,6,6,2);
    testGame.remove(6,4);
    testGame.discardDraw(1);
    testGame.removeUsingDraw(0,6,1);
    assertEquals(testGame.getRowWidth(2), 3);
  }

  @Test
  public void testToString() {
    assertEquals(testGame.toString(), "");
  }


}
