package com.damu.kata;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Accumul {
    public static String accum(String s) {
        StringBuilder result = new StringBuilder();
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            result.append(Character.toUpperCase(ch));

            for (int j = 0; j < i; j++) {
                result.append(Character.toLowerCase(ch));
            }

            if (i != charArray.length - 1) {
                result.append("-");
            }
        }

        return result.toString();
    }
    public static String accumVersion2(String s) {
        var chars = s.split("");

        return IntStream.range(0, chars.length)
                .mapToObj(i -> chars[i].toUpperCase() + chars[i].toLowerCase().repeat(i))
                .collect(Collectors.joining("-"));
    }
    public static void main(String[] args) {
        System.out.println(accum("abcd"));
        System.out.println(accum("RqaEzty"));
    }
}
