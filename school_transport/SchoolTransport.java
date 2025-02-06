package school_transport;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class SchoolTransport {
  private List<SchoolBus> busses;

  // Mr. Schmidt I learned something cool
  // You can just place some brackets and it'll run the code inside
  // When object is initialized !!!

  {
    this.busses = new ArrayList<>();
  }

  // all code between this comment and next is just to let me debug in main

  public SchoolTransport() {
  }

  public SchoolTransport(List<SchoolBus> busses) {
    this.busses = busses;
  }

  public SchoolTransport(SchoolBus bus) {
    this.busses.add(bus);
  }

  public void addBus(SchoolBus bus) {
    this.busses.add(bus);
  }

  public void addBus(List<SchoolBus> busses) {
    this.busses.addAll(busses);
  }

  public List<SchoolBus> getBusses() {
    return this.busses;
  }

  // ok real part c coming

  // Get student street
  // Iterate through every bus and find matching streets
  // of all students on same street find num closest
  public boolean enroll(Student student) {
    Optional<Map.Entry<SchoolBus, Integer>> closestBusEntry = this.busses.stream()
        .filter(bus -> !bus.isFull())
        .collect(Collectors.toMap(
            bus -> bus,
            bus -> findNearestStudent(bus, student)))
        .entrySet()
        .stream()
        .min(Map.Entry.comparingByValue());

    if (closestBusEntry.isPresent()) {
      closestBusEntry.get().getKey().add(student); // not required I think but makes sense to add student to bus
      return true;
    }

    return false;
  }

  public Integer findNearestStudent(SchoolBus bus, Student student) {
    return bus.stream()
        .filter(s -> s.getStreet().equalsIgnoreCase(student.getStreet()))
        .mapToInt(s -> Math.abs(s.getNumber() - student.getNumber()))
        .min()
        .orElse(Integer.MAX_VALUE);
  }
}
