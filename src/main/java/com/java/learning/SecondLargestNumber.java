package com.java.learning;

public class SecondLargestNumber {
    public static int secondLargestNumber(int[] array){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int j : array) {
            if (j > max) {
                secondMax = max;
                max = j;
            } else if (j <= secondMax && j != max) {
                secondMax = j;
            }
        }
        return secondMax;
    }
    public static void main(String[] args){

        int[] array = {25, 6, 47, 10, 25, 64, 79};

        System.out.println(secondLargestNumber(array));
    }
}
