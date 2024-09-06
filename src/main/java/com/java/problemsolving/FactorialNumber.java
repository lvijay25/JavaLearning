package com.java.problemsolving;

import java.util.Scanner;

public class FactorialNumber {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number.. ");

        int num = scanner.nextInt();

        long factorial = 1;

        for(int i = 1; i <= num; i++){
            factorial *= i;
        }
        System.out.println("Factorial of " + num + " is: " + factorial);

        int s = 2 * 3 * 4 * 5;

        System.out.println("Factorial " + s);

    }
}
