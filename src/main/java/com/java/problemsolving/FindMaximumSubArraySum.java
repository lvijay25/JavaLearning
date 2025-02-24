package com.java.problemsolving;

public class FindMaximumSubArraySum {
    public static int findMaxmiumSubArraySum(int[] array){
        if(array == null || array.length == 0){
            throw new IllegalArgumentException("Array should not be empty");
        }
        int len = array.length;
        int currentMax = array[0];
        int globalMax = array[0];
        for(int i = 0; i < len; i++){
            currentMax = Integer.max(array[i], currentMax + array[i]);
            if(currentMax > globalMax){
                globalMax = currentMax;
            }
        }
        return globalMax;
    }

    public static void main(String[] args){
        int[] array = {-2, 3, 1, 5, -4, 6, -2, 8, -1};
        int maxSubArray = findMaxmiumSubArraySum(array);
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray);
        System.out.println(findMaxmiumSubArraySum(a));
    }
}
