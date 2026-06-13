package com.java.concurrency;

public class VolatileUsageInConcurrency {

    public static volatile int counter = 0; // Wrong usage of Volatile

    /**
     * The semantics of volatile are not strong enough to make the increment operation (count++)
     * atomic, unless you can guarantee that the variable is written only from a single thread.
     * (Atomic variables do provide atomic read-modify-write support and can often be used as “better volatile variables”;
     * <p>
     * Locking can guarantee both visibility and atomicity;
     * volatile variables can only guarantee visibility.
     * <p>
     * You can use volatile variables only when all the following criteria are met:
     *  <li> Writes to the variable do not depend on its current value, or you can ensure that only a single thread ever updates the value;
     *  <li> The variable does not participate in invariants with other state variables; and
     *  <li> Locking is not required for any other reason while the variable is being accessed.
     *
     * <p>
     * Volatile variables are convenient, but they have limitations.
     * The most common use for volatile variables is as a completion, interruption,
     * or status flag, such as the asleep flag.
     *
     * @param args
     * author Concurrency in Practice.
     *
     */

    public static volatile boolean asleep;

    public static int countSheep;

    public static void main(String[] args) throws InterruptedException {

        for(int i = 0; i < 10; i++){
            System.out.println(counter++); // Wrong usage of Volatile
        }

        Thread thread1 = new Thread(() -> {
            if(Thread.interrupted()) {
                asleep = false;
            }
        });

        thread1.start();
        thread1.join();

        while(asleep) { // Correct Usage of Volatile as Flag
            System.out.println("Sheep Counting.. " + countSomeSheep());
        }

    }

    private static int countSomeSheep() {
        return countSheep++;
    }
}
