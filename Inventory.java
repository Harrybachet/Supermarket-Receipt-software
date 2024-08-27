import java.util.HashMap;

public class Inventory {
    private HashMap<String, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getName(), product);
    }

    public Product getProduct(String name) throws CustomException {
        if (!products.containsKey(name)) {
            throw new CustomException("Product not found in inventory.");
        }
        return products.get(name);
    }

    public void removeProduct(String name) throws CustomException {
        if (!products.containsKey(name)) {
            throw new CustomException("Product not found in inventory.");
        }
        products.remove(name);
    }

    public void updateQuantity(String name, int quantity) throws CustomException {
        Product product = getProduct(name);
        if (quantity < 0) {
            throw new CustomException("Quantity cannot be negative.");
        }
        product.setQuantity(quantity);
    }

    public void updateDiscount(String name, double discount) throws CustomException {
        Product product = getProduct(name);
        if (discount < 0 || discount > 100) {
            throw new CustomException("Invalid discount value.");
        }
        product.setDiscount(discount);
    }
}
