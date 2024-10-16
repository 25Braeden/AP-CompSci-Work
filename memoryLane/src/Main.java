import java.util.List;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    List<String> words = new ArrayList<>();
    words.add("apple");
    words.add("pear");
    words.add("orange");

    MemoryLane memoryLane = new MemoryLane(words);
    System.out.println("Original cards:");
    for (Card card : memoryLane.cards) {
      System.out.print(card + " ");
    }
    System.out.println("\n");

    System.out.println("Is valid arrangement: " + memoryLane.isValidArrangement(memoryLane.cards));

    System.out.println("Removing card at index 0 (apple):");
    memoryLane.removeCard(0);
    for (Card card : memoryLane.cards) {
      System.out.print(card + " ");
    }
    System.out.println("\nNumber of cards: " + memoryLane.numCards);

    System.out.println("Opening two cards (index 0 and 1): " + memoryLane.openTwoCards(0, 1)); 
    for (Card card : memoryLane.cards) {
      System.out.print(card + " ");
    }
    System.out.println("\nNumber of cards: " + memoryLane.numCards);

    System.out.println("Shuffling cards:");
    memoryLane.shuffle();
    for (Card card : memoryLane.cards) {
      System.out.print(card + " ");
    }
    System.out.println();
  }
}

