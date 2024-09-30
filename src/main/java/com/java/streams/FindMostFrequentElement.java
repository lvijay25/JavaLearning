package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindMostFrequentElement {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);

        Optional<Map.Entry<Integer, Long>> outputNum = number.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue());

        outputNum.ifPresent(entry -> System.out.println(entry.getKey() + " Value present " + entry.getValue()));
        // output : "4 Value present 4";
        Map<Integer, Long> outNum = number.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(outNum); // output : {1=1, 2=2, 3=3, 4=4}

    }
}