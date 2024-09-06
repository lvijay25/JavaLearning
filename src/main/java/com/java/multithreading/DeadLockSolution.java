package com.java.multithreading;

public class DeadLockSolution {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args){
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread1.start();
        thread2.start();
    }

    private static class Thread1 extends Thread{
        @Override
        public void run(){
            synchronized (lock1){
                System.out.println("Thread-1 acquired lock-1");
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread-1 Interrupted...");
                }
                System.out.println("Thread-1 waiting for lock2");
                synchronized (lock2){
                    System.out.println("Thread-2 acquired lock-2");
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Thread-2 Interrupted...");
                    }
                }
                System.out.println("Thread-2 releases lock-1");
            }
            System.out.println("Thread-2 releases lock-2");
        }
    }

    private static class Thread2 extends Thread{
        @Override
        public void run(){
            synchronized (lock1){
                System.out.println("Thread-2 acquired lock-2");
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread-2 Interrupted...");
                }
                System.out.println("Thread-1 waiting for lock2");
                synchronized (lock2){
                    System.out.println("Thread-2 acquired lock-2");
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Thread-2 Interrupted...");
                    }
                }
                System.out.println("Thread-1 releases lock1");
            }
            System.out.println("Thread-1 releases lock2");
        }
    }
}
