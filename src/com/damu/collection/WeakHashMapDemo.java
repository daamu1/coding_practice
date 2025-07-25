package com.damu.collection;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        // Create a WeakHashMap where keys are weakly referenced
        WeakHashMap<String, Image> imageCache = new WeakHashMap<>();

        // Load image cache with temporary String keys
        loadCache(imageCache);

        // Print current cache contents
        System.out.println("Before GC: " + imageCache);

        // Suggest JVM to run garbage collection
        System.gc();

        // Simulate a delay to give GC time to run
        simulateApplicationRunning();

        // After GC, weakly-referenced keys with no strong references may be removed
        System.out.println("Cache after running (some entries may be cleared): " + imageCache);
    }

    public static void loadCache(Map<String, Image> imageCache) {
        // Use new String() to ensure keys are not interned (and are weakly referenced)
        String k1 = new String("img1");
        String k2 = new String("img2");

        // Put entries into the WeakHashMap
        imageCache.put(k1, new Image("Image 1"));
        imageCache.put(k2, new Image("Image 2"));

        // After this method ends, k1 and k2 go out of scope
        // and become eligible for garbage collection
    }

    private static void simulateApplicationRunning() {
        try {
            System.out.println("Simulating application running...");
            Thread.sleep(10000); // Wait 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Image class to represent some cacheable object
class Image {
    private String name;

    public Image(String name) {
        this.name = name;
    }

    // To print object nicely in output
    @Override
    public String toString() {
        return name;
    }
}



/*
 * ✅ WeakHashMap:
 * - Keys are stored using weak references.
 * - If a key has no strong references elsewhere, GC can reclaim it.
 * - Corresponding entries are removed automatically from the map.
 *
 * ✅ Why use `new String("img1")`?
 * - Prevents string interning.
 * - Ensures that keys are not strongly referenced by the String pool.
 *
 * ✅ GC behavior:
 * - Calling System.gc() suggests garbage collection, but it's not guaranteed.
 * - Delay allows GC to potentially remove weak keys.
 *
 * ✅ Use Cases:
 * - Image caches
 * - Listener registries
 * - Memory-sensitive mappings
 */
