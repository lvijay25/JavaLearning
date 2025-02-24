package com.java.oops;

import java.util.List;

public class UpperBoundWildcard {
    /* Upper Bound WildCard can accept argument of all implemented classes of Number Interface
    *  Because UpperBound can be used only for read operations.
    * */
    public static void findNumber(List<? extends Number> numbers){
        for(Number n : numbers){
            System.out.print(n + " ");
        }
    }
    public static void main(String[] args){
        List<Integer> list = List.of(1, 2, 6, 4, 8, 9, 10, 11);
        findNumber(list);
    }
}
