
package garmentminiproject;
import java.util.Scanner;
import java.util.Date;



public class GarmentMiniproject {
    private static Inventory inventory = new Inventory();
    private static Supplier supplier = new Supplier();
    private static Customer customer = new Customer();
    private static Order order = new Order();
   

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
         while (!exit) {
    System.out.println("----- Garment Management System -----");
    System.out.println("1. Add Garment");
    System.out.println("2. View All Garments");
    System.out.println("3. Place an Order");
    System.out.println("4. View Order Details");
    System.out.println("5. Manage Supplier");
    System.out.println("6. Calculate Fabric Cost");
    System.out.println("7. Exit");
    System.out.print("Choose an option: ");

    int choice = scanner.nextInt();
    scanner.nextLine();  // Consume newline

    switch (choice) {
        case 1:
            addGarment(scanner);
            break;
        case 2:
            viewAllGarments();
            break;
        case 3:
            placeOrder(scanner);
            break;
        case 4:
            viewOrderDetails();
            break;
        case 5:
            manageSupplier(scanner);
            break;
        case 6:
            calculateFabricCost(scanner);
            break;
        case 7:
            exit = true;
            System.out.println("Exiting the system. Goodbye!");
            break;
        default:
            System.out.println("Invalid choice. Please try again.");
            break;
    }
}

        scanner.close();
    }

    private static void addGarment(Scanner scanner) {
        System.out.println("Enter Garment ID: ");
        String id = scanner.nextLine();
        
        System.out.println("Enter Garment Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter Description: ");
        String description = scanner.nextLine();

        System.out.println("Enter Size: ");
        String size = scanner.nextLine();

        System.out.println("Enter Color: ");
        String color = scanner.nextLine();

        System.out.println("Enter Price: ");
        double price = scanner.nextDouble();

        System.out.println("Enter Stock Quantity: ");
        int stockQuantity = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Garment garment = new Garment();
        garment.id = id;
        garment.name = name;
        garment.description = description;
        garment.size = size;
        garment.color = color;
        garment.price = price;
        garment.stockQuantity = stockQuantity;

        inventory.addGarment(garment);
        System.out.println("Garment added successfully!");
    }

    private static void viewAllGarments() {
        if (inventory.garments.isEmpty()) {
            System.out.println("No garments in inventory.");
        } else {
            System.out.println("----- Garment Inventory -----");
            for (Garment garment : inventory.garments) {
                System.out.println("ID: " + garment.id + ", Name: " + garment.name + 
                                   ", Size: " + garment.size + ", Color: " + garment.color +
                                   ", Price: " + garment.price + ", Stock: " + garment.stockQuantity);
            }
        }
    }

    private static void placeOrder(Scanner scanner) {
        System.out.println("Enter Garment ID to order: ");
        String garmentId = scanner.nextLine();
        Garment garment = inventory.findGarment(garmentId);
        
        if (garment != null) {
            order.addGarment(garment);
            System.out.println("Garment added to order.");
        } else {
            System.out.println("Garment not found in inventory.");
        }
    }

    private static void viewOrderDetails() {
        if (order.garments.isEmpty()) {
            System.out.println("No garments in order.");
        } else {
            order.printOrderDetails();
            System.out.println("Total Amount: " + order.calculateTotalAmount());
        }
    }

    private static void manageSupplier(Scanner scanner) {
        System.out.println("Enter Fabric ID: ");
        String fabricId = scanner.nextLine();

        System.out.println("Enter Fabric Type: ");
        String fabricType = scanner.nextLine();

        System.out.println("Enter Fabric Color: ");
        String fabricColor = scanner.nextLine();

        System.out.println("Enter Price Per Meter: ");
        double pricePerMeter = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        Fabric fabric = new Fabric();
        fabric.id = fabricId;
        fabric.type = fabricType;
        fabric.color = fabricColor;
        fabric.pricePerMeter = pricePerMeter;

        supplier.addFabric(fabric);
        System.out.println("Fabric added to supplier.");
    }

    private static void calculateFabricCost(Scanner scanner) {
        System.out.println("Enter Fabric ID: ");
        String fabricId = scanner.nextLine();
        
        System.out.println("Enter Meters Required: ");
        double meters = scanner.nextDouble();
        
        for (Fabric fabric : supplier.getSuppliedFabrics()) {
            if (fabric.id.equals(fabricId)) {
                double cost = fabric.calculateCost(meters);
                System.out.println("Total Fabric Cost: " + cost);
                return;
            }
        }
        System.out.println("Fabric not found.");
    }
}
    
        
        
        
        /*Garment g1 = new Garment();
        g1.name = "Silk";
        g1.description = "Good Product";
        g1.price = 600;

        double discountPrice = g1.calculateDiscountPrice(10);
        System.out.println("Discount Price: " + discountPrice);
        
    }
    
}
*/