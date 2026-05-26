package com.java.algorithms;

public class KadaneAlgorithm {

    public static int maxSubArraySum(int[] array) {

        int finalMaxValue = array[0];
        int currentMaxValue = array[0];

        for (int i = 1; i < array.length; i++) {
            // Add the current index + next element
            currentMaxValue = Math.max(array[i], currentMaxValue + array[i]);
            // Compare max value and Update final max value.
            finalMaxValue = Math.max(finalMaxValue, currentMaxValue);
        }
        return finalMaxValue;

    }

    public static void main(String[] args) {

        // Find the Maximum Sub Array Sum

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Maximum contiguous sum is: " + maxSubArraySum(arr));

    }
}
