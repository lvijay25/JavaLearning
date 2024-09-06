package com.java.collectionstreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PairSum {

    public static List<int[]> pairSum(int[] a, int sum){
        return IntStream.range(0, a.length).boxed()
                            .flatMap(i -> IntStream.range(i + 1, a.length)
                            .filter(j -> i != j && a[i] + a[j] == sum).mapToObj(j -> new int[]{a[i], a[j]}))
                            .collect(Collectors.toList());
    }
    public static void main(String[] args){
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int findSum = 8;
        pairSum(a, findSum).forEach(pair -> System.out.println(Arrays.toString(pair)));
    }
}
