package com.damu.kata;

import java.util.List;
import java.util.stream.Collectors;

public class FriendAndFoe {
    public static List<String> friend(List<String> x){
        // Your code here
        return x.stream().filter(s -> s.length()==4).collect(Collectors.toList());
    }
}