package com.java.problemsolving;

import com.sun.jdi.IntegerValue;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstringLeetCode {

    public static String minimumWindowSubString(String str, String t){

        if(str == null || t == null || str.length() < t.length()){
            return "";
        }

        Map<Character, Integer> mapChar = new HashMap<>();
        char[] ch = t.toCharArray();
        for(char c : ch){
            mapChar.put(c, mapChar.getOrDefault(c, 0) + 1);
        }
        // Initializing two pointer approach
        int right = 0, left = 0, minLeft = 0, minLen = Integer.MAX_VALUE, count = 0;
        while(right < str.length()){
            char rChar = str.charAt(right);
            if(mapChar.containsKey(rChar)){
                mapChar.put(rChar, mapChar.get(rChar) - 1);
                if(mapChar.get(rChar) >= 0){
                    count++;
                }
            }
            right++;

            while(count == t.length()) {
                if ((right - left) < minLen) {
                    minLeft = left;
                    minLen = right - left;
                }
                char lChar = str.charAt(left);
                if (mapChar.containsKey(lChar)) {
                    mapChar.put(lChar, mapChar.get(lChar) + 1);
                    if (mapChar.get(lChar) > 0)
                        count--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : str.substring(minLeft, minLeft + minLen);
    }

    public static void main(String... args){
        String str = "ADOBECODEBANC", t = "ABC";
        String output = minimumWindowSubString(str, t);
        System.out.println("MinimumWindowSubString: " + output);
    }
}

