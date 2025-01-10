public interface OrderItem {
  /* Returns the price of this item */
  double getPrice();

  /* Returns the number of units ordered */
  int getQuanity();

  /* Returns the total cost for this order item */
  double getCost();
}