package appaloosa;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MessagePriorityQueue {
  private ArrayList<ArrayList<Message>> messageList;
  private int numMessages;

  public MessagePriorityQueue() {
    // basically same thing as (for int i = 0; i < 10; i++)
    // {this.messageList.add(new ArrayList<Message>)}
    this.messageList = IntStream.rangeClosed(0, 9)
        .mapToObj(_ -> new ArrayList<Message>())
        .collect(Collectors.toCollection(ArrayList::new));

    this.numMessages = 0;
  }

  public int size() {
    return this.numMessages;
  }

  public boolean isEmpty() {
    return this.numMessages == 0;
  }

  public void add(PriorityMessage message) {
    this.messageList.get(message.priority()).add(message);
    this.numMessages++;
  }

  // mr schmidt I apologize in advance, I learned about streams and they're super
  // duper cool
  public Message remove() {
    // only normal part about my code :)
    if (isEmpty())
      return null;

    // IntStream can work with primative ints, which is needed for backwards
    // iteration.
    // Of course a for loop would work but who needs simplicity when you can
    // flex on kern

    return IntStream.rangeClosed(0, 9)
        .map(i -> 9 - i) // manually reversing order. Normally i would go 0 -> 9 so we flip it
        .mapToObj(i -> this.messageList.get(i)) // get the inner ArrayList<Message> at index i from this.messageList
        .filter(list -> !list.isEmpty()) // if the ArrayList in messageList at
        .findFirst()
        .map(list -> {
          Message message = list.remove(0);
          this.numMessages--;
          return message;
        })
        .orElse(null);
  }
}
