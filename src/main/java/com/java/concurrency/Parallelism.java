package com.java.concurrency;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Parallelism {

    public static int transform(int numbers) {
        System.out.println(numbers + " " + Thread.currentThread());
        return numbers * 2;
    }

    public static void printIt(int numbers){
        System.out.println(numbers + " " + Thread.currentThread());
    }

    public static void process(Stream<Integer> stream) throws Exception{
        ForkJoinPool pool = new ForkJoinPool(10);
        pool.submit(() -> stream.forEach(e -> {}));
        pool.shutdown();
        pool.awaitTermination(30, TimeUnit.SECONDS);
    }

    public static int add(Integer total, Integer e){
        System.out.println("Total: " + total + " Value " + e + " " + Thread.currentThread());
        return  total + e;
    }

    public static void main(String... args) throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
                13, 14, 15, 16, 17, 18, 19, 20);

      //  numbers.stream().map(Parallelism::transform).forEach(Parallelism::printIt);

        ForkJoinPool pool = ForkJoinPool.commonPool();
        System.out.println(pool);
        /**
         * java.util.concurrent.ForkJoinPool@57fa26b7
         * [Running, parallelism = 3, size = 0, active = 0, running = 0, steals = 0, tasks = 0, submissions = 0]
         * Parallelism process has 3 core/threads - actual 4 cores.
         * but 1 core is allocated to run "Main Thread".
         */

        System.out.println("Number of Available Cores in System: " + Runtime.getRuntime().availableProcessors());

        Stream<Integer> stream = numbers.stream().parallel().map(Parallelism::transform);
        process(stream);

        pool.submit(() -> {
          int sum =  numbers.stream().reduce(0, Parallelism::add);
          System.out.println(sum);
        });

        pool.shutdown();;
        pool.awaitTermination(30, TimeUnit.SECONDS);

    }
}
