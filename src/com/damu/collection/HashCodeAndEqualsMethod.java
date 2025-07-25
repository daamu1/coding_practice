package com.damu.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeAndEqualsMethod {
    public static void main(String[] args) {
        // Creating a HashMap with Person as key and job title as value
        HashMap<Person, String> map = new HashMap<>();
        Person p1 = new Person("Alice", 1);
        Person p2 = new Person("Bob", 2);
        Person p3 = new Person("Alice", 1); // same content as p1

        // Adding entries to the map
        map.put(p1, "Engineer");
        map.put(p2, "Designer");
        map.put(p3, "Manager"); // p3 is logically equal to p1, so value is replaced

        // Print size and values to verify replacement
        System.out.println("HashMap Size: " + map.size());
        System.out.println("Value for p1: " + map.get(p1));
        System.out.println("Value for p3: " + map.get(p3));

        // String-keyed HashMap demonstrating same concept
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Shubham", 90); // hashcode --> index --> insert
        map1.put("Neha", 92);
        map1.put("Shubham", 99); // same key --> replaces previous value
    }
}

class Person {
    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getters
    public String getName() { return name; }
    public int getId() { return id; }

    // hashCode based on both name and id
    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    // equals compares name and id
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // same reference
        if (obj == null || getClass() != obj.getClass()) return false;
        Person other = (Person) obj;
        return id == other.getId() && Objects.equals(name, other.getName());
    }

    // For better display
    @Override
    public String toString() {
        return "id: " + id + ", name: " + name;
    }
}

/*
 * SHORT NOTE:
 * - In HashMap, keys are compared using hashCode() first, then equals().
 * - p1 and p3 have same name and id, so they're equal → p3 replaces p1's value.
 * - Always override both equals() and hashCode() for custom key objects.
 * - In case of same hash and equality, value gets updated instead of adding new entry.
 */
