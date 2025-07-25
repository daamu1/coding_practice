package com.damu.collection;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        // Creating HashMap with custom initial capacity and load factor
        HashMap<Integer, String> map = new HashMap<>(17, 0.5f);
        map.put(31, "Shubham");
        map.put(11, "Akshit");
        map.put(2, "Neha");
        map.put(2, "Mehul"); // overwrites value for key 2

        System.out.println(map); // print all key-value pairs

        // Accessing values
        String student = map.get(31); // returns "Shubham"
        System.out.println(student);

        String s = map.get(69); // returns null for absent key
        System.out.println(s);

        // Checking existence of key/value
        System.out.println(map.containsKey(2)); // true
        System.out.println(map.containsValue("Shubham")); // true

        // Iterating using keySet
        for (int i : map.keySet()) {
            System.out.println(map.get(i));
        }

        // Convert all values to uppercase
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            entry.setValue(entry.getValue().toUpperCase());
        }
        System.out.println(map);

        // Attempting to remove key 31 only if value is "Nitin" (will fail)
        boolean res = map.remove(31, "Nitin");
        System.out.println("REMOVED ? :" + res);
        System.out.println(map);

        // Just an unused example of checking existence in a List
        List<Integer> list = Arrays.asList(2, 4, 32, 43, 4, 432);
        list.contains(32); // returns true but result not used
    }
}

/*
 * SHORT NOTE:
 * - HashMap stores key-value pairs with constant-time performance.
 * - Duplicate keys overwrite existing values (e.g., key 2 → "Mehul").
 * - `get()` returns null if key is missing.
 * - `containsKey()` & `containsValue()` help check existence.
 * - Modifying values in entrySet reflects directly in map.
 * - `remove(key, value)` only removes if both match exactly.
 * - Demonstrates standard operations: put, get, contains, remove, iterate.
 */
