public class Item {
    String itemName;
    int stock;

    public Item(String itemName, int stock) {
        this.itemName = itemName;
        this.stock = stock;
    }

    public void restock(int stock) {
        this.stock = this.stock + stock;
    }

    public static void main(String[] args) {
        Item[] items = new Item[4];
        items[0] = new Item("Samosa", 15);
        items[1] = new Item("Tea Powder", 40);
        items[2] = new Item("Bread", 8);
        items[3] = new Item("Biscuit Packs", 25);

        for (int i = 0; i < items.length; i++) {
            items[i].restock(20);
            System.out.println(items[i].itemName + " | Final Stock: " + items[i].stock);
        }
    }
}
