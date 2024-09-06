package com.java.learning;

import java.util.*;

public class FindDuplicates {

    public static int findDuplicates2(int[] array){

        int duplicate = 0;
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[duplicate] == array[i]){
                duplicate = array[i];

            }
        }
        return duplicate;
    }

    public static int findDuplicates(int[] array){
        int count = 0;
        for(int i : array){
            if(i == array[i]){
                System.out.println(i);
            }
            count++;
        }
        return count;
    }
    public static void findDuplicate(int[] array){

        Set<Integer> duplicate = new HashSet<Integer>();

        for(Integer set : array){
            if(!duplicate.add(set)){
                System.out.println(" Duplicates " + set);
            }
        }
    }

    public static void findingDuplicates(int[] array){

        Set<Integer> duplicate = new LinkedHashSet<>();

        for(Integer elements : array){
            if(!duplicate.add(elements)){
                System.out.println(new StringBuilder().append("Duplicates ").append(elements).toString());
            }
        }
    }

    public static StringBuilder getDuplicateString(String s){
        char[] ch = s.toCharArray();
        Set<Character> elements = new LinkedHashSet<>();
        StringBuilder builder = new StringBuilder();
        for(Character charCh : ch){
            if(!elements.add(charCh)){
                builder.append(charCh).append(", ");
            }
        }
        return builder;
    }
    public static void duplicatesStringCount(String s){
        char[] ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(Character chars : ch) {
            map.merge(chars, 1, Integer::sum);
        }
        for(Map.Entry<Character, Integer> m : map.entrySet()){
            if(m.getValue() > 1) {
                System.out.println("Duplicate Chars " + m.getKey() + " Count " + m.getValue());
            }
        }
    }

    public static void main(String[] args){

        int[] array = {2, 4, 5, 6, 4, 5, 4, 6};

       // FindDuplicates.findDuplicate(array);

      //  FindDuplicates.findDuplicates(array);

        FindDuplicates.findingDuplicates(array);

        System.out.println("Duplicates in String " + FindDuplicates.getDuplicateString("Javaammala"));

      //  System.out.println("duplicates " + FindDuplicates.findDuplicates2(array));
        Set<Integer> number = new LinkedHashSet<>();

        number.add(22);
        number.add(12);
        number.add(44);
        number.add(23);
        number.add(55);
        System.out.println(number.remove(22));
        System.out.println(number);

        String duplicate = "Bharat,India,Hindustan";
        duplicatesStringCount(duplicate);

    }
}
