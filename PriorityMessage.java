package appaloosa;

// record is literally just an Object/Class but you dont need to make a annoying constructor
// It basically just auto makes constructor where the class has two variables which are the paramaters you pass in
// Only downside is that you cant update the variables so priority and message are unchangable here
public record PriorityMessage(int priority, String message) implements Message {
  @Override
  public int getPriority() {
    return this.priority;
  }

  @Override
  public String toString() {
    return this.message;
  }
}
