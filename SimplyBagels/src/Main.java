public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.add(new BagelsOrderItem(1.35, 10));
        System.out.println(cart.totalDue());
    }
}