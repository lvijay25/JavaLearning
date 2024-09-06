package com.java.patternproblems;

public class PyramidPattern {
    public static void pyramidPattern(int n) {
        int i, j;
        for (i = 0; i < n; i++) {
            System.out.print(" ");
            for (j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        pyramidPattern(5);
    }
}
