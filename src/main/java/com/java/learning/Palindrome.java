package com.java.learning;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

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

    public static boolean palindromeUsingStream(String word){
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
       // Matcher matcher = pattern.matcher(word);
        // boolean check = matcher.matches();
        String strCheck = word.replaceAll(String.valueOf(pattern), "").toLowerCase();
        System.out.println(strCheck);
        return IntStream.range(0, strCheck.length()/2).noneMatch(i -> strCheck.charAt(i) != strCheck.charAt(strCheck.length() - i - 1));
    }

    public static void main(String[] args){
        boolean palindrome = palindrome("lol");
        System.out.println(palindrome);

        String str = "Hello@World#2024!";
        boolean palindromecheck = palindromeUsingStream(str);
        System.out.println(palindromecheck);
    }
}
