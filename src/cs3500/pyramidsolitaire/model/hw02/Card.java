package cs3500.pyramidsolitaire.model.hw02;


import java.util.Objects;

/**
 * Cards are used to create decks and are the center point of the game.
 * Cards hold a value and a suit and have one constructor.
 */
public class Card {
  char suit;
  int value;


  /**
   * is a card that holds card elements.
   * @param value the value of the card in numerical form.
   * @param suit the suit of the card in string form.
   */
  public Card(int value, char suit) {
    if (value > 0 && value < 14) {
      this.value = value;
    } else {
      throw new IllegalArgumentException();
    }

    if (suit == '♣' || suit == '♦' || suit == '♥' || suit == '♠') {
      this.suit = suit;
    } else {
      throw new IllegalArgumentException();
    }

  }

  private int getValue() {
    return this.value;
  }

  private char getSuit() {
    return this.suit;
  }

  /**
   * converts card to string value.
   * @return card in string form ordered, value, suit.
   */
  public String toString() {
    switch (this.value) {
      case (13):
        return "K" + this.suit;
      case (12):
        return "Q" + this.suit;
      case (11):
        return "J" + this.suit;
      case (10):
        return "10" + this.suit;
      default:
        //return this.value + this.suit + "";
        return "" + this.value + this.suit + "";
    }
  }

  /**
   * Compares two cards.
   * @param testerCard comparing card.
   * @return boolean, true if the two are equal, false if otherwise.
   */
  @Override
  public boolean equals(Object testerCard) {
    if (testerCard instanceof Card) {
      Card card = (Card) testerCard;
      return (this.value == card.value && this.suit == card.suit);
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.value, this.suit);
  }

}
