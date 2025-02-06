package school_transport;

public class Student implements Person {
  private String name;
  private String address;
  private int houseNum;

  public Student(String name, int houseNum, String address) {
    this.name = name;
    this.houseNum = houseNum;
    this.address = address;
  }

  public int distance(Student other) {
    if (!this.address.equalsIgnoreCase(other.getStreet()))
      return 999999;
    return Math.abs(this.houseNum - other.getNumber());
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getStreet() {
    return this.address;
  }

  @Override
  public int getNumber() {
    return this.houseNum;
  }

  @Override
  public String toString() {
    return String.format(
        "Student name: %s\nStudent address: %s\nStudent house number: %d",
        this.name, this.address, this.houseNum);
  }
}
