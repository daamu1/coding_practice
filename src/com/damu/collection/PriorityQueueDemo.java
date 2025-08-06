package com.damu.collection;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.NoSuchElementException;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        // ✅ PriorityQueue is part of the Queue interface.
        // ✅ Maintains elements in *natural order* (for numbers: smallest first).
        // ✅ Uses Min-Heap internally (Binary Heap)
        // ✅ Null elements are NOT allowed (NullPointerException)
        // ✅ Does NOT guarantee sorted order in toString() output
        // ✅ Duplicates ARE allowed
        // ✅ Not thread-safe

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // add(E): Inserts the element, throws exception if not possible
        pq.add(15);
        pq.add(10);
        pq.add(30);
        pq.add(5);

        // offer(E): Same as add, but returns false instead of throwing
        System.out.println("Offer 20: " + pq.offer(20));

        // peek(): View head without removing (smallest element)
        System.out.println("Peek (head): " + pq.peek()); // should be 5

        // element(): Same as peek(), but throws if empty
        try {
            System.out.println("Element (head): " + pq.element());
        } catch (NoSuchElementException e) {
            System.out.println("element() failed: Queue is empty");
        }

        // Current queue state (NOT sorted visually)
        System.out.println("Current PriorityQueue: " + pq);

        // poll(): Retrieves and removes head, returns null if empty
        System.out.println("\nPolling all elements (natural order):");
        while (!pq.isEmpty()) {
            System.out.println("Polled: " + pq.poll());
        }

        // remove(): Removes head, throws exception if empty
        try {
            pq.remove();
        } catch (NoSuchElementException e) {
            System.out.println("\nremove() failed: Queue is empty");
        }

        // poll(): Safe removal - returns null if empty
        System.out.println("Poll (on empty queue): " + pq.poll());

        // peek(): Safe read - returns null if empty
        System.out.println("Peek (on empty queue): " + pq.peek());

        // Custom comparator example (Optional, just reference)
         PriorityQueue<String> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
}
