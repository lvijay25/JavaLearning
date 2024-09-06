package com.java.learning;

public class FindMissingNumber {
    public static int findMissingNumber(int[] array){
        int n = array.length + 1;
        int sum = n * (n + 1) / 2;

        for(int num : array){
            sum = sum - num;
        }
        return sum;
    }
    public static void main(String[] args){
        int[] array = {1, 2, 3, 4, 6, 8, 7};
        int missingNumber = findMissingNumber(array);
        System.out.println(missingNumber);
    }
}
