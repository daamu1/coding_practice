package com.damu.collection;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class SetOverview {
    public static void main(String[] args) {
        // 🔥 Set = Collection that does NOT allow duplicate elements
        // ✅ Unique elements only
        // ✅ Null allowed (except in some cases like Set.of)
        // ✅ No guaranteed order (except LinkedHashSet / TreeSet)
        // ✅ Faster search than List (usually O(1) or O(log n))

        // Common Implementations:
        // ✅ HashSet           - Fast, unordered
        // ✅ LinkedHashSet     - Maintains insertion order
        // ✅ TreeSet           - Sorted (natural or comparator)
        // ✅ EnumSet           - High-perf for enum values
        // ✅ ConcurrentSkipListSet - Thread-safe + sorted

        NavigableSet<Integer> set = new TreeSet<>();

        // 🔧 Basic Methods of Set
        set.add(12);                    // ✅ Add element
        set.add(1);
        set.add(1);                     // ❌ Duplicate, will be ignored
        set.add(67);
        System.out.println("Set: " + set); // [1, 12, 67] → sorted in TreeSet

        System.out.println(set.contains(12)); // ✅ Check if element exists → true

        System.out.println(set.remove(67));   // ✅ Remove element → true

        set.clear();                          // ✅ Remove all elements

        System.out.println(set.isEmpty());    // ✅ Check if set is empty → true

        set.addAll(Arrays.asList(5, 6, 7, 1, 2, 3)); // ✅ Add multiple elements

        for (int i : set) {
            System.out.println("Element: " + i);    // ✅ Iterate using for-each
        }

        // 🔐 Thread-safe Set (sorted)
        Set<Integer> threadSafeSet = new ConcurrentSkipListSet<>();
        threadSafeSet.add(10);
        threadSafeSet.add(2);
        threadSafeSet.add(100);
        System.out.println("Thread-safe Set: " + threadSafeSet); // Sorted order

        // ❌ Cannot modify after creation (Immutable Set - Java 9+)
        Set<Integer> immutableSet = Set.of(1, 2, 3, 4, 5);
        System.out.println("Immutable Set: " + immutableSet);
//        immutableSet.add(12); throw exception immutable list
// ✅ Conversions
        List<Integer> list = new ArrayList<>(set);     // Convert Set to List
        Set<Integer> fromList = new HashSet<>(list);   // Convert List to Set

        // 🧠 Additional Methods in NavigableSet (e.g., TreeSet)
        NavigableSet<Integer> navSet = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println(navSet.lower(30));     // < 30 → 20
        System.out.println(navSet.higher(30));    // > 30 → 40
        System.out.println(navSet.floor(30));     // ≤ 30 → 30
        System.out.println(navSet.ceiling(25));   // ≥ 25 → 30
        System.out.println(navSet.pollFirst());   // Remove + return first → 10
        System.out.println(navSet.pollLast());    // Remove + return last → 50
        System.out.println("Remaining: " + navSet);

        Set<Integer> synchroniseSet = Collections.synchronizedSet(navSet);
        System.out.println(synchroniseSet);
    }
}
