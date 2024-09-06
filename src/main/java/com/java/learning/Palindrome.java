package com.java.learning;

public class Palindrome {
    public static boolean palindrome(String word){
        char[] ch = word.toCharArray();
        int start = 0;
        int end = word.length() - 1;
        while(start < end) {
            if (ch[start] != ch[end]) {
                return false;
            }
            start++;
            end--;
        }
         return true;
    }

    public static void main(String[] args){
        boolean palindrome = palindrome("lol");
        System.out.println(palindrome);
    }
}
