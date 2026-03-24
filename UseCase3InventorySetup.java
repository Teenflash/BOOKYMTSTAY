import java.util.HashMap;

/**
 * RoomInventory
 * 
 * Manages centralized room availability using HashMap.
 * Acts as a single source of truth for inventory.
 * 
 * @version 3.1
 */

class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor to initialize inventory
    public RoomInventory() {
        inventory = new HashMap<>();

        // Initial room availability
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    // Get availability of a specific room type
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability (controlled update)
    public void updateAvailability(String roomType, int count) {
        if (inventory.containsKey(roomType)) {
            inventory.put(roomType, count);
        } else {
            System.out.println("Room type not found!");
        }
    }

    // Display full inventory
    public void displayInventory() {
        System.out.println("===== Current Room Inventory =====");

        for (String roomType : inventory.keySet()) {
            System.out.println(roomType + " → Available: " + inventory.get(roomType));
        }
    }
}

/**
 * UseCase3InventorySetup
 * 
 * Demonstrates centralized inventory management using HashMap.
 * 
 * @author Shaunak Kapoor
 * @version 3.1
 */

public class UseCase3InventorySetup {

    public static void main(String[] args) {

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display initial inventory
        inventory.displayInventory();

        System.out.println("\nUpdating availability...\n");

        // Update availability
        inventory.updateAvailability("Single Room", 4);
        inventory.updateAvailability("Suite Room", 1);

        // Display updated inventory
        inventory.displayInventory();

        System.out.println("\nApplication terminated.");
    }
}

javac UseCase3InventorySetup.java
java UseCase3InventorySetup
