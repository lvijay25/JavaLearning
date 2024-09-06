package com.java.problemsolving;

import java.util.*;
import java.util.HashSet;

public class SubArrayProblems {

        public static void pairSum(int[] arr, int sum){

            for(int i = 0; i < arr.length - 1; i++){
                int j = i + 1;
                if(arr[i] + arr[j] == sum){
                    System.out.printf("Pair Program (%d, %d) ", arr[i], arr[j]);
                    return;
                }
            }
            System.out.println("Pair not found");
        }

        public static boolean subArrayWithZero(int[] array){
            Set<Integer> set = new HashSet<>();
            set.add(0);
            int sum = 0;
            for(int value : array){
                sum += value;
                System.out.println(sum);
                if(set.contains(sum)){
                    return true;
                }
                set.add(sum);
            }
            return false;
        }

        public static void printAllSubArrayWithZeroSum(int[] array){
            for(int i = 0; i < array.length - 1; i++){
                int j = i + 1;
                if(array[i] + array[j] == 0){
                    System.out.printf("SubArray with leading zero [%d, %d] ", array[i], array[j]);
                }
            }
        }

        public static void main(String[] args) {
            int[] arr = {4, 2, 3, 4, 5, 6, 8, 9, 7};
            // Required ----> ----> ---->
            pairSum(arr, 5);
            int[] arr1 = {4, 2, 5, 8};
            boolean value = subArrayWithZero(arr1);
            System.out.println("Sub-Array contains : " + value);
            int[] arr2 = {5, 4, 1, 5, 3, 6, 0, 0};
            printAllSubArrayWithZeroSum(arr2);
        }
}
