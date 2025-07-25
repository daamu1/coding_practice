package com.damu.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapDemo {
    public static void main(String[] args) {
        // Creating a modifiable map
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        // Creating an unmodifiable view of map1
        Map<String, Integer> map2 = Collections.unmodifiableMap(map1);
        System.out.println(map2);
//        map2.put("C", 3); // throws UnsupportedOperationException

        // Creating an immutable map using Java 9+ Map.of() (fixed-size, no nulls)
        Map<String, Integer> map3 = Map.of("Shubham", 98, "Vivek", 89);
        // map3.put("Akshit", 88); // throws UnsupportedOperationException

        // Creating another immutable map using Map.ofEntries()
        Map<String, Integer> map4 = Map.ofEntries(
                Map.entry("Akshit", 99),
                Map.entry("Vivek", 99)
        );
    }
}

/*
 * SHORT NOTE:
 * - `Collections.unmodifiableMap(map)` creates a read-only view of the given map.
 * - `Map.of(...)` and `Map.ofEntries(...)` create truly immutable maps (Java 9+).
 * - These immutable maps:
 *    → Do not allow null keys/values
 *    → Cannot be modified (no put/remove)
 * - Trying to modify them throws `UnsupportedOperationException`.
 * - Useful for thread-safe, read-only configurations or constants.
 */
