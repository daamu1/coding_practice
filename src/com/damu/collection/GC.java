package com.damu.collection;

import java.lang.ref.WeakReference;

public class GC {
    public static void main(String[] args) {
        // Creating a WeakReference to a new Phone object
        WeakReference<Phone> phoneWeakReference = new WeakReference<>(new Phone("Apple", "16 pro max"));

        // At this point, the Phone object is weakly reachable only
        System.out.println("Before GC: " + phoneWeakReference.get());

        // Suggest JVM to perform garbage collection
        System.gc();

        // Delay to give GC time to collect the weakly reachable object
        try {
            Thread.sleep(10000);
        } catch (Exception ignored) {}

        // After GC, the object may be collected, so get() might return null
        System.out.println("After GC: " + phoneWeakReference.get());
    }
}

// A simple class representing a phone
class Phone {
    String brand;
    String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}


/*
 * ✅ WeakReference:
 * - Allows the referenced object to be garbage collected if no strong references exist.
 * - Used in memory-sensitive applications (e.g., caches, pools).

 * ✅ Behavior in this program:
 * - A `Phone` object is wrapped in a WeakReference.
 * - No strong reference is held to the Phone object.
 * - After System.gc() and a short pause, the object is likely collected.
 * - So, `phoneWeakReference.get()` will likely return null.

 * ✅ Use Cases:
 * - Avoid memory leaks in large object caches.
 * - Reference objects that can be recreated if needed.
 * - Implement memory-sensitive resource tracking.
 */
