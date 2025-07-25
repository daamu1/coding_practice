package com.damu.collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    // Create LinkedHashMap with accessOrder = true for LRU behavior
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); // accessOrder = true
        this.capacity = capacity;
    }

    // Automatically remove the eldest entry if size exceeds capacity
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> studentMap = new LRUCache<>(3);

        // Inserting elements
        studentMap.put("Bob", 99);    // [Bob]
        studentMap.put("Alice", 89);  // [Bob, Alice]
        studentMap.put("Ram", 91);    // [Bob, Alice, Ram]

        // Access "Ram" → moves Ram to most recently used
        studentMap.get("Ram");        // [Bob, Alice, Ram]

        // Add new entry → evicts least recently used (Bob)
        studentMap.put("Vipul", 89);  // [Alice, Ram, Vipul]

        // Add one more → evicts Alice
        studentMap.put("Saurabh", 89); // [Ram, Vipul, Saurabh]

        System.out.println("Final LRU Cache: " + studentMap);
    }
}
/*
 * - LRUCache extends LinkedHashMap using accessOrder = true to maintain usage order.
 * - When new items are added beyond capacity, the least recently used entry is evicted.
 * - `get()` operations affect order and update recency.
 * - This is a simple way to implement LRU Cache in Java.
 * - For thread-safe or production-grade usage, consider `LinkedHashMap` with external synchronization or `ConcurrentLinkedHashMap` (Guava/Caffeine).
 *Your LRUCache does not follow insertion order — it follows access order because accessOrder = true.
 */
