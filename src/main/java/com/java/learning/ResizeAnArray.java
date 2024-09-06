package com.java.learning;

import java.util.Arrays;

public class ResizeAnArray {
    public static int[] resizeArray(int[] a, int capacity){
        int[] temp = new int[capacity];
        for(int i = 0; i < a.length; i++){
            temp[i] = a[i];
        }
        a = temp;
        return a;
    }
    public static void main(String[] args) {
        int[] original = {5, 6, 8, 9, 2, 10};
        int[] resize = resizeArray(original, 20);
        System.out.println(Arrays.toString(resize));
    }
}
