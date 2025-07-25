package com.damu.kata;

import java.util.HashMap;
import java.util.Map;

public class DuplicateEncoder {
    public static void main(String[] args) {
        System.out.println(encode("din"));           // Output: "((("
        System.out.println(encode("recede"));        // Output: "()()()"
        System.out.println(encode("Success"));       // Output: ")())())"
        System.out.println(encode("(( @"));          // Output: "))(("
    }

    static String encode(String word) {
        if (word == null || word.isEmpty()) {
            return "";
        }

        word = word.toLowerCase();

        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : word.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        StringBuilder encoded = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (charCount.get(c) > 1) {
                encoded.append(")");
            } else {
                encoded.append("(");
            }
        }

        return encoded.toString();
    }
}
