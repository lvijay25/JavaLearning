package com.java.learning;

import java.util.Arrays;

public class ReverseArray {

    public static int[] reverseArray(int[] a){
        int start = 0;
        int end = a.length - 1;
        while(start < end){
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;

            start++;
            end--;
        }

        return a;
    }
    public static void main(String[] args){
        int[] a = {25, 10, 15, 36, 48, 98};
        int[] printer = reverseArray(a);
        System.out.println(Arrays.toString(printer));
    }
}
