package org.datastructures.arrays;

import java.util.ArrayList;

public class ArraysDemo {
    public static void main(String[] args){

        ArrayList<String> elements = new ArrayList<>();

        elements.add("John");
        elements.add("Ben");
        elements.add("Phil W");
        elements.add("Nolan");

        System.out.println(elements);

        for(String element : elements){
            System.out.print(element + " ");
        }

    }

}