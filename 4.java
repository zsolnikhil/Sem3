public class WarehouseInventoryBalancer {

    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};
        analyzeInventory(sectionA, sectionB);
    }

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null) {
            throw new IllegalArgumentException("Section arrays cannot be null.");
        }
        if (sectionA.length != sectionB.length || sectionA.length == 0) {
            throw new IllegalArgumentException("Both sections must be non-empty and of equal length.");
        }

        int totalA = calculateTotal(sectionA);
        int totalB = calculateTotal(sectionB);
        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        int highestQuantity = sectionA[0];
        String highestSection = "Section A";
        int highestItemIndex = 1;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestItemIndex = i + 1;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestItemIndex = i + 1;
            }
        }

        System.out.println("Section A Total: " + totalA
                + " | Section B Total: " + totalB
                + " | Status: " + status
                + " | Highest Quantity: " + highestQuantity
                + " (" + highestSection + ", Item " + highestItemIndex + ")");
    }

    public static int calculateTotal(int[] quantities) {
        int total = 0;
        for (int i = 0; i < quantities.length; i++) {
            total += quantities[i];
        }
        return total;
    }
}
