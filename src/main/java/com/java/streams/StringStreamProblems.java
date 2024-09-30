package com.java.streams;

import java.util.stream.*;
import java.util.*;

public class StringStreamProblems {

    public static int findLengthBetweenString(String a, String b, String c){

        int index1 = a.indexOf(b);
        int index2 = a.indexOf(c);
        return (index2 - index1 - 1);
    }

    public static void findLengthBetweenStringUsingStreams(String a, String b, String c){
        Stream.of(a).forEach(x -> System.out.println(x.indexOf(c) - x.indexOf(b) - 1));
    }

    public static void reverseEachWordsInAString(String a){
        String[] result1 = a.split("\\s");
        List<String> array = Arrays.asList(result1);
        array.stream().map(x -> new StringBuilder(x).reverse().toString()).forEach(x -> System.out.print(x + " "));
    }

    public static String reverseEachWordsInAGivenStringUsingLoop(String a){
        String[] array = a.split("\\s");
        StringBuilder result = new StringBuilder();
        for (String word : array) {
            StringBuilder reverseWord = new StringBuilder();
            for (int j = word.length() - 1; j >= 0; j--) {
                reverseWord.append(word.charAt(j));
            }
            result.append(reverseWord).append(" ");
        }
        return result.toString();
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        /*
         * Two problems
         * 1. Find the length of String a between String b and String c
         * 2. Reverse Each word in a given String.
         *
         *  Two approaches used General approach and Java Streams API...
         */
        String a = "The Java is most toughest language in the world";
        String b = "is";
        String c = "in";
        int result = findLengthBetweenString(a, b, c);
        System.out.println(result);
        // output: 22
        findLengthBetweenStringUsingStreams(a, b, c);
        //output : 22
         reverseEachWordsInAString(a);
        // output: ehT avaJ si tsom hguot egaugnal ni dlrow
        String reverseString = reverseEachWordsInAGivenStringUsingLoop(a);
        System.out.println(reverseString);
        // output: ehT avaJ si tsom hguot egaugnal ni dlrow
    }
}
