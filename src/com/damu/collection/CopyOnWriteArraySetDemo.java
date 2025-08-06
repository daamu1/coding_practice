package com.damu.collection;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetDemo {
    public static void main(String[] args) {
        // 🔐 Thread-Safe Set Implementations

        // ✅ CopyOnWriteArraySet
        // ➤ Based on CopyOnWriteArrayList
        // ➤ On write (add/remove), it makes a fresh copy of the array
        // ➤ Good for read-heavy operations
        // ➤ Slow on write-heavy usage (due to copying)
        // ➤ Iterators do NOT reflect modifications made during iteration
        // ➤ Maintains insertion order
        // ➤ No duplicates allowed

        // ✅ ConcurrentSkipListSet
        // ➤ Backed by ConcurrentSkipListMap (internally)
        // ➤ Sorted Set (Natural Order or Comparator)
        // ➤ Thread-safe using lock-free algorithms (CAS)
        // ➤ Modifications DURING iteration are allowed and reflected
        // ➤ Suitable for concurrent applications with sorted data

        CopyOnWriteArraySet<Integer> copyOnWriteSet = new CopyOnWriteArraySet<>();
        ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();

        // ✅ Adding elements (1 to 5)
        for (int i = 1; i <= 5; i++) {
            copyOnWriteSet.add(i);
            concurrentSkipListSet.add(i);
        }

        System.out.println("Initial CopyOnWriteArraySet: " + copyOnWriteSet);
        System.out.println("Initial ConcurrentSkipListSet: " + concurrentSkipListSet);

        // ✅ Iterating & modifying CopyOnWriteArraySet
        // ➤ Adding 6 multiple times, but only one will be added
        // ➤ Iterator will NOT see modifications during loop
        System.out.println("\nIterating and modifying CopyOnWriteArraySet:");
        for (Integer num : copyOnWriteSet) {
            System.out.println("Reading from CopyOnWriteArraySet: " + num);
            copyOnWriteSet.add(6); // Will not cause ConcurrentModificationException
        }
        System.out.println("After iteration: " + copyOnWriteSet);

        // ✅ Iterating & modifying ConcurrentSkipListSet
        // ➤ Allows concurrent modification
        // ➤ Updated set will be visible to next iterations
        System.out.println("\nIterating and modifying ConcurrentSkipListSet:");
        for (Integer num : concurrentSkipListSet) {
            System.out.println("Reading from ConcurrentSkipListSet: " + num);
            concurrentSkipListSet.add(6); // No ConcurrentModificationException
        }
        System.out.println("After iteration: " + concurrentSkipListSet);
    }
}
