package com.java.learning;

public class FibonacciSeries {
    public static void fibonacciSeries(int n){
        int first = 0;
        int second = 1;
        int current = 0;
        while(current < n){
            current = first + second;
            first = second;
            second = current;
            System.out.print(current + " ");
            // 0 + 1 = 1
            // 1 + 1 = 2
            // 1 + 2 = 3
            // 2 + 3 = 5
            // 3 + 5 = 8
            // 5 + 8 = 13
            // 8 + 13 = 21
            // 13 + 21 = 34

        }
    }
    public static void main(String[] args){

        //fibonacciSeries(5);
        fibonacciSeries(21);

    }
}
