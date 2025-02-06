package school_transport;

import java.util.ArrayList;

public class SchoolBus extends ArrayList<Student> {
  private int numSeats;

  public SchoolBus(int numSeats) {
    super();
    this.numSeats = super.size();
  }

  public boolean isFull() {
    return this.size() == this.numSeats;
  }
}
