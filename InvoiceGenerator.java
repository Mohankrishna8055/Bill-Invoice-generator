import java.util.ArrayList;
import java.util.Scanner;

class InvoiceItem {
    String itemName;
    int quantity;
    double unitPrice;

    public InvoiceItem(String itemName, int quantity, double unitPrice) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public double getTotal() {
        return quantity * unitPrice;
    }
}

public class InvoiceGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<InvoiceItem> items = new ArrayList<>();

        while (true) {
            System.out.print("Enter item name (or 'done' to finish): ");
            String itemName = scanner.nextLine();

            if (itemName.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter unit price: ");
            double unitPrice = Double.parseDouble(scanner.nextLine());

            InvoiceItem item = new InvoiceItem(itemName, quantity, unitPrice);
            items.add(item);
        }

        double totalAmount = 0.0;

        System.out.println("\n************ Invoice ************");
        System.out.println("Item Name    Quantity    Unit Price    Total");

        for (InvoiceItem item : items) {
            double itemTotal = item.getTotal();
            System.out.printf("%-12s %-10d $%-12.2f $%-12.2f%n", item.itemName, item.quantity, item.unitPrice, itemTotal);
            totalAmount += itemTotal;
        }

        System.out.println("***********************************");
        System.out.printf("Total Amount: $%.2f%n", totalAmount);

        scanner.close();
    }
}
