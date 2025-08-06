package com.damu.collection;

import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {
    public static void main(String[] args) {

        // SortedMap with descending key order using custom comparator
        SortedMap<Integer, String> map = new TreeMap<>((a, b) -> b - a);

        // Adding key-value pairs
        map.put(91, "Vivek");
        map.put(99, "Shubham");
        map.put(78, "Mohit");
        map.put(77, "Vipul");

        // Access value by key
        map.get(77); // Returns "Vipul"

        // Check if a key exists
        map.containsKey(78); // true

        // Wrong usage: containsValue expects a String, but 77 is an Integer
        map.containsValue(77); // false — values are Strings

        // TreeMap methods for SortedMap (useful but commented out)
        // System.out.println(map);                // {99=Shubham, 91=Vivek, 78=Mohit, 77=Vipul}
        // System.out.println(map.firstKey());     // 99 (highest, because of descending)
        // System.out.println(map.lastKey());      // 77 (lowest)
        // System.out.println(map.headMap(91));    // Keys > 91 → {99=Shubham}
        // System.out.println(map.tailMap(91));    // Keys ≤ 91 → {91=Vivek, 78=Mohit, 77=Vipul}

        // NavigableMap gives more navigation functions like lowerKey, ceilingKey, etc.
        NavigableMap<Integer, String> navigableMap = new TreeMap<>(); // natural ascending order
        navigableMap.put(1, "One");
        navigableMap.put(5, "Five");
        navigableMap.put(3, "Three");

        // Output an entire map (sorted by key)
        System.out.println(navigableMap); // {1=One, 3=Three, 5=Five}

        // Returns greatest key < 4 → 3
        System.out.println(navigableMap.lowerKey(4)); // 3

        // Returns smallest key ≥ 3 → 3
        System.out.println(navigableMap.ceilingKey(3)); // 3

        // Returns Map.Entry of key > 1 → 3=Three
        System.out.println(navigableMap.higherEntry(1)); // 3=Three

        // Reverses the map order (descending)
        System.out.println(navigableMap.descendingMap()); // {5=Five, 3=Three, 1=One}
    }
}
/*
 * - Map stores key-value pairs with unique keys.
 * - SortedMap (like TreeMap) maintains keys in sorted order.
 * - By default, TreeMap sorts in ascending; use custom comparator for descending.
 * - NavigableMap extends SortedMap and adds navigation methods:
 *   - lowerKey(k): greatest key < k
 *   - floorKey(k): greatest key ≤ k
 *   - ceilingKey(k): smallest key ≥ k
 *   - higherKey(k): smallest key > k
 *   - descendingMap(): reverse the map
 * - TreeMap does’t allow null keys, but allows null values.
 * - Common use cases: leaderboard, range lookups, sorted views.
 */