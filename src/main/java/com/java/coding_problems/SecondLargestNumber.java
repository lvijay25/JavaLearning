package com.java.coding_problems;

public class SecondLargestNumber {

    public static int largestNumberInAnArray(int[] array) {
        int largestValue = array[0];

        for(int i = 1; i < array.length; i++) {
            if(array[i] > largestValue){
                largestValue = array[i];
            }
        }
        return largestValue;
    }


    public static int secondLargestNumber(int[] array){
        int max = Integer.MIN_VALUE;;
        int secondMax = Integer.MIN_VALUE;;

        for (int j : array) {
            if (j > max) {
                secondMax = max;
                max = j;
            } else if (j > secondMax && j != max) {
                secondMax = j;
            }
        }
        return secondMax;
    }
    public static void main(String[] args){

        int[] array = {25, 6, 47, 10, 25, 64, 79};

        System.out.println("Second Largest Number " + secondLargestNumber(array));
        System.out.println("Largest Number " + largestNumberInAnArray(array));
    }
}
