import java.util.Scanner;

public class Supermarket {
    private static Inventory inventory = new Inventory();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("1. Add Product");
                System.out.println("2. Update Product Quantity");
                System.out.println("3. Update Product Discount");
                System.out.println("4. Create Bill");
                System.out.println("5. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter product name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter product price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Enter product quantity: ");
                        int quantity = scanner.nextInt();
                        System.out.print("Enter product discount: ");
                        double discount = scanner.nextDouble();
                        inventory.addProduct(new Product(name, price, quantity, discount));
                        break;

                    case 2:
                        System.out.print("Enter product name: ");
                        name = scanner.nextLine();
                        System.out.print("Enter new quantity: ");
                        quantity = scanner.nextInt();
                        inventory.updateQuantity(name, quantity);
                        break;

                    case 3:
                        System.out.print("Enter product name: ");
                        name = scanner.nextLine();
                        System.out.print("Enter new discount: ");
                        discount = scanner.nextDouble();
                        inventory.updateDiscount(name, discount);
                        break;

                    case 4:
                        Bill bill = new Bill();
                        while (true) {
                            System.out.print("Enter product name (or 'done' to finish): ");
                            name = scanner.nextLine();
                            if (name.equalsIgnoreCase("done")) break;
                            System.out.print("Enter quantity: ");
                            quantity = scanner.nextInt();
                            scanner.nextLine();  // Consume newline
                            Product product = inventory.getProduct(name);
                            bill.addItem(product, quantity);
                        }
                        bill.printReceipt();
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (CustomException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error occurred: " + e.getMessage());
            }
        }
    }
}
