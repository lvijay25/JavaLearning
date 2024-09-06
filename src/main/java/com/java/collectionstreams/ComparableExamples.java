package com.java.collectionstreams;

import java.util.*;
import java.util.stream.Collectors;

class ComparatorDemo {
    private int rollNo;
    private String firstName;
    private String lastName;

    public ComparatorDemo(int rollNo, String firstName, String lastName) {
        this.rollNo = rollNo;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
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
    public String toString(){
        return this.firstName + " " + this.lastName;
    }
}

class nameComparator implements Comparator<ComparatorDemo>{

    @Override
    public int compare(ComparatorDemo o1, ComparatorDemo o2) {
        if (o1.getFirstName().equals(o2.getFirstName())) {
           return 0;
        }else if(o1.getFirstName().length() > o2.getFirstName().length()){
            return 1;
        }else {
            return -1;
        }
    }
}

class nameComparator2 implements Comparator<ComparatorDemo>{

    @Override
    public int compare(ComparatorDemo o1, ComparatorDemo o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}


public class ComparableExamples {

    public static void main(String[] args){

        List<ComparatorDemo> comparatorDemo = new ArrayList<>();

        comparatorDemo.add(new ComparatorDemo(1001, "Vijay", "Kumar"));
        comparatorDemo.add(new ComparatorDemo(2002, "Regina", "Devin"));
        comparatorDemo.add(new ComparatorDemo(2003, "Johns", "Harrigan"));
        comparatorDemo.add(new ComparatorDemo(2004, "Amir", "Khan"));

       // comparatorDemo.sort(new nameComparator());
       // comparatorDemo.sort(new nameComparator2());

       // comparatorDemo.sort(Comparator.comparingInt(ComparatorDemo::getRollNo));
      // comparatorDemo.sort(Comparator.comparingInt(s -> s.getFirstName().length()));

        LinkedHashSet<ComparatorDemo> elements = comparatorDemo.stream()
                .sorted(Comparator.comparingInt(s -> s.getFirstName().length())).collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println(comparatorDemo);

        System.out.println("Elements " + elements);

    }

}
