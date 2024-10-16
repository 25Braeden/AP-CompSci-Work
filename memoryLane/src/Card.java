public class Card {
  private String value;
  public Card(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return this.value;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Card card = (Card) obj;
    return value.equals(card.value);
  }
}
