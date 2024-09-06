package com.sortalgorithms;

public class ShellSortAlgorithm<T> {
    public void sort(Comparable<T>[] a){
        int N = a.length;
        int h = 1;
        while(h < N/3) h = 3 * h + 1;
        while(h >= 1) {
            for(int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }
            }
            h = h/3;
        }
    }

    public static <T> boolean less(Comparable<T> v, Comparable<T> w){
        return v.compareTo((T)w) < 0;
    }

    public static <T> void exchange(Comparable<T>[] a, int i , int j){
        Comparable<T> t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void printSorted(Comparable<T>[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print("\"" + a[i] + "\"" + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] a = {14, 2, 13, 12, 15, 1, 3, 7, 5, 4, 6, 9, 8, 10, 11};

       // String[] s = {"S", "A", "M", "P", "L", "E", "T", "E", "S", "T"};

        String[] s = {"Sicorio", "London", "Manchester", "Poland", "Lexingburg", "Europe", "Taiwan", "England", "Switzerland"};

        ShellSortAlgorithm<Integer> shellSortAlgorithm = new ShellSortAlgorithm<>();
        shellSortAlgorithm.printSorted(a);
        shellSortAlgorithm.sort(a);
        shellSortAlgorithm.printSorted(a);

        ShellSortAlgorithm<String> shellSortAlgorithm1 = new ShellSortAlgorithm<>();
        shellSortAlgorithm1.printSorted(s);
        shellSortAlgorithm1.sort(s);
        shellSortAlgorithm1.printSorted(s);
    }
}
