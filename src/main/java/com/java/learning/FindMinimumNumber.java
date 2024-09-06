package com.java.learning;

public class FindMinimumNumber {
    public static int findMinimumNumber(int[] a){
        int min = a[0];
        for(int i = 0; i < a.length; i++){
            if(a[i] < min){
                min = a[i];
            }
        }
        return min;
    }

    public static void main(String[] args){
        int[] a = {12, 50, 68, 33, 47, 88};
        System.out.println(findMinimumNumber(a));
    }
}
