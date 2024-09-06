package com.java.concurrency;

import java.util.concurrent.*;

public class CompletableFutureExample {

    public static void main(String... args) throws Exception{

        Runnable command = null;
        try {
            command = () -> System.out.println("Hello");
            command.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Executor executors = CompletableFuture.delayedExecutor(1, TimeUnit.MINUTES);
        executors.execute(command);

        Runnable runnable = () -> {
            System.out.println("Hello");
            for(int i = 0; i < 5; i++){
                System.out.println("schedule thread " + i);
            }
        };
        Executors.newScheduledThreadPool(1).schedule(runnable, 1, TimeUnit.SECONDS);
    }
}
