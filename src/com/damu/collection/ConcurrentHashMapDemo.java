package com.damu.collection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Java 7: Segment-based locking (default 16 segments internally)
        // Only one segment is locked during updates, improving concurrency.

        // Java 8+: Uses CAS (Compare-And-Swap) for better performance.
        // No segments. Node-based locking only when resizing or collisions happen.

        // Example:
        // Thread A sees x = 45
        // Thread A tries to update it to 50
        // If x is still 45, update happens (atomic compare-and-set)
        // Otherwise, retry or abort

        // Let's simulate multiple threads updating the map

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable writer1 = () -> {
            for (int i = 0; i < 5; i++) {
                map.put("A", map.getOrDefault("A", 0) + 1);
                System.out.println("Writer 1 updated A to: " + map.get("A"));
            }
        };

        Runnable writer2 = () -> {
            for (int i = 0; i < 5; i++) {
                map.put("A", map.getOrDefault("A", 0) + 1);
                System.out.println("Writer 2 updated A to: " + map.get("A"));
            }
        };

        Runnable reader = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Reader reads A as: " + map.get("A"));
            }
        };

        executor.execute(writer1);
        executor.execute(writer2);
        executor.execute(reader);

        executor.shutdown();
    }
}
