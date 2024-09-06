package com.java.concurrency;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.*;
import java.util.Map;

class Counter{
    private int count = 0;

    public int increment(){
        count++;
        return count;
    }
}

class Counter1 {
    protected long count = 0;

    public void add(long value){
        this.count = this.count + value;
    }
}

public class ConcurrentHashMapProgram {

    private Map<Integer, Integer> frequency = new HashMap<>();

    public void setup(int num1, int num2){
        frequency.put(num1, num2);
        for(Map.Entry<Integer, Integer> m : frequency.entrySet()){
            System.out.println(m.getKey() + "  " + m.getValue());
        }
    }

    public static void main(String[] args){
        ConcurrentHashMapProgram hashMapProgram = new ConcurrentHashMapProgram();
        hashMapProgram.setup(10, 20);

        Counter counter = new Counter();

        Thread thread1 = new Thread(()->{
            for(int i = 0; i < 1000; i++){
                counter.increment();
            }
        });
        Thread thread2 = new Thread(()->{
            for(int i = 0; i < 1000; i++){
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        Counter1 counter1 = new Counter1();

        Thread thread3 = new Thread(()->{
            counter1.add(10);
            System.out.println(counter1.count);
        });

        Thread thread4 = new Thread(()->{
            counter1.add(10);
            System.out.println(counter1.count);
        });
        thread3.start();
        thread4.start();

    }

}
