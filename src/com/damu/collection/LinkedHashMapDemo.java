package com.damu.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        // LinkedHashMap with access order enabled (true) - maintains insertion order
        // but when an entry is accessed, it is moved to the end (like LRU cache behavior)
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(11, 0.3f, true);
        linkedHashMap.put("Orange", 10);
        linkedHashMap.put("Apple", 20);
        linkedHashMap.put("Guava", 13);

        // Accessing elements changes their order because accessOrder = true
        linkedHashMap.get("Apple");
        linkedHashMap.get("Orange");
        linkedHashMap.get("Guava");
        linkedHashMap.get("Apple");
        linkedHashMap.get("Orange");
        linkedHashMap.get("Apple");
        linkedHashMap.get("Guava");

        // Iterating through LinkedHashMap (preserves insertion/access order)
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Creating an empty HashMap and wrapping it into a LinkedHashMap
        HashMap<String, Integer> hashMap = new HashMap<>();
        LinkedHashMap<String ,Integer> linkedHashMap1 = new LinkedHashMap(hashMap);

        // Adding elements to HashMap
        hashMap.put("Shubham", 91);
        hashMap.put("Bob", 80);
        hashMap.put("Akshit", 78);

        // getOrDefault returns default value (0) if key not found
        Integer res = hashMap.getOrDefault("Vipul", 0);

        // Updating existing key value
        hashMap.put("Shubham", 92);

        // Printing final HashMap
        System.out.println(hashMap);
    }
}

/*
 * SHORT NOTE:
 * - LinkedHashMap is like HashMap but maintains order (insertion or access).
 * - Here, accessOrder=true means recently accessed entries move to the end.
 * - getOrDefault() helps avoid null by returning a default value if key is absent.
 * - LinkedHashMap can be used to implement caches (like LRU).
 */
