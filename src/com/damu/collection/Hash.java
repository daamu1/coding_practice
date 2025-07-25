package com.damu.collection;

public class Hash {
    public static void main(String[] args) {
        // Calculate and print simple hash values for two strings
        System.out.println(simpleHash("ABC")); // Output: hash value for "ABC"
        System.out.println(simpleHash("CBA")); // Output: hash value for "CBA"
    }

    // Simple hash function: sums ASCII values of characters and takes modulo 10
    public static int simpleHash(String key) {
        int sum = 0;
        for (char c : key.toCharArray()) {
            sum += (int) c; // Add ASCII value of each character
        }
        return sum % 10; // Return remainder to limit hash range (0-9)
    }
}

/*
 * SHORT NOTE:
 * - This is a simple custom hash function.
 * - It adds ASCII values of characters and returns (sum % 10).
 * - Demonstrates how hash codes can vary even for anagrams (e.g., "ABC" vs "CBA").
 * - Not collision-resistant; multiple strings can have the same hash value.
 */
