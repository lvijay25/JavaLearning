package com.java.streams;

import java.util.List;
import java.util.Optional;

public class LongestString {
    public static void main(String[] args){

        List<String> word = List.of("GFG", "Geeks", "for",
                "GeeksQuiz", "GeeksforGeeks", "Geeks", "for", "GFG", "GFG");
        Optional<String> longestString = word.stream()
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);

        longestString.ifPresent(System.out::println);

        String[] words = {"GFG", "Geeks", "for",
                "GeeksQuiz", "GeeksforGeeks", "Geeks", "for", "GFG", "GFG"};

        for(String s : words){
            if(s.length() > 5){
                System.out.println("For Loop " + s);
            }

        }
    }
}
