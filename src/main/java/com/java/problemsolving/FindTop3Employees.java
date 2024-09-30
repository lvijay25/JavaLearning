package com.java.problemsolving;

import java.util.*;
import java.lang.*;
import java.util.stream.*;
import java.util.Comparator;

class Employee
{
    String name;
    int age;
    String gender;
    String department;
    double salary;

    public Employee(String name, int age, String gender, String department, double salary){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
    }

    public int getAge(){
        return age;
    }

    public String getGender(){
        return gender;
    }

    public String getDepartment(){
        return department;
    }

    public double getSalary(){
        return salary;
    }

    @Override
    public String toString(){
        return "Employee {" + name + ", " + age + ", " + gender + ", " + ", " + department + ", " + salary + "}";
    }
}

public class FindTop3Employees {

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here

        List<Employee> list = Arrays.asList(
                new Employee("Steve", 25, "Male", "Finance", 55000),
                new Employee("Steve", 37, "Male", "IT", 25000),
                new Employee("Susan", 36, "Female", "HR", 36000),
                new Employee("Nolan", 22, "Male", "IT", 85000),
                new Employee("John", 30, "Male", "Finance", 88000),
                new Employee("Huz", 32, "Male", "IT Manager", 78000),
                new Employee("Loperz", 38, "Male", "IT", 54000),
                new Employee("Jene", 40, "Female", "HR", 69000),
                new Employee("Janani", 41, "Male", "HR", 98000),
                new Employee("Jocab", 46, "Male", "Finance", 15000),
                new Employee("Johnson", 41, "Male", "HR", 68000),
                new Employee("Jack Mobab", 33, "Male", "Finance", 36000));

	  /*for(Employee e : list){
		  System.out.println(e);
		}*/

        Map<String, List<Employee>> employeeList = list.stream()
                .filter(e -> e.getGender().equalsIgnoreCase("Male"))
                .filter(x -> x.getAge() >= 30 && x.getAge() <= 40)
                .collect(Collectors.groupingBy(Employee::getDepartment));

        Map<String, List<Employee>> empListByDept = new HashMap<>();

        employeeList.forEach((department, empList) -> {
            List<Employee> top3Emp = empList.stream()
                    .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                    .limit(3).collect(Collectors.toList());
            empListByDept.put(department, top3Emp);
        });

        empListByDept.forEach((department, top3Emp) -> {
            System.out.println("Department " + department);
            top3Emp.forEach(System.out::println);
        });
    }
}