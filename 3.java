import java.util.Scanner;

public class ProductInventoryCsvParser {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter CSV line (ProductName,SKU,Quantity): ");
        String csvLine = scanner.nextLine();
        parseInventoryRecord(csvLine);
        scanner.close();
    }

    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();

        System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + quantity);
    }
}
