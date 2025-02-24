package com.java.streams;

import com.java.oops.Person;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

public class CollectorsPartitionBy {

    public static List<Person> createPerson(){
        return List.of(new Person("John", 25),
                new Person("John", 36),
                new Person("Becky", 18),
                new Person("Jack", 63),
                new Person("Bob", 41),
                new Person("KA Paul", 23),
                new Person("Sarah", 58));
    }
    public static Map<Boolean, List<Person>> collectorsPartitionBy(List<Person> list){
        return list.stream().collect(partitioningBy(person -> person.getAge() > 25));
    }
    public static Map<Boolean, List<Person>> partitionByName(List<Person> list){
        return list.stream().collect(partitioningBy(person -> person.getName().length() > 5));
    }

    public static void main(String[] args){
        Map<Boolean, List<Person>> partitionByAge = collectorsPartitionBy(createPerson());
        System.out.println(partitionByAge);

        Map<Boolean, List<Person>> partitionByName = partitionByName(createPerson());
        System.out.println(partitionByName);
    }
}
