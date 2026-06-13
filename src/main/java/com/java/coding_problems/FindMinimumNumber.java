package com.java.coding_problems;

public class FindMinimumNumber {
    public static int findMinimumNumber(int[] a) {
        int min = Integer.MIN_VALUE;
        for (int j : a) {
            if (min < j) {
                min = j;
            }
        }
        return min;
    }
    public static void main(String[] args){
        int[] a = {12, 50, 68, 33, 47, 88};
        System.out.println(findMinimumNumber(a));
    }
}
