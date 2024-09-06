package com.java.learning;

import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;

public class RepeatedElements {
    public static int repeatedNumber(int[] a){
        int duplicate = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = 1; j < i; j++){
                if(a[i] == a[j]) {
                    duplicate = a[i];
                }
            }
        }
        return duplicate;
    }

    public static void duplicateNumber(int[] a){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int elements : a){
            map.merge(elements, 1, Integer::sum);
        }
        for(Map.Entry<Integer, Integer> duplicate : map.entrySet()){
            if(duplicate.getValue() > 1){
                System.out.println("Duplicate " + duplicate.getKey() + " count " + duplicate.getValue());
            }
        }
    }

    public static void duplicateNumber2(int[] a){
        Set<Integer> duplicates = new HashSet<>();
        Set<Integer> elements = Arrays.stream(a)
                .filter(i -> !duplicates.add(i)).boxed().collect(Collectors.toSet());
        System.out.println(elements);
    }

    public static void main(String[] args){
        int[] a = {1, 2, 2, 3, 4, 5, 8, 8};
        int n = repeatedNumber(a);
        System.out.println(n);
        duplicateNumber(a);
        duplicateNumber2(a);
    }
}
