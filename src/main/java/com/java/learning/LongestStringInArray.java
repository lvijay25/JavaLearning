package com.java.learning;

import java.util.Arrays;
import java.util.Optional;

public class LongestStringInArray {

    public static void main(String[] args){
        String[] words = {"Word", "StringBuilder", "John Harrigan", " Nolan Chinn"};
        Optional<String> longest = Arrays.stream(words).reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);
        longest.ifPresentOrElse(System.out::println, () -> System.out.println("Nothing Found..."));
        longest.ifPresent(System.out::println);
    }
}
