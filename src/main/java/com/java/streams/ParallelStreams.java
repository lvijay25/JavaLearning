package com.java.streams;

import java.util.List;
import java.util.stream.Stream;

public class ParallelStreams {
    public static void main(String[] rider){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8);

        stream.parallel().peek(System.out::print).forEachOrdered(System.out::print);

        List<String> list = List.of("A", "B", "C", "D");

        list.stream().peek(System.out::print).forEach(System.out::println);

        List<?> data = List.of(20, 30, 40, "10");

        String s1 = "James";
        String s2 = "James";

        StringBuilder s3 = new StringBuilder("James");
        StringBuffer s22 = new StringBuffer("James");

        if(s1.equals(s3.toString())){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
