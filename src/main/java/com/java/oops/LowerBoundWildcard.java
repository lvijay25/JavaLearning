package com.java.oops;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundWildcard {
    /* LowerBound refer to super type of unknown types
     * LowerBound used for write and need to cast for read operations.
     */
    public static void findNumber(List<? super Integer> numbers){
        numbers.add(10);
        numbers.add(20);
        numbers.forEach(num -> System.out.print(num + " "));
    }
    public static void main(String[] args){
      List<Number> list = List.of(1, 2, 6, 4, 8, 9, 10, 11);
      findNumber(new ArrayList<>(list));

    }
}
