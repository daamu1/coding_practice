package com.damu.collection;

import java.util.Hashtable;

public class HashtableDemo {
    public static void main(String[] args) {
        /*
         * Hashtable is:
         * - Legacy class (older than HashMap)
         * - Thread-safe: all methods are synchronized
         * - Does NOT allow null keys or values
         * - Slower than HashMap due to synchronization
         * - Uses only linked list for handling collisions
         */

        // Sample basic usage (commented out)
        /*
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(1, "Apple");
        hashtable.put(2, "Banana");
        hashtable.put(3, "Cherry");
        System.out.println(hashtable);
        System.out.println("Value for key 2: " + hashtable.get(2));
        System.out.println("Does key 3 exist? " + hashtable.containsKey(3));
        hashtable.remove(1);
        System.out.println("After removing key 1: " + hashtable);
        // hashtable.put(null, "value"); // Throws NullPointerException
        // hashtable.put(4, null);       // Throws NullPointerException
        */

        // Multithreaded access demonstration
        Hashtable<Integer, String> map = new Hashtable<>();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put(i, "Thread1");
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                map.put(i, "Thread2");
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Expected size is 2000 as both threads add unique keys
        System.out.println("Final size of HashMap: " + map.size());
    }
}

/*
 * SHORT NOTE:
 * - Hashtable is synchronized and thread-safe (unlike HashMap).
 * - It does not allow null keys or values.
 * - All operations (put/get/remove) are synchronized → slower.
 * - Suitable for legacy multithreaded applications, but now replaced by ConcurrentHashMap.
 * - In the example, two threads safely put data into the same map without conflict.
 */
