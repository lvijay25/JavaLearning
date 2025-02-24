package com.java.streams;

import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.IntStream;

public class SumTwoLargestInteger {

    public static int sumTwoMaximumInteger(int[] a, long limitValue){
        IntStream streamOfInt = IntStream.of(a);
        return streamOfInt.boxed().sorted(Comparator.reverseOrder()).limit(limitValue)
                .mapToInt(Integer::valueOf).sum();
    }

    public static void main(String... args){
        int[] a = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        long limitValue = 3;
        int sum = sumTwoMaximumInteger(a, limitValue);
        System.out.println(sum);
    }
}
