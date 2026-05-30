package com.java.problemsolving;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindSecondHighestEmployeeSalary {

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee("Steve", 25, "Male", "Finance", 55000),
                new Employee("Stephen", 37, "Male", "IT", 25000),
                new Employee("Susan", 36, "Female", "HR", 36000),
                new Employee("Nolan", 22, "Male", "IT", 85000),
                new Employee("John", 30, "Male", "Finance", 88000),
                new Employee("Huz", 32, "Male", "IT Manager", 78000),
                new Employee("Jack Snyder", 38, "Male", "IT", 54000)
        );

        Map<Double, List<Employee>> secondHighestSalary = employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getSalary));

        System.out.println(secondHighestSalary);

    }
}
