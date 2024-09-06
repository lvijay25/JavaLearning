package com.java.problemsolving;

import java.util.HashSet;
import java.util.Set;

public class FindMissingNumber {
    /** There are two approaches to solve this problem.
     * Brute Force method which finds only single missing value
     * Another method uses HashSet to find multiple missing values.
     */

    // BruteForce method...
    public static int findMissingNumber(int[] a){
        int n = a.length + 1;
        int sum = n * (n + 1) / 2;
        for(int num : a){
            sum = sum - num;
        }
        return sum;
    }
    // HashSet method Impl....

    public static Set<Integer> findMissingNumber(int[] a, int n) {
        Set<Integer> allNumbers = new HashSet<>();
        Set<Integer> presentNumber = new HashSet<>();
        for(int i = 1; i <= n; i++) allNumbers.add(i);
        for(int k : a) presentNumber.add(k);
        allNumbers.removeAll(presentNumber);
        return allNumbers;
    }

    public static void main(String[] args){
        int[] a = {2, 3, 5, 7, 8, 10, 1, 6, 4};
        System.out.println(findMissingNumber(a));

        int[] a1 = {2, 3, 5, 7, 8, 10, 1, 6, 4};
        System.out.println(findMissingNumber(a1, 15));

    }
}
