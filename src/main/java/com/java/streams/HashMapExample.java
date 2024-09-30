package com.java.streams;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args){
        Map<Integer, String> data = new HashMap<>();

        data.put(100, "Daniel");
        data.put(101, "Ferdinand");
        data.put(102, "John Harrigan");
        data.put(102, "John Harrigan");
        for(Map.Entry<Integer, String> d : data.entrySet()){
            System.out.println(d.getKey() + " " + d.getValue());
        }
    }
}
