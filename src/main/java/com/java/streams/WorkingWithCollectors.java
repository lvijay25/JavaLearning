package com.java.streams;

import com.java.oops.Person;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class WorkingWithCollectors {

    public static List<Person> createPerson(){
        return List.of(new Person("John", 25),
                new Person("John", 36),
                new Person("Becky", 18),
                new Person("Jack", 63),
                new Person("Bob", 41),
                new Person("KA Paul", 23),
                new Person("Sarah", 58));
    }

    public static void main(String[] args){

        Map<String, List<Integer>> mappingPerson = createPerson().stream()
                .collect(groupingBy(Person::getName, mapping(Person::getAge, toList())));

        System.out.println(mappingPerson);

        Integer output = createPerson().stream()
                .map(Person::getAge)
                .reduce(0, (e1, e2) -> e1 > e2 ? e1 : e2);
        System.out.println(output);

    }
}
