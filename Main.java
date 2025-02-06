package appaloosa;

public class Main {
  public static void main(String[] args) {
    MessagePriorityQueue q = new MessagePriorityQueue();
    q.add(new PriorityMessage(5, "pr 5.1"));
    q.add(new PriorityMessage(5, "pr 5.2"));
    q.add(new PriorityMessage(0, "pr 0"));
    q.add(new PriorityMessage(2, "pr 2"));
    q.add(new PriorityMessage(9, "pr 9"));

    System.out.println(q.size());

    while (!q.isEmpty()) {
      System.out.println(q.remove());
    }
  }
}
