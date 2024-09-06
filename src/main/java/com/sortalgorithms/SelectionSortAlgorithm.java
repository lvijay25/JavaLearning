package com.sortalgorithms;

public class SelectionSortAlgorithm{
    public static void sort(Comparable[] a){
        int low = 0;
        int N = a.length - 1;
        int min;

        for(int i = low; i < N; i++){
            min = i;
            for(int j = i + 1; j <= N; j++){
                if(less(a[j], a[min])) min = j;
                exchange(a, i, min);
            }
        }
    }

    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void exchange(Comparable[] a, int i , int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void printSorted(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print("\"" + a[i] + "\"" + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Integer[] a = {14, 2, 13, 14, 15, 1};

       // String[] s = {"S", "A", "M", "P", "L", "E", "T", "E", "S", "T"};
        sort(a);
        printSorted(a);
    }

}
