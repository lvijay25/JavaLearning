package com.java.streams;

import java.util.HashMap;
import java.util.Map;

class Employee1 {

    private String name;
    private double salary;

    public Employee1(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee {name='" + name + "', salary=" + salary + '}';
    }
}
public class HighestSalaryUsingHashMap {
    public static void main (String[] args) throws java.lang.Exception
    {
        Map<String, Integer> map = new HashMap<>();

        map.put("Vijay", 20000);
        map.put("Nolan", 13000);
        map.put("David", 25000);
        map.put("John Harrigan", 30000);
        map.put("Ajay", 40000);
        map.put("Philip White", 50000);

        Integer output = map.values().stream()
                .max(Integer::compare).orElse(null);
        System.out.println("Max Salary: " + output);
    }
}
