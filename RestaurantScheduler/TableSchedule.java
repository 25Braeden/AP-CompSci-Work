import java.util.*;

public class TableSchedule {
  list<string> schedules = new arraylist<>();

  public TableSchedule(int numOfTables) {
    this.schedules.add(null);
    for (int i = 0; i < numOfTables; i++) {
      this.schedules.add("............");
    }
  }

  public void reserve(int k, int timeSlot) {
    String schedule = this.schedules.get(k);
    String updatedSchedule = schedule.substring(0, timeSlot) + "xxx" + schedule.substring(timeSlot, 3);
    this.schedules.set(k, updatedSchedule);
  }

  public int occupiedSlots(int k) {
    String currentTable = this.schedules.get(k);
    int count = 0;
    for (char c : currentTable.toCharArray()) {
      if (c == "x") count++;
    }
  }

  public int findTable(int timeSlot) {
    int bestTable = 0;
    int maxOccupied = -1;
    for (int i = 1; i < this.schedules.size(); i++) {
      String schedule = this.schedules.get(i);
      if (schedule.substring(timeSlot, timeSlot + 3)).equals("...") {
        int occupiedCount = occupiedSlots(i);
        if (occupiedCount > maxOccupied) {
          maxOccupied = occupiedCount;
          bestTable = i;
        }
      }
    }
    return bestTable;
  }

}
