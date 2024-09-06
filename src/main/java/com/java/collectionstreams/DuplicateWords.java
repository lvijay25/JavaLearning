package com.java.collectionstreams;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class StreamsDuplicates{

    public static List<String> duplicateUsingStreams(List<String> list){
        return list.stream().distinct().map(String::toUpperCase).collect(Collectors.toList());
    }
}
public class DuplicateWords {
    public static void main(String... args){
        List<String> word = List.of("GFG", "Geeks", "for",
                "GeeksQuiz", "Geeks-for-Geeks", "Geeks", "for", "GFG", "GFG");
        /* RESULTS
           {Geeks-for-Geeks=1, for=2, Geeks=2, GFG=3, GeeksQuiz=1}
           for repeated 2
           Geeks repeated 2
           GFG repeated 3
         */

        List<String> listElements = StreamsDuplicates.duplicateUsingStreams(word);
        System.out.println("Duplicates " + listElements);

        List<String> words = List.of("Geeks", "GeeksOfGeeks", "Hello World", "MyWorld", "Geeks");

        Set<String> duplicates = new LinkedHashSet<>();

        for(String elements : words){
            if(!duplicates.add(elements)){
                System.out.println("Duplicates " + elements);
            }
        }
    }
}
