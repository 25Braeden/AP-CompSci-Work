import java.util.ArrayList;

public class ShoppingCart extends ArrayList<OrderItem> {
    public double totalDue() {
        double amountDue = 0;
        for(OrderItem order : this) {
            amountDue += order.getCost();
        }
        return amountDue;
    }
}
