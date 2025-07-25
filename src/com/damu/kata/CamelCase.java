package com.damu.kata;

public class CamelCase {
    public static void main(String[] args) {
        String[] shades = shadesOfGrey(10);
        for (String shade : shades) {
            System.out.println(shade);
        }

        System.out.println(camelCase("saurabh maithani is a java developer"));
        System.out.println(camelCase("HELLO WORLD!"));
        System.out.println(camelCase("java_programming_language"));
    }

    public static String[] shadesOfGrey(int num) {
        if (num <= 0) {
            return new String[0];
        }
        int limit = Math.min(num, 254);
        String[] shades = new String[limit];
        for (int i = 1; i <= limit; i++) {
            String hex = String.format("%02x", i);
            shades[i - 1] = "#" + hex + hex + hex;
        }

        return shades;
    }

    public static String camelCase(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        String[] words = input.split("[^a-zA-Z0-9]+");
        StringBuilder camelCaseString = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!word.isEmpty()) {
                if (i == 0) {
                    camelCaseString.append(word.toLowerCase());
                } else {
                    camelCaseString.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase());
                }
            }
        }

        return camelCaseString.toString();
    }
}
