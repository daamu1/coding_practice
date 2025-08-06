package com.damu.collection;

import java.util.Map;
import java.util.NavigableSet;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentSkipListMapDemo {
    public static void main(String[] args) {
        // 🔥 ConcurrentSkipListMap = Thread-safe + Sorted (natural key order)
        // ✅ Backed by Skip List (multi-level linked list for fast search)
        // ✅ Reads are lock-free, writes are fine-grained locked
        // ✅ Sorted like TreeMap but safe for concurrency
        // ❌ Null keys NOT allowed (throws NullPointerException)
        // ✅ Null values ARE allowed

        ConcurrentSkipListMap<String, Integer> map = new ConcurrentSkipListMap<>();

        // Put initial entries (keys will auto-sort)
        map.put("Mango", 10);
        map.put("Apple", 5);
        map.put("Banana", 8);

        // 🧠 Result will be: Apple=5, Banana=8, Mango=10
        System.out.println("Initial Sorted Map: " + map);

        // Simulating concurrent access using threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable writer = () -> {
            // ✅ Thread-safe insertions
            map.put("Pineapple", 7);
            map.put("Grapes", 4);
            System.out.println("Writer added entries.");
        };

        Runnable reader = () -> {
            // ✅ Concurrent reads allowed during write
            System.out.println("Reader sees map: " + map);
        };

        // Start both threads
        executor.execute(writer);
        executor.execute(reader);

        // 🧪 Extra operations from NavigableMap

        // ✅ subMap: range view of the map from Banana to Mango (inclusive)
        ConcurrentNavigableMap<String, Integer> subMap = map.subMap("Banana", true, "Mango", true);
        System.out.println("SubMap (Banana to Mango): " + subMap);

        // ✅ descendingMap: reverse view of the map
        ConcurrentNavigableMap<String, Integer> descendingMap = map.descendingMap();
        System.out.println("Descending Map: " + descendingMap);

        // ✅ ceilingEntry: first key ≥ "Grapes"
        Map.Entry<String, Integer> grapes = map.ceilingEntry("Grapes");
        System.out.println("Ceiling Entry for 'Grapes': " + grapes);

        // ✅ descendingKeySet: all keys in reverse order
        NavigableSet<String> keySet = map.descendingKeySet();
        System.out.println("Descending Keys: " + keySet);

        // ✅ computeIfAbsent: only computes if key is NOT already present
        map.computeIfAbsent("Apple", k -> {
            System.out.println("Computing for missing key: " + k);
            return 100;
        });

        map.computeIfAbsent("Orange", k -> {
            System.out.println("Computing for new key: " + k);
            return 55;
        });

        System.out.println("Map after computeIfAbsent: " + map);

        // Clean shutdown
        executor.shutdown();
    }
}
