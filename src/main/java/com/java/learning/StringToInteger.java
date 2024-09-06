package com.java.learning;

public class StringToInteger {
    public static void main(String[] args){
        String s = "1253";
        int n = Integer.parseInt(s) + 153;
        char c = '0';
        int m = Character.digit(c, 2);
        System.out.println(m);

    }
}
