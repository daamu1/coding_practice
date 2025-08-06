package com.damu.collection;

import java.util.Comparator;
import java.util.concurrent.*;

// Producer thread that inserts values into the BlockingQueue
class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;
    private int value = 0;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Producer produced: " + value);
                queue.put(value++); // Blocks if the queue is full
                Thread.sleep(1000);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer interrupted");
            }
        }
    }
}

// Consumer thread that retrieves values from the BlockingQueue
class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer value = queue.take(); // Blocks if the queue is empty
                System.out.println("Consumer consumed: " + value);
                Thread.sleep(2000);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer interrupted");
            }
        }
    }
}

// Main class to demonstrate all BlockingQueue types
public class BockingQueueDemo {
    public static void main(String[] args) {

        // --------- 1. ArrayBlockingQueue ----------
        BlockingQueue<Integer> arrayQueue = new ArrayBlockingQueue<>(5);
        // Bounded, backed by array
        // Single lock, suitable for small fixed capacity
        new Thread(new Producer(arrayQueue)).start();
        new Thread(new Consumer(arrayQueue)).start();

        // --------- 2. LinkedBlockingQueue ----------
        BlockingQueue<Integer> linkedQueue = new LinkedBlockingQueue<>();
        // Optionally bounded, backed by linked nodes
        // Uses separate locks for put and take (better concurrency)
        try {
            linkedQueue.put(10); // won't block as it's unbounded
            System.out.println("LinkedBlockingQueue: " + linkedQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // --------- 3. PriorityBlockingQueue ----------
        BlockingQueue<String> priorityQueue = new PriorityBlockingQueue<>(11, Comparator.reverseOrder());
        // Unbounded, elements ordered using comparator
        priorityQueue.add("apple");
        priorityQueue.add("banana");
        priorityQueue.add("cherry");

        System.out.println("PriorityBlockingQueue: ");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll()); // Elements come out in descending order
        }

        // --------- 4. SynchronousQueue ----------
        BlockingQueue<Integer> syncQueue = new SynchronousQueue<>();
        // No capacity — every put must wait for a take
        Thread syncProducer = new Thread(() -> {
            try {
                System.out.println("SynchronousQueue Producer trying to put 100");
                syncQueue.put(100);
                System.out.println("SynchronousQueue Producer put done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread syncConsumer = new Thread(() -> {
            try {
                Thread.sleep(1000); // Wait for producer to be ready
                Integer val = syncQueue.take();
                System.out.println("SynchronousQueue Consumer got: " + val);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        syncProducer.start();
        syncConsumer.start();
    }
}
