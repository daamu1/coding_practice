package com.damu.kata;

import java.util.Map;

public class RockPaperScissors {

    private static final Map<String, String> beats = Map.of(
            "rock", "scissors",
            "scissors", "paper",
            "paper", "rock"
    );

    public static String rps(String p1, String p2) {
        if (p1.equals(p2)) {
            return "Draw!";
        }
        return beats.get(p1).equals(p2) ? "Player 1 won!" : "Player 2 won!";
    }
}
