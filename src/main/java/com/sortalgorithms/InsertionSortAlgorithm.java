package com.sortalgorithms;

public class InsertionSortAlgorithm {
    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i = 1; i < N; i++){
            for(int j = i; j > 0 && less(a[j], a[j - 1]); j--){
                exchange(a, j,j - 1);
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

    public static void main(String[] args) {
        Integer[] a = {14, 2, 13, 14, 15, 1, 3, 7, 5, 4, 6, 9, 8, 10, 11};

      //  String[] s = {"S", "A", "M", "P", "L", "E", "T", "E", "S", "T"};

        sort(a);
        printSorted(a);
    }
}
