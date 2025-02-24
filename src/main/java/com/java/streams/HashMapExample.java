package com.java.streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class HashMapExample {
    public static void main(String[] args){
        Map<Integer, String> data = new HashMap<>();

        data.put(100, "Daniel");
        data.put(101, "Ferdinand");
        data.put(102, "John Harrigan");
        data.put(103, "Becky");
       /* for(Map.Entry<Integer, String> d : data.entrySet()){
            System.out.println(d.getKey() + " " + d.getValue());
        }*/

        Map<String, Integer> el = new HashMap<>();

        el.put("Daniel", 10000);
        el.put("Ferdinand", 10100);
        el.put("John Harrigan", 102000);
        el.put("Becky", 103002);

        Integer s = el.entrySet().stream().map(Map.Entry::getValue)
                        .max(Integer::compareTo).orElse(null);

        Integer s1 = el.entrySet().stream().map(Map.Entry::getValue)
                .reduce(1, Integer::compareTo);

        System.out.println(s1);
    }
}
