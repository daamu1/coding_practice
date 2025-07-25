package com.damu.kata;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PangramChecker {


        public boolean check(String sentence) {
        Map<Character, Integer> alphabetIndexMap = IntStream
                .rangeClosed('a', 'z')
                .boxed()
                .collect(Collectors.toMap(
                        c -> (char) c.intValue(),
                        c -> 0
                ));

        for (char c : sentence.toLowerCase().toCharArray()) {
            if (alphabetIndexMap.containsKey(c)) {
                alphabetIndexMap.put(c, alphabetIndexMap.get(c) + 1);
            }
        }

        return !alphabetIndexMap.containsValue(0);
    }
    public boolean checkVersion2(String sentence) {
        return sentence.chars()
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .distinct().count() == 26;
    }


    public static void main(String[] args) {
        PangramChecker checker = new PangramChecker();
        System.out.println(checker.check("The quick brown fox jumps over the lazy dog")); // true
        System.out.println(checker.check("Hello world")); // false
    }

}