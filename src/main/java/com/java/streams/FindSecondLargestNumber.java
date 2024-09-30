package com.java.streams;

import java.util.*;

public class FindSecondLargestNumber {

    public static void main(String[] args){
        int[] a = {2, 3, 4, 8, 9, 10, 1, 5, 6, 7};

        int data = Arrays.stream(a).boxed().sorted(Comparator.reverseOrder())
                             .distinct().skip(1).findFirst().get();

        System.out.println(" Second Largest Number " + data);

        int[] a1 = {2, 3, 4, 8, 9, 10, 1, 5, 6, 7};

        OptionalInt data1 = Arrays.stream(a1).sorted().distinct().reduce((one, two) -> two - 1);

        System.out.println(" Second Largest Number Using " + data1);
    }
}
