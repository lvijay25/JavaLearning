package com.java.problemsolving;

public class CloneArray {
    public static void main(String[] args){

        /*
        Reinforcement
        R-1.1
        Suppose that we create an array A of GameEntry objects, which has an integer
        scores field, and we clone A and store the result in an array B. If we then
        immediately set A [4].score equal to 550, what is the score value of the
        GameEntry object referenced by B[4]?
         */
        int[] arrayA = {42, 25, 450, 36, 385, 145};
        int[] cloneA;
        cloneA = arrayA;
        cloneA[4] = 400;
        System.out.println(arrayA[4]);
    }
}
