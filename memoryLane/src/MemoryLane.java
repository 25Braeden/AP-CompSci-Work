import java.util.List;
import java.util.Arrays;
import java.lang.Math;

public class MemoryLane {
  public Card[] cards;
  public int numCards;

  public MemoryLane(List<String> words) {
    this.cards = new Card[words.size() * 2];
    int index = 0;
    for (String word: words) {
      this.cards[index] = new Card(word);
      this.cards[index + 1] = new Card(word);
      index += 2;
    }
    this.numCards = this.cards.length;
  }

  public boolean isValidArrangement(Card[] cards) {
    if (cards.length % 2 == 1) {
      return false;
    }
    for (int i = 0; i < this.numCards; i++) {
      int count = 0;
      for (int j = 0; j < this.numCards; j++) {
        if (cards[i].equals(cards[j])) count++;
      }
      if (count != 2) return false;
    }
    return true;
  }

  public void removeCard(int index) {
    for (int i = index; i < numCards - 1; i++) {
      cards[i] = cards[i + 1];
    }
    cards[numCards - 1] = null;
    this.numCards--;
  }

  public boolean openTwoCards(int cardOneIndex, int cardTwoIndex) {
    if (cards[cardOneIndex].equals(cards[cardTwoIndex])) {
      removeCard(cardOneIndex);
      removeCard(cardTwoIndex);
      return true;
    } else return false;
  }
  
  /* Had some fun and decided to use the Fisher-Yates shuffle */
  public void shuffle() {
    for (int i = this.numCards - 1; i >= 0; i--) {
      Card placeHolder = this.cards[i];
      int randomIndex = (int) (Math.random() * (i + 1));
      this.cards[i] = this.cards[randomIndex];
      this.cards[randomIndex] = placeHolder;
    }
  }
}
