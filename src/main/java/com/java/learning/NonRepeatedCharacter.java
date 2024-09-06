package com.java.learning;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeatedCharacter {

    public static void main(String[] args){

        String input = "The Way of World Work";

        List<Character> st = input.chars()
                .mapToObj(i -> Character.toLowerCase((char) i))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() != 1L)
                .map(Map.Entry::getKey).collect(Collectors.toList());

        System.out.println(st);

      // input.chars().forEach(i -> System.out.print((char)i));

        String inputs = "team";

        Set<Character> sets = inputs.chars().mapToObj(c -> Character.toLowerCase((char)c)).collect(Collectors.toSet());
        System.out.println(sets);

        String input2 = "teamteamsmmss";

        List<Character> char1 = input2.chars().mapToObj(c -> Character.toLowerCase((char) c))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() != 1L).map(Map.Entry::getKey).collect(Collectors.toList());

        System.out.println("represents string " + char1);

        String input3 = "teamteamsmmss";

        List<Character> ls = input3.chars().mapToObj(ch -> Character.toLowerCase((char)ch))
                .sorted((e1, e2) -> {System.out.printf("Sorted %s;%s\n", e1, e2);
                 return e1.compareTo(e2);
                }).collect(Collectors.toList());

        System.out.println(ls);

        String input4 = "MaheshKumar";

        input4.chars()
                .mapToObj(c -> Character.toLowerCase((char)c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().forEach(x -> System.out.println(x + " times"));

       // System.out.println("Output");


        String input5 = "whosewho";
        char[] ch = input5.toCharArray();
        HashMap<Character, Integer> element = new HashMap<>();
        for(char c : ch){
            c = Character.toLowerCase(c);
            if(element.containsKey(c)){
                element.put(c, element.get(c) + 1);
            }else{
                element.put(c, 1);
            }
        }
        for(Map.Entry<Character, Integer> character : element.entrySet()){
            if(character.getValue() == 1){
                System.out.println(character.getKey() + " count " + character.getValue());
            }
        }
        /* ***** Another program **** */

        // removed entrySet method and added two parameters in foreach method

        "stress".chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .forEach(System.out::println);
                //.forEach((x, y) -> System.out.println(x + " " + y));
    }

}
