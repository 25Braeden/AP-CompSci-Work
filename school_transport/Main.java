package school_transport;

public class Main {
  public static void main(String[] args) {
    // Create SchoolBus instances with given capacities and add students.
    SchoolBus bus1 = new SchoolBus(20);
    bus1.add(new Student("Alex", 1, "Elm St"));
    bus1.add(new Student("Bella", 10, "Oak St"));
    bus1.add(new Student("Bob", 25, "Oak St"));
    bus1.add(new Student("Candy", 100, "Chestnut St"));

    SchoolBus bus2 = new SchoolBus(4);
    bus2.add(new Student("Debbie", 16, "Oak St"));
    bus2.add(new Student("Erin", 6, "Elm St"));
    bus2.add(new Student("Frank", 106, "Chestnut St"));
    bus2.add(new Student("Gaby", 1, "Beech St"));

    SchoolBus bus3 = new SchoolBus(20);
    bus3.add(new Student("Holly", 17, "Oak St"));
    bus3.add(new Student("Irene", 7, "Elm St"));

    // Create the SchoolTransport instance and add the buses.
    SchoolTransport school = new SchoolTransport();
    school.addBus(bus1);
    school.addBus(bus2);
    school.addBus(bus3);

    // Print initial state of buses.
    System.out.println("Initial buses:");
    for (SchoolBus bus : school.getBusses())
      System.out.println(bus);
    System.out.println();

    // Enroll *John* and display the result.
    System.out.println("Enrolling *John*:");
    System.out.println(school.enroll(new Student("*John*", 5, "Elm St")));
    for (SchoolBus bus : school.getBusses())
      System.out.println(bus);
    System.out.println();

    // Enroll *Kathy* and display the result.
    System.out.println("Enrolling *Kathy*:");
    System.out.println(school.enroll(new Student("*Kathy*", 2, "Beech St")));
    for (SchoolBus bus : school.getBusses())
      System.out.println(bus);
    System.out.println();

    // Enroll *Lee* and display the result.
    System.out.println("Enrolling *Lee*:");
    System.out.println(school.enroll(new Student("*Lee*", 12, "Oak St")));
    for (SchoolBus bus : school.getBusses())
      System.out.println(bus);
    System.out.println();
  }
}
