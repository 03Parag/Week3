package Week3.Day01;

// InventoryManagementSystem class
class InventoryManagementSystem {
    // Node class representing an item
    class Item {
        // Attributes for item node
        String itemName;
        int itemId;
        int quantity;
        double price;
        Item next;

        // Constructor for an item node
        public Item(String itemName, int itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }

    // Head pointers for the singly linked list
    private Item head = null;

    // Add an item at the beginning of the list
    public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            newItem.next = head;
            head = newItem;
        }
        System.out.println("Item added at the beginning: " + itemName);
    }

    // Add an item at the end of the list
    public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            Item current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newItem;
        }
        System.out.println("Item added at the end: " + itemName);
    }

    // Add an item at a specific position
    public void addItemAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (position == 1) {
            addItemAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        Item current = head;
        int count = 1;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Position out of bounds. Adding at the end.");
            addItemAtEnd(itemName, itemId, quantity, price);
        } else {
            newItem.next = current.next;
            current.next = newItem;
            System.out.println("Item added at position " + position + ": " + itemName);
        }
    }

    // Remove an item by Item ID
    public void removeItemById(int itemId) {
        if (head == null) {
            System.out.println("No items in the inventory.");
            return;
        }
        Item current = head;
        Item previous = null;
        while (current != null && current.itemId != itemId) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Item with ID " + itemId + " not found.");
            return;
        }
        if (previous == null) {
            head = current.next;
        } else {
            previous.next = current.next;
        }
        System.out.println("Item with ID " + itemId + " removed.");
    }

    // Search for an item by Item ID or Item Name
    public void searchItem(String itemName, int itemId) {
        if (head == null) {
            System.out.println("No items in the inventory.");
            return;
        }
        Item current = head;
        boolean found = false;
        while (current != null) {
            if ((itemName != null && current.itemName.equalsIgnoreCase(itemName)) ||
                    (itemId != 0 && current.itemId == itemId)) {
                System.out.println("Item Found: Name: " + current.itemName + ", ID: " + current.itemId + ", Quantity: " + current.quantity + ", Price: " + current.price);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No item found with the given details.");
        }
    }

    // Update the quantity of an item
    public void updateQuantity(int itemId, int newQuantity) {
        if (head == null) {
            System.out.println("No items in the inventory.");
            return;
        }
        Item current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                System.out.println("Quantity updated for item ID " + itemId + ": " + newQuantity);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Calculate and display the total value of the inventory
    public void calculateTotalInventoryValue() {
        if (head == null) {
            System.out.println("No items in the inventory.");
            return;
        }
        double totalValue = 0;
        Item current = head;
        while (current != null) {
            totalValue += current.quantity * current.price;
            current = current.next;
        }
        System.out.println("Total inventory value: " + totalValue);
    }

    // Sort items based on Item Name or Price
    public void sortInventory(String criteria, boolean ascending) {
        if (head == null) {
            System.out.println("No items to sort.");
            return;
        }
        // Sorting based on Item Name or Price
        Item current = head;
        Item index = null;
        String tempItemName;
        int tempItemId;
        int tempQuantity;
        double tempPrice;

        if (criteria.equalsIgnoreCase("name")) {
            while (current != null) {
                index = current.next;
                while (index != null) {
                    if ((ascending && current.itemName.compareToIgnoreCase(index.itemName) > 0) || (!ascending && current.itemName.compareToIgnoreCase(index.itemName) < 0)) {
                        tempItemName = current.itemName;
                        current.itemName = index.itemName;
                        index.itemName = tempItemName;

                        tempItemId = current.itemId;
                        current.itemId = index.itemId;
                        index.itemId = tempItemId;

                        tempQuantity = current.quantity;
                        current.quantity = index.quantity;
                        index.quantity = tempQuantity;

                        tempPrice = current.price;
                        current.price = index.price;
                        index.price = tempPrice;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        } else if (criteria.equalsIgnoreCase("price")) {
            while (current != null) {
                index = current.next;
                while (index != null) {
                    if ((ascending && current.price > index.price) ||
                            (!ascending && current.price < index.price)) {
                        tempItemName = current.itemName;
                        current.itemName = index.itemName;
                        index.itemName = tempItemName;

                        tempItemId = current.itemId;
                        current.itemId = index.itemId;
                        index.itemId = tempItemId;

                        tempQuantity = current.quantity;
                        current.quantity = index.quantity;
                        index.quantity = tempQuantity;

                        tempPrice = current.price;
                        current.price = index.price;
                        index.price = tempPrice;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
        System.out.println("Inventory sorted by " + criteria + " in " + (ascending ? "ascending" : "descending") + " order.");
    }

    // Display items in the inventory
    public void displayInventory() {
        if (head == null) {
            System.out.println("No items in the inventory.");
            return;
        }
        System.out.println("Inventory list:");
        Item current = head;
        while (current != null) {
            System.out.println("Item Name: " + current.itemName + ", Item ID: " + current.itemId +
                    ", Quantity: " + current.quantity + ", Price: " + current.price);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();

        // Add items
        inventory.addItemAtEnd("Laptop", 101, 20, 50000.0);
        inventory.addItemAtBeginning("Smartphone", 102, 50, 30000.0);
        inventory.addItemAtPosition("Headphones", 103, 100, 1500.0, 2);

        // Display items
        System.out.println();
        inventory.displayInventory();

        // Search for an item
        System.out.println();
        inventory.searchItem(null, 103);

        // Update quantity of an item
        System.out.println();
        inventory.updateQuantity(102, 45);

        // Calculate total inventory value
        System.out.println();
        inventory.calculateTotalInventoryValue();

        // Sort inventory by price in ascending order
        System.out.println();
        inventory.sortInventory("price", true);

        // Display sorted inventory
        System.out.println();
        inventory.displayInventory();

        // Remove an item
        System.out.println();
        inventory.removeItemById(101);

        // Display items after removal
        System.out.println();
        inventory.displayInventory();
    }
}


