package com.java.streams;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee implements Comparable<Employee>{

    private int id;
    private String firstName;
    private String lastName;

    public Employee(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.getId(), o.getId());
    }
}

public class ComparableExample {

    public static void main(String[] args){

        List<Employee> list = new ArrayList<Employee>();

        Employee com1 = new Employee(2, "Aravind", "Kumar");
        Employee com2 = new Employee(3, "Hari", "Kumar");
        Employee com3 = new Employee(1, "Santhosh", "Kumar");

        list.add(com1);
        list.add(com2);
        list.add(com3);

        Collections.sort(list);

        for(Employee employee : list){
            System.out.println(employee.getId() + " " + employee.getFirstName() + " " + employee.getLastName());
        }

        List<Player> footballTeam = new ArrayList<>();
        Player player1 = new Player(59, "John", 20);
        Player player2 = new Player(67, "Roger", 22);
        Player player3 = new Player(45, "Steven", 24);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);

        System.out.println("Before Sorting : " + footballTeam);
        Collections.sort(footballTeam);
        System.out.println("After Sorting : " + footballTeam);

    }

}
