package Week3.Day02;

import java.util.LinkedList;

// CustomHashMap class
class CustomHashMap<K, V> {
    // Array of linked lists and default value
    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] table;

    // Entry class for key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;
        // Constructor for entry
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor for CustomHashMap
    public CustomHashMap() {
        table = new LinkedList[INITIAL_CAPACITY];
        // Loop through the default value
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            // Initialize each bucket
            table[i] = new LinkedList<>();
        }
    }

    // Compute hash index
    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    // Insert or update a key-value pair
    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // Check if key exists and update it
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                // Update existing value
                entry.value = value;
                return;
            }
        }
        // Otherwise, insert new entry
        bucket.add(new Entry<>(key, value));
    }

    // Retrieve the value associated with a key
    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // Search for key
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                // Return found value
                return entry.value;
            }
        }
        // Key not found
        return null;
    }

    // Remove a key-value pair
    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // Iterate and remove the entry if found
        bucket.removeIf(entry -> entry.key.equals(key));
    }

    public static void main(String[] args) {
        // Instance of the class
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        // Insert key-value pairs
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        // Update Alice's value
        map.put("Alice", 28);

        // Retrieve values
        System.out.println("Alice's age: " + map.get("Alice"));
        System.out.println("Bob's age: " + map.get("Bob"));

        // Remove a key
        map.remove("Alice");
        System.out.println("Alice's age after removal: " + map.get("Alice"));
    }
}
