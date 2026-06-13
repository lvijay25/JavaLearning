package com.java.coding_problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindMissingNumber {
    // bruteforce method to find single digit
    public static int findMissingNumber(int[] array){
        int n = array.length + 1;
        int sum = n * (n + 1) / 2;

        for(int num : array){
            sum = sum - num;
        }
        return sum;
    }
    /* Using HashSet Approach */
    public static String findMissingNumberUsingHashSet(int[] array){
        int max = Arrays.stream(array).max().getAsInt();
        Set<Integer> original = new HashSet<>();
        Set<Integer> copy = new HashSet<>();
        for(int i : array){
            original.add(i);
        }
        for(int i = 1; i < max; i++){
            if(!original.contains(i)){
                copy.add(i);
            }
        }
       // original.removeAll(copy);
        return Arrays.toString(copy.toArray());
    }
    public static void main(String[] args){
        int[] array = {1, 2, 3, 4, 6, 8, 7};
        int missingNumber = findMissingNumber(array);
     //   System.out.println(missingNumber);
        String missingValue = findMissingNumberUsingHashSet(array);
        System.out.println(missingValue);
    }
}
