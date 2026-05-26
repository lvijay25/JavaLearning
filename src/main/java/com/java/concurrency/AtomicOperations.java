package com.java.concurrency;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicOperations {

    private AtomicLong counter = new AtomicLong(0);

    public long count(){
        return counter.get();
    }

    public static void main(String[] args) throws InterruptedException {

        AtomicOperations atomicOperations = new AtomicOperations();

        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
               atomicOperations.counter.incrementAndGet();
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                atomicOperations.counter.incrementAndGet();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Thread Safe Atomic Operation:- " + atomicOperations.count());

    }
}
