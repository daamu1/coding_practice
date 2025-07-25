package com.damu.collection;

import java.util.LinkedList;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        // Create Vector with initial capacity 5 and capacity increment 3
        Vector<Integer> list = new Vector<>(5, 3);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        System.out.println("Capacity after 5 elements: " + list.capacity()); // 5

        list.add(1); // triggers capacity increase: 5 + 3 = 8
        System.out.println("Capacity after 6 elements: " + list.capacity()); // 8

        list.add(1);
        list.add(1); // now size = 8
        System.out.println("Capacity after 8 elements: " + list.capacity()); // 8

        list.add(1); // triggers another capacity increase: 8 + 3 = 11
        System.out.println("Capacity after 9 elements: " + list.capacity()); // 11

        // Create LinkedList and copy to Vector
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        Vector<Integer> vector1 = new Vector<>(linkedList);
        System.out.println("Copied Vector from LinkedList: " + vector1);

        // Iteration using index
        for (int i = 0; i < vector1.size(); i++) {
            System.out.println("Element at " + i + ": " + vector1.get(i));
        }

        // Clear vector
        vector1.clear();
        System.out.println("After clearing vector1: " + vector1);

        // Multithreaded write to Vector (safe, as Vector is synchronized)
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Output should be 9 (initial items) + 1000 + 1000 = 2009
        System.out.println("Size of list after threading: " + list.size());
    }
}

/*
 * - Vector is a legacy synchronized collection (thread-safe by default).
 * - It grows in size automatically based on capacityIncrement (if given).
 * - Use get(), add(), clear(), and iteration like an ArrayList.
 * - Vector is slower than ArrayList due to synchronization.
 * - Copy constructor can be used to create a Vector from any Collection (e.g., LinkedList).
 * - Thread-safe writes are demonstrated using t1 and t2 writing simultaneously.
 * - Use Vector only when you need built-in synchronization. Prefer ArrayList + manual sync or Concurrent collections otherwise.
 */

