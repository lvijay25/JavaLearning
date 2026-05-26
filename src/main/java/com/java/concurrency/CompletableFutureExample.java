package com.java.concurrency;

import java.util.concurrent.*;

public class CompletableFutureExample {

    public static void main(String... args) throws Exception{

        Runnable command = null;
        try {
            command = () -> System.out.println("Runnable in Try Catch Block");
            command.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Executor executors = CompletableFuture.delayedExecutor(3, TimeUnit.SECONDS);
        executors.execute(command);

        Runnable runnable = () -> {
            System.out.println("Runnable Outside Try Catch Block");
            for(int i = 0; i < 5; i++){
                System.out.println("Scheduler Thread - " + i);
            }
        };

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        try {
            scheduler.schedule(runnable, 5, TimeUnit.SECONDS);
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            scheduler.shutdown();
        }
    }
}
