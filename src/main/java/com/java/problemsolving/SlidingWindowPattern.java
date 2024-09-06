package com.java.problemsolving;

import java.util.Scanner;
import java.util.LinkedList;

public class SlidingWindowPattern {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int[] array = new int[scanner.nextInt()];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(" arr[]: { ");

        for (int i = 0; i < array.length; i++) {
            System.out.println(" " + array[i]);
        }

        System.out.println(" } ");

        int slidingWindow = scanner.nextInt();

        slidingWindowAlgorithm(array, slidingWindow);

    }

    public static void slidingWindowAlgorithm(int[] array, int k) {

        LinkedList<Integer> linkedlist = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {

        }

    }

}
