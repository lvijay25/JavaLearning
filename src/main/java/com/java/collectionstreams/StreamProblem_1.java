package com.java.collectionstreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamProblem_1 {
    public static void main(String[] args) {

    List<Integer> input = List.of(1, 2, 2, 3, 4, 5, 6, 6, 6, 7, 8, 9, 9, 10, 10);

    List<Integer> output = input.stream()
            .filter(x -> x % 2 == 0)
            .map(n -> n * n).distinct()
            .peek(x -> System.out.print(x + " ")).collect(Collectors.toList());

    System.out.println(output);

//     this main program can cause this memory leak in java....

        int[] array = {1, 2, 3, 4, 5, 6, 7};

        Arrays.stream(array).reduce((x, y) -> x * y).stream().forEach(System.out::println);
    }
}
