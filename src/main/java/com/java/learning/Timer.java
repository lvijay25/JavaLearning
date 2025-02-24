package com.java.learning;

public class Timer {
    // Timer class
    public static void counter(Runnable block){
        long start = System.nanoTime();
        try{
            block.run();
        }finally {
            long end = System.nanoTime();
            System.out.println("Time taken(s): " + (end - start)/1.0e9);
        }
    }
}
