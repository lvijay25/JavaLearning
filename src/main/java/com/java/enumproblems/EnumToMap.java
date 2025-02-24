package com.java.enumproblems;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumToMap {
    enum Sizes{
        S(1),
        M(2),
        L(3);

        private final int size;

        Sizes(int size) {
            this.size = size;
        }

        int size() {
            return this.size;
        }
    }

    public static void main(String... args){
        Map<String, Integer> sizesToMap = Stream.of(Sizes.values())
                .collect(Collectors.toMap(Sizes::name, Sizes::size));

        System.out.println(sizesToMap);
    }
}
