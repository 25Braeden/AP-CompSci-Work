public class BagelsOrderItem implements OrderItem {
  private double price;
  private int quanity;
  public BagelsOrderItem(double price, int quanity) {
    this.price = price;
    this.quanity = quanity;
  }

  @Override
  public double getPrice() {
    return this.price;
  }

  @Override
  public int getQuanity() {
    return this.quanity;
  }

  @Override
  public double getCost() {
    return this.price * this.quanity;
  }
}