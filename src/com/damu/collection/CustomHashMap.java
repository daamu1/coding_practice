package com.damu.collection;

import java.util.LinkedList;

class OwnHashMap<K, V> {
    private static final int SIZE = 16;
    private final LinkedList<Entry<K, V>>[] buckets;

    static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public OwnHashMap() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        bucket.add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        bucket.removeIf(entry -> entry.key.equals(key));
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }


    public static class CustomHashMap {
        public static void main(String[] args) {
            OwnHashMap<String, String> map = new OwnHashMap<>();
            String sharedValue = "Saurabh"; // same object for all keys

            map.put("name", sharedValue);
            map.put("lang", sharedValue);
            map.put("course", sharedValue);
            map.put("language", sharedValue);


            System.out.println(map.get("name"));
            System.out.println(map.containsKey("lang"));

            map.remove("name");
            System.out.println(map.get("name"));
        }
    }

}
