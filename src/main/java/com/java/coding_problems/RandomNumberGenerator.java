package com.java.coding_problems;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomNumberGenerator {
    public static IntStream randomNumberGenerate(){
        return new Random().ints(1000, 9999);
    }
    public static void main(String... args){
        IntStream randomNum = randomNumberGenerate();
        System.out.println(randomNum);
    }
}
