package com.damu.collection;

import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {
    public static void main(String[] args) {
        // IdentityHashMap compares keys using '==' (reference equality) instead of .equals()
        Map<String, Integer> map = new IdentityHashMap<>();

        String key1 = new String("Akshit"); // two different String objects with same content
        String key2 = new String("Akshit");

        map.put(key1, 90); // inserted as separate key
        map.put(key2, 92); // different reference → treated as new key

        System.out.println(map); // shows both entries
    }
}

/*
 * SHORT NOTE:
 * - IdentityHashMap uses `==` (reference equality) for comparing keys, not `equals()`.
 * - Useful when identity (memory address) matters, not content.
 * - Here, even though key1 and key2 have same content ("Akshit"), they are different objects,
 *   so both are stored as separate keys.
 * - Not commonly used in day-to-day apps; mostly used for JVM-level caches, graph traversals, etc.
 */
