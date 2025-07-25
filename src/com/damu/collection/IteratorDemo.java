package com.damu.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {
    public static void main(String[] args) {
        // Empty list to demonstrate enhanced for-loop and basic iterator
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        // Enhanced for-loop
        for (int i : list) {
            System.out.println("For-each: " + i);
        }

        // Iterator traversal
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("Iterator: " + iterator.next());
        }

        // Another list with numbers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // ❌ This enhanced loop causes ConcurrentModificationException
        // ✅ Use iterator.remove() to safely remove while iterating
        Iterator<Integer> itr = numbers.iterator();
        while (itr.hasNext()) {
            Integer number = itr.next();
            if (number % 2 == 0) {
                itr.remove(); // safe removal
            }
        }

        System.out.println("After removing even numbers: " + numbers); // Output: [1, 3, 5]

        // Demonstrate ListIterator
        ListIterator<Integer> listIterator = numbers.listIterator();
        while (listIterator.hasNext()) {
            Integer current = listIterator.next();
            listIterator.set(current * 10); // modifying elements
        }

        System.out.println("After modification using ListIterator: " + numbers); // Output: [10, 30, 50]
    }
}
