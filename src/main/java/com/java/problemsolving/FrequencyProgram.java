package com.java.problemsolving;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FrequencyProgram {
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");

    private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");

    private static Scanner scanner;

    public static String readAll() {
        if (!scanner.hasNextLine())
            return "";

        String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
        // not that important to reset delimiter, since now scanner is empty
        scanner.useDelimiter(WHITESPACE_PATTERN); // but let's do it anyway
        return result;
    }

    public static String[] readAllStrings(){
        String[] tokens = WHITESPACE_PATTERN.split(readAll());
        if(tokens.length == 0 || tokens[0].length() > 0)
            return tokens;

        String[] decapitokens = new String[tokens.length - 1];
        for(int i = 1; i < decapitokens.length - 1; i++){
            decapitokens[i] = tokens[i+1];
        }
        return decapitokens;
    }
    public static void main(String[] args){

        String[] a = FrequencyProgram.readAllStrings();
        int n = a.length;
        Arrays.sort(a);
        for(String s : a) System.out.print(s + " ");
    }
}
