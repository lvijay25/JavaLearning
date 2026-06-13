package com.java.coding_problems;

public class FibonacciSeries {

    public static int fibonacciRecursion(int num){
        if(num <= 1){
            return num;
        }
        return fibonacciRecursion(num - 2) + fibonacciRecursion(num - 1);
    }
    public static void fibonacciSeries(int n){
        int first = 0;
        int second = 1;
        int current = 0;
        while(current < n){
            current = first + second;
            first = second;
            second = current;
            System.out.print(current + " ");
        }
    }
    public static void main(String[] args){

        System.out.println("Recursion Method: " + fibonacciRecursion(21));
        fibonacciSeries(21);

    }
}
