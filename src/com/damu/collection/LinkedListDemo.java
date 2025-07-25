package com.damu.collection;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Adding elements
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        linkedList.get(2);        // O(n) – linked list traversal
        linkedList.addLast(4);    // O(1) – add to tail
        linkedList.addFirst(0);   // O(1) – add to head
        linkedList.getFirst();    // O(1)
        linkedList.getLast();     // O(1)

        System.out.println("Original LinkedList: " + linkedList); // [0, 1, 2, 3, 4]

        // Remove even numbers
        linkedList.removeIf(x -> x % 2 == 0); // removes 0, 2, 4
        System.out.println("After removing even numbers: " + linkedList); // [1, 3]

        // Remove common elements from another list
        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Cat", "Dog", "Elephant"));
        LinkedList<String> animalsToRemove = new LinkedList<>(Arrays.asList("Dog", "Lion"));

        animals.removeAll(animalsToRemove); // only "Dog" is removed
        System.out.println("Remaining animals: " + animals); // [Cat, Elephant]
    }
}

/*
 * - LinkedList supports fast insertions/removals at head/tail (O(1)).
 * - get(index) is O(n) as it traverses from head or tail.
 * - removeIf(Predicate) allows conditional removal (e.g., even numbers).
 * - removeAll(Collection) removes all elements from the list that exist in the given collection.
 * - Useful for queue-like operations or frequent insertions/deletions.
 */

