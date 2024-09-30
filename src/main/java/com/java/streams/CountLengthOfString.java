package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountLengthOfString {
    public static void main(String[] args){
        // asked in EPAM company
        List<String> input = Arrays.asList("Loki", "Thanos", "Hulk", "Ironman", "Loki");
        // {Loki=2, Thanos=1, Ironman=1, Hulk=1}
        Map<Integer, List<String>> countLenOfString = input.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(countLenOfString);

        countLenOfString.forEach((len, str) -> System.out.println(len + " " + str));

        countLenOfString.forEach((len, str) -> {
            Map<String, Long> ls = str.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            System.out.println(len + " " + ls);
        });

        List<String> input1 = Arrays.asList("Loki", "Thanos", "Hulk", "Ironman", "Loki");

        Map<String, Long> output1 = input1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> output2 = input1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(output1);
    }
}
