package com.java.learning;

import java.util.Arrays;

public class MoveZeroToLast {

    public static void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static int[] moveZerosToLast(int[] array){
        int zeros = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] != 0 && array[zeros] == 0) {
                swap(array, i, zeros);
            }
            if(array[zeros] != 0){
                zeros++;
            }
        }
        return array;
    }
    public static int[] moveZerosToFirst(int[] array){
        int zeros = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == 0 && array[zeros] != 0) {
                swap(array, i, zeros);
            }
            if(array[zeros] == 0){
                zeros++;
            }
        }
        return array;
    }
    
    public static void main(String[] args){
        int[] array = {23, 0, 22, 36, 0, 85, 0, 55, 0};

        int[] printing = MoveZeroToLast.moveZerosToLast(array);
        System.out.println("0's moved to Last " + Arrays.toString(printing));

        int[] printings = MoveZeroToLast.moveZerosToFirst(array);
        System.out.println("0's moved to First " + Arrays.toString(printings));
    }
}
