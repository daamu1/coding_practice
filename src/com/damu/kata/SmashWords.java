package com.damu.kata;

import java.util.Arrays;

public class SmashWords {
    public static void main(String[] args) {
        System.out.println(smash("Hello", "saurabh"));
    }
    public static String smash(String... words) {
        // TODO Write your code below this comment please
        return String.join(" ",words);
    }
}
