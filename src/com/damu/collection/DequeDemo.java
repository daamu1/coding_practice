package com.damu.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class DequeDemo {
    public static void main(String[] args) {
        /*
         ✅ Deque = Double Ended Queue
         ✅ Supports insertion/removal from both front and rear
         ✅ Implements both stack and queue functionality
         ✅ Implementations: ArrayDeque (faster), LinkedList (flexible)
         ✅ Null elements not allowed in ArrayDeque (throws NullPointerException)
         */

        // -----------------------------
        // Using ArrayDeque
        // -----------------------------
        Deque<Integer> deque1 = new ArrayDeque<>();

        // ========== INSERTION METHODS ==========
        deque1.addFirst(10);    // throws exception if capacity limit reached
        deque1.addLast(20);
        deque1.offerFirst(5);   // returns false if failed
        deque1.offerLast(25);
        // Current: [5, 10, 20, 25]
        System.out.println("After insertion: " + deque1);

        // ========== EXAMINATION METHODS ==========
        System.out.println("getFirst(): " + deque1.getFirst());    // throws if empty
        System.out.println("getLast(): " + deque1.getLast());
        System.out.println("peekFirst(): " + deque1.peekFirst());  // returns null if empty
        System.out.println("peekLast(): " + deque1.peekLast());

        // ========== REMOVAL METHODS ==========
        deque1.removeFirst();   // removes 5
        deque1.removeLast();    // removes 25
        System.out.println("After removeFirst & removeLast: " + deque1); // [10, 20]

        deque1.offerFirst(100);
        deque1.offerLast(200);
        System.out.println("With offerFirst/Last: " + deque1); // [100, 10, 20, 200]

        System.out.println("pollFirst(): " + deque1.pollFirst());  // removes 100
        System.out.println("pollLast(): " + deque1.pollLast());    // removes 200

        // ========== STACK METHODS ==========
        deque1.push(99);  // same as addFirst
        System.out.println("After push(99): " + deque1);
        System.out.println("pop(): " + deque1.pop()); // removes 99 (same as removeFirst)

        // ========== ITERATION ==========
        System.out.println("Final Deque contents:");
        for (int val : deque1) {
            System.out.println(val);
        }

        // ========== EDGE CASES ==========
        deque1.clear();
        System.out.println("\nAfter clearing deque1:");
        System.out.println("peekFirst(): " + deque1.peekFirst());  // null
        System.out.println("pollLast(): " + deque1.pollLast());    // null

        try {
            deque1.getFirst(); // throws NoSuchElementException
        } catch (NoSuchElementException e) {
            System.out.println("getFirst() failed on empty deque: " + e);
        }

        // -----------------------------
        // Using LinkedList as Deque
        // -----------------------------
        Deque<String> deque2 = new LinkedList<>();
        deque2.add("One");
        deque2.addLast("Two");
        deque2.addFirst("Zero");
        deque2.push("Minus One");
        System.out.println("\nLinkedList-backed Deque: " + deque2); // [Minus One, Zero, One, Two]
    }
}
