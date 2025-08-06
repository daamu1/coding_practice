package com.damu.collection;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueDemo {
    public static void main(String[] args) {
        // ✅ Queue: FIFO (First-In-First-Out) data structure
        // ✅ Java provides it via java.util.Queue interface
        // ✅ Used when order of processing matters (e.g., task scheduling)

        // 🔸 LinkedList implements Queue (non-thread-safe, allows null)
        Queue<Integer> linkedListQueue = new LinkedList<>();

        // add(E) - throws exception if fails
        System.out.println("Add 10: " + linkedListQueue.add(10));
        System.out.println("Add 20: " + linkedListQueue.add(20));

        // offer(E) - returns false if fails (no exception)
        System.out.println("Offer 30: " + linkedListQueue.offer(30));

        // element() - retrieves head without removing, throws exception if empty
        try {
            System.out.println("Element (head): " + linkedListQueue.element());
        } catch (NoSuchElementException e) {
            System.out.println("element() failed: Queue is empty");
        }

        // peek() - retrieves head without removing, returns null if empty
        System.out.println("Peek (head): " + linkedListQueue.peek());

        // remove() - removes head, throws exception if empty
        try {
            System.out.println("Remove (head): " + linkedListQueue.remove());
        } catch (NoSuchElementException e) {
            System.out.println("remove() failed: Queue is empty");
        }

        // poll() - removes head, returns null if empty
        System.out.println("Poll (head): " + linkedListQueue.poll());

        // Show remaining queue
        System.out.println("Remaining Queue: " + linkedListQueue);


        System.out.println("\n======== ArrayBlockingQueue Demo (Thread-Safe, Bounded) ========");
        Queue<Integer> arrayQueue = new ArrayBlockingQueue<>(3);

        // add(E)
        System.out.println("Add 1: " + arrayQueue.add(1));
        System.out.println("Add 2: " + arrayQueue.add(2));

        // offer(E)
        System.out.println("Offer 3: " + arrayQueue.offer(3));
        System.out.println("Offer 4 (should fail): " + arrayQueue.offer(4)); // returns false

        // peek()
        System.out.println("Peek (head): " + arrayQueue.peek());

        // element()
        System.out.println("Element (head): " + arrayQueue.element());

        // remove()
        System.out.println("Remove (head): " + arrayQueue.remove());

        // poll()
        System.out.println("Poll (head): " + arrayQueue.poll());

        // Final state of arrayQueue
        System.out.println("Final Queue: " + arrayQueue);

        // remove() when empty (should throw)
        arrayQueue.poll(); // removing 1 element left
        try {
            arrayQueue.remove(); // now empty, should throw
        } catch (NoSuchElementException e) {
            System.out.println("remove() failed: Queue is empty");
        }
    }
}

