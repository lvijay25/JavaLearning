package com.java.concurrency;

public class VolatileProgram {

    public static volatile int counter = 0;

    public static void main(String[] args){

        for(int i = 0; i < 10; i++){
            System.out.println(counter++);
        }
    }
}
