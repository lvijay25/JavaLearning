package com.java.learning;

import java.util.Arrays;
import java.util.Optional;

public class LongestStringInArray {

    public static void main(String[] args){
        String[] words = {"Word", "StringBuilder", "John Harrigan", "Nolan Chinn"};
        Optional<String> longest = Arrays.stream(words).reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);
        longest.ifPresentOrElse(System.out::println, () -> System.out.println("Nothing Found..."));
        longest.ifPresent(System.out::println);

        String[] a = {"Word", "StringBuilder", "John Harrigan", " Nolan Chinn"};
        String str1 = String.valueOf(Arrays.stream(a).reduce((value, e) -> value.length() > e.length() ? value : e));
        System.out.println("Longest String " + str1);
    }
}
