import java.util.HashMap;

public class Bill {
    private HashMap<Product, Integer> items;
    private double total;

    public Bill() {
        items = new HashMap<>();
        total = 0;
    }

    public void addItem(Product product, int quantity) throws CustomException {
        if (quantity > product.getQuantity()) {
            throw new CustomException("Insufficient stock for product: " + product.getName());
        }
        items.put(product, quantity);
        product.setQuantity(product.getQuantity() - quantity);
        total += product.getDiscountedPrice() * quantity;
    }

    public double getTotal() {
        return total;
    }

    public void printReceipt() {
        System.out.println("---------- Receipt ----------");
        for (Product product : items.keySet()) {
            int quantity = items.get(product);
            System.out.println(product.getName() + " x" + quantity + " @ $" + product.getDiscountedPrice() + " each");
        }
        System.out.println("-----------------------------");
        System.out.println("Total: $" + total);
        System.out.println("-----------------------------");
    }
}
