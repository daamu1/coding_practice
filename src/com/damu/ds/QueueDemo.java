package com.damu.ds;

import java.util.*;

public class QueueDemo {
    public static void main(String[] args) {
        // Create a Queue (LinkedList-based)
        Queue<Integer> queue = new LinkedList<>();

        // ✅ 1. Enqueue (Add elements)
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);

        System.out.println("Queue after enqueuing: " + queue);

        // ✅ 2. Peek (Get front element without removing)
        System.out.println("Front element (peek): " + queue.peek());

        // ✅ 3. Dequeue (Remove elements)
        System.out.println("Dequeued element: " + queue.poll());
        System.out.println("Queue after dequeuing: " + queue);

        // ✅ 4. Check if queue contains an element
        System.out.println("Queue contains 30? " + queue.contains(30));

        // ✅ 5. Get queue size
        System.out.println("Queue size: " + queue.size());

        // ✅ 6. Iterate through the queue
        System.out.print("Iterating queue: ");
        for (Integer num : queue) {
            System.out.print(num + " ");
        }
        System.out.println();

        // ✅ 7. Clear the queue
        queue.clear();
        System.out.println("Queue after clearing: " + queue);

        // ✅ 8. Check if queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
